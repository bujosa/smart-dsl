package main

import (
	"fmt"

	"github.com/hyperledger/fabric-contract-api-go/contractapi"
)

type Receive struct {
	contractapi.Contract
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

func (sc *Receive) InitLedger(ctx contractapi.TransactionContextInterface) error {
	// Inicializa los valores de los atributos
	return nil
}

func main() {
	chaincode, err := contractapi.NewChaincode(&Receive{})
	if err != nil {
		fmt.Printf("Error creating Receive chaincode: %s", err.Error())
		return
	}

	if err := chaincode.Start(); err != nil {
		fmt.Printf("Error starting Receive chaincode: %s", err.Error())
	}
}
