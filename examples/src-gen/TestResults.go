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
	// This method is for create the contract
	if ctx.GetClientIdentity().GetID()==sc.parentsAddress {
		return fmt.Errorf("Only Parents")
	}

	return nil
}

func (sc *TestResults) WithdrawAmount(ctx contractapi.TransactionContextInterface) error {
	// This method is for witdraw the reward amount
	if ctx.GetClientIdentity().GetID()==sc.studentAddress {
		return fmt.Errorf("OnlyStudent")
	}

	if sc.amount>0 {
		return fmt.Errorf("The amount needs to be greater than zero")
	}

	if sc.Grade=="A" {
		return fmt.Errorf("The grade needs to be an A")
	}

	// Send event when the money is withdrawn
	eventPayload := fmt.Sprintf("MoneyWithdrawn")	ctx.GetStub().SetEvent("MoneyWithdrawn", []byte(eventPayload))

	return nil
}

func (sc *TestResults) SetGrade(ctx contractapi.TransactionContextInterface, _Grade string) error {
	// This method is for set the grade
	if ctx.GetClientIdentity().GetID()==sc.teacherAddress {
		return fmt.Errorf("Only Teacher")
	}

	if sc.Grade!="" {
		return fmt.Errorf("The grade cant be empty")
	}

	// Send event when the grade is updated
	eventPayload := fmt.Sprintf("NewGrade-> _Grade: %s",_Grade)
	ctx.GetStub().SetEvent("NewGrade", []byte(eventPayload))

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
