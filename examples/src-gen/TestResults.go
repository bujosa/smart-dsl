package main

import (
	"fmt"

	"github.com/hyperledger/fabric-contract-api-go/contractapi"
)

type TestResults struct {
	contractapi.Contract
	Grade string
	Amount uint64
	StudentAddress string
	TeacherAddress string
	ParentsAddress string
}

func (sc *TestResults) SetGrade(ctx contractapi.TransactionContextInterface, value string) error {
	sc.Grade = value
	return nil
}

func (sc *TestResults) GetGrade(ctx contractapi.TransactionContextInterface) (string, error) {
	return sc.Grade, nil
}

func (sc *TestResults) GetAmount(ctx contractapi.TransactionContextInterface) (uint64, error) {
	return sc.Amount, nil
}

func (sc *TestResults) GetStudentAddress(ctx contractapi.TransactionContextInterface) (string, error) {
	return sc.StudentAddress, nil
}

func (sc *TestResults) GetTeacherAddress(ctx contractapi.TransactionContextInterface) (string, error) {
	return sc.TeacherAddress, nil
}

func (sc *TestResults) GetParentsAddress(ctx contractapi.TransactionContextInterface) (string, error) {
	return sc.ParentsAddress, nil
}

func (sc *TestResults) InitLedger(ctx contractapi.TransactionContextInterface) error {
	// Inicializa los valores de los atributos
	sc.Grade = ""
	sc.Amount = 0
	sc.StudentAddress = ""
	sc.TeacherAddress = ""
	sc.ParentsAddress = ""
	return nil
}

func main() {
	chaincode, err := contractapi.NewChaincode(&TestResults{})
	if err != nil {
		fmt.Printf("Error creating TestResults chaincode: %s", err.Error())
		return
	}

	if err := chaincode.Start(); err != nil {
		fmt.Printf("Error starting TestResults chaincode: %s", err.Error())
	}
}
