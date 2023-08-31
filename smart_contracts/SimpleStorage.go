package main

import (
	"fmt"
	"strconv"

	"github.com/hyperledger/fabric-contract-api-go/contractapi"
)

type SimpleStorageContract struct {
	contractapi.Contract
	StoredData int
}

func (c *SimpleStorageContract) Set(ctx contractapi.TransactionContextInterface, value int) error {
	c.StoredData = value
	return ctx.GetStub().PutState("storedData", []byte(fmt.Sprintf("%d", value)))
}

func (c *SimpleStorageContract) Get(ctx contractapi.TransactionContextInterface) (int, error) {
	valueBytes, err := ctx.GetStub().GetState("storedData")
	if err != nil {
		return 0, err
	}
	if valueBytes == nil {
		return 0, fmt.Errorf("The value does not exist")
	}
	value := string(valueBytes)
	storedData, _ := strconv.Atoi(value)
	return storedData, nil
}

func main() {
	chaincode, err := contractapi.NewChaincode(&SimpleStorageContract{})
	if err != nil {
		fmt.Printf("Error creating SimpleStorageContract chaincode: %s", err.Error())
		return
	}

	if err := chaincode.Start(); err != nil {
		fmt.Printf("Error starting SimpleStorageContract chaincode: %s", err.Error())
	}
}
