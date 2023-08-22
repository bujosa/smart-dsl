package main

import (
	"fmt"

	"github.com/hyperledger/fabric-contract-api-go/contractapi"
)

type RentingSystem struct {
	contractapi.Contract
	landLord string
	tenant string
	location string
	name string
	rent uint64
}

func (sc *RentingSystem) GetLandLord(ctx contractapi.TransactionContextInterface) (string, error) {
	return sc.landLord, nil
}

func (sc *RentingSystem) GetTenant(ctx contractapi.TransactionContextInterface) (string, error) {
	return sc.tenant, nil
}

func (sc *RentingSystem) GetLocation(ctx contractapi.TransactionContextInterface) (string, error) {
	return sc.location, nil
}

func (sc *RentingSystem) GetName(ctx contractapi.TransactionContextInterface) (string, error) {
	return sc.name, nil
}

func (sc *RentingSystem) GetRent(ctx contractapi.TransactionContextInterface) (uint64, error) {
	return sc.rent, nil
}

func (sc *RentingSystem) SetRent(ctx contractapi.TransactionContextInterface, _rent uint64) error {
	// This operation is for set the new rent value
	if ctx.GetClientIdentity().GetID()==sc.landLord {
		return fmt.Errorf("Only LandLord")
	}

	return nil
}

func (sc *RentingSystem) PayRent(ctx contractapi.TransactionContextInterface) error {
	// This operation is for pay the rent
	if ctx.GetClientIdentity().GetID()==sc.tenant {
		return fmt.Errorf("Only Tenant")
	}

	return nil
}

func (sc *RentingSystem) InitLedger(ctx contractapi.TransactionContextInterface) error {
	sc.landLord = ""
	sc.tenant = ""
	sc.location = ""
	sc.name = ""
	sc.rent = 0
	return nil
}

func main() {
	chaincode, err := contractapi.NewChaincode(&RentingSystem{})
	if err != nil {
		fmt.Printf("Error creating RentingSystem chaincode: %s", err.Error())
		return
	}

	if err := chaincode.Start(); err != nil {
		fmt.Printf("Error starting RentingSystem chaincode: %s", err.Error())
	}
}
