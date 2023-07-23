package main

import (
	"fmt"

	"github.com/hyperledger/fabric-contract-api-go/contractapi"
)

type Receive struct {
	contractapi.Contract
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
