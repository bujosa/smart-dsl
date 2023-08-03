package main

import (
	"fmt"

	"github.com/hyperledger/fabric-contract-api-go/contractapi"
)

type SimpleContract struct {
	contractapi.Contract
	Owner string
	Total uint64
}

func (sc *SimpleContract) SetTotal(ctx contractapi.TransactionContextInterface, value uint64) error {
	sc.Total = value
	return nil
}

func (sc *SimpleContract) GetTotal(ctx contractapi.TransactionContextInterface) (uint64, error) {
	return sc.Total, nil
}

func (rc *SimpleContract) Example(ctx contractapi.TransactionContextInterface x uint64, name string, lastname string) error {
	// This is a sample of method
	if ctx.GetClientIdentity().GetID()==sc.Owner {
	return fmt.Errorf("Only the contract owner can call this function.")
}

	if x>4 {
	return fmt.Errorf("The number must be greater than 4")
}

	// Este evento es para notificar cuando el numero se ha actualizado
	eventPayload := fmt.Sprintf("XUpdated-> X: %d",x)
	ctx.GetStub().SetEvent("XUpdated", []byte(eventPayload))

	// Este evento es para notificar cuando el name se ha actualizado
	eventPayload := fmt.Sprintf("NameUpdated-> Name: %s",name)
	ctx.GetStub().SetEvent("NameUpdated", []byte(eventPayload))

	return nil
}

func (rc *ReceiveContract) Receive(ctx contractapi.TransactionContextInterface) error {
	args := ctx.GetStub().GetArgs()
	if len(args) > 0 {
		return fmt.Errorf("función Receive no acepta argumentos")
	}
	eventPayload := fmt.Sprintf("PaymentReceived: %s, Amount: %d", ctx.GetClientIdentity().GetID(), ctx.GetStub().GetTxID())
	ctx.GetStub().SetEvent("PaymentReceived", []byte(eventPayload))
	return nil
}

func (sc *SimpleContract) InitLedger(ctx contractapi.TransactionContextInterface) error {
	// Inicializa los valores de los atributos
	sc.Total = 0
	sc.Owner = ctx.GetClientIdentity().GetID()
	return nil
}

func main() {
	chaincode, err := contractapi.NewChaincode(&SimpleContract{})
	if err != nil {
		fmt.Printf("Error creating SimpleContract chaincode: %s", err.Error())
		return
	}

	if err := chaincode.Start(); err != nil {
		fmt.Printf("Error starting SimpleContract chaincode: %s", err.Error())
	}
}
