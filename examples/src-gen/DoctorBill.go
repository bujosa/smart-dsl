package main

import (
	"fmt"

	"github.com/hyperledger/fabric-contract-api-go/contractapi"
)

type DoctorBill struct {
	contractapi.Contract
}

func (sc *DoctorBill) InitLedger(ctx contractapi.TransactionContextInterface) error {
	return nil
}

func main() {
	chaincode, err := contractapi.NewChaincode(&DoctorBill{})
	if err != nil {
		fmt.Printf("Error creating DoctorBill chaincode: %s", err.Error())
		return
	}

	if err := chaincode.Start(); err != nil {
		fmt.Printf("Error starting DoctorBill chaincode: %s", err.Error())
	}
}
