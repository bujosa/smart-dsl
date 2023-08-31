package main

import (
	"fmt"
	"strconv"

	"github.com/hyperledger/fabric-contract-api-go/contractapi"
)

type SimpleContract struct {
	contractapi.Contract
	Value int
}

func (sc *SimpleContract) SetValue(ctx contractapi.TransactionContextInterface, value int) error {
	sc.Value = value
	return ctx.GetStub().PutState("value", []byte(fmt.Sprintf("%d", value)))
}

func (sc *SimpleContract) GetValue(ctx contractapi.TransactionContextInterface) (int, error) {
	valueBytes, err := ctx.GetStub().GetState("value")
	if err != nil {
		return 0, fmt.Errorf("Failed to read value from the world state: %v", err)
	}
	if valueBytes == nil {
		return 0, fmt.Errorf("The value does not exist")
	}
	value, _ := strconv.Atoi(string(valueBytes))
	return value, nil
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
