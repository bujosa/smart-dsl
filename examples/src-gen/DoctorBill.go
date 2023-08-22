package main

import (
	"fmt"

	"github.com/hyperledger/fabric-contract-api-go/contractapi"
)

type DoctorBill struct {
	contractapi.Contract
	insurer string
	doctor string
	patient string
	amount uint64
}

func (sc *DoctorBill) GetInsurer(ctx contractapi.TransactionContextInterface) (string, error) {
	return sc.insurer, nil
}

func (sc *DoctorBill) GetDoctor(ctx contractapi.TransactionContextInterface) (string, error) {
	return sc.doctor, nil
}

func (sc *DoctorBill) GetPatient(ctx contractapi.TransactionContextInterface) (string, error) {
	return sc.patient, nil
}

func (sc *DoctorBill) GetAmount(ctx contractapi.TransactionContextInterface) (uint64, error) {
	return sc.amount, nil
}

func (sc *DoctorBill) CreateInvoice(ctx contractapi.TransactionContextInterface) error {
	// This method is for create the invoice
	if ctx.GetClientIdentity().GetID()==sc.doctor {
		return fmt.Errorf("Only Doctor")
	}

	return nil
}

func (sc *DoctorBill) PayInvoice(ctx contractapi.TransactionContextInterface) error {
	// This method is for pay the invoice
	if ctx.GetClientIdentity().GetID()==sc.insurer {
		return fmt.Errorf("Only Insurer")
	}

	return nil
}

func (sc *DoctorBill) InitLedger(ctx contractapi.TransactionContextInterface) error {
	sc.insurer = ""
	sc.doctor = ""
	sc.patient = ""
	sc.amount = 0
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
