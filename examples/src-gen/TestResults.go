package main

import (
	"fmt"

	"github.com/hyperledger/fabric-contract-api-go/contractapi"
)

type TestResults struct {
	contractapi.Contract
	Grade string
	amount uint64
	studentAddress string
	teacherAddress string
	parentsAddress string
}

func (sc *TestResults) SetGrade(ctx contractapi.TransactionContextInterface, value string) error {
	sc.Grade = value
	return nil
}

func (sc *TestResults) GetGrade(ctx contractapi.TransactionContextInterface) (string, error) {
	return sc.Grade, nil
}

func (sc *TestResults) GetAmount(ctx contractapi.TransactionContextInterface) (uint64, error) {
	return sc.amount, nil
}

func (sc *TestResults) GetStudentAddress(ctx contractapi.TransactionContextInterface) (string, error) {
	return sc.studentAddress, nil
}

func (sc *TestResults) GetTeacherAddress(ctx contractapi.TransactionContextInterface) (string, error) {
	return sc.teacherAddress, nil
}

func (sc *TestResults) GetParentsAddress(ctx contractapi.TransactionContextInterface) (string, error) {
	return sc.parentsAddress, nil
}

func (sc *TestResults) CreateContract(ctx contractapi.TransactionContextInterface) error {
	// Este metodo es para crear un contracto
	if ctx.GetClientIdentity().GetID()==sc.teacherAddress {
		return fmt.Errorf("Only Teacher")
	}

	return nil
}

func (sc *TestResults) WithdrawAmount(ctx contractapi.TransactionContextInterface) error {
	// Este metodo es para retirar fondo
	if ctx.GetClientIdentity().GetID()==sc.studentAddress {
		return fmt.Errorf("OnlyStudent")
	}

	return nil
}

func (sc *TestResults) InitLedger(ctx contractapi.TransactionContextInterface) error {
	sc.Grade = ""
	sc.amount = 0
	sc.studentAddress = ""
	sc.teacherAddress = ""
	sc.parentsAddress = ""
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
