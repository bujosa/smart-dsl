package main

import (
	"fmt"

	"github.com/hyperledger/fabric-contract-api-go/contractapi"
)

type VehicleAuction struct {
	contractapi.Contract
	owner string
	bidder string
	name string
	bidAmount uint64
}

func (sc *VehicleAuction) GetOwner(ctx contractapi.TransactionContextInterface) (string, error) {
	return sc.owner, nil
}

func (sc *VehicleAuction) GetBidder(ctx contractapi.TransactionContextInterface) (string, error) {
	return sc.bidder, nil
}

func (sc *VehicleAuction) GetName(ctx contractapi.TransactionContextInterface) (string, error) {
	return sc.name, nil
}

func (sc *VehicleAuction) GetBidAmount(ctx contractapi.TransactionContextInterface) (uint64, error) {
	return sc.bidAmount, nil
}

func (sc *VehicleAuction) PlaceBid(ctx contractapi.TransactionContextInterface, newAmount uint64) error {
	// This operation if for bid
	if ctx.GetClientIdentity().GetID()==sc.bidder {
		return fmt.Errorf("Only Bidder")
	}

	return nil
}

func (sc *VehicleAuction) ChangeOwner(ctx contractapi.TransactionContextInterface, newOwner string) error {
	// This operation is only for change the owner
	if ctx.GetClientIdentity().GetID()==sc.owner {
		return fmt.Errorf("Only Owner")
	}

	return nil
}

func (sc *VehicleAuction) InitLedger(ctx contractapi.TransactionContextInterface) error {
	sc.owner = ""
	sc.bidder = ""
	sc.name = ""
	sc.bidAmount = 0
	return nil
}

func main() {
	chaincode, err := contractapi.NewChaincode(&VehicleAuction{})
	if err != nil {
		fmt.Printf("Error creating VehicleAuction chaincode: %s", err.Error())
		return
	}

	if err := chaincode.Start(); err != nil {
		fmt.Printf("Error starting VehicleAuction chaincode: %s", err.Error())
	}
}
