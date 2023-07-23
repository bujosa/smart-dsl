package main

import (
	"fmt"

	"github.com/hyperledger/fabric-contract-api-go/contractapi"
)

type SimpleContract struct {
	contractapi.Contract
	Total uint64
}

func (sc *SimpleContract) SetTotal(ctx contractapi.TransactionContextInterface, value uint64) error {
	sc.Total = value
	return nil
}

func (sc *SimpleContract) GetTotal(ctx contractapi.TransactionContextInterface) (uint64, error) {
	return sc.Total, nil
}

func (sc *SimpleContract) InitLedger(ctx contractapi.TransactionContextInterface) error {
	// Inicializa los valores de los atributos
	sc.Total = 0
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
