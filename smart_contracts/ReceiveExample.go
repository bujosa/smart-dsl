package main

import (
	"fmt"
	"github.com/hyperledger/fabric-contract-api-go/contractapi"
)

type MyContract struct {
	contractapi.Contract
}

type PaymentReceivedEvent struct {
	Sender string `json:"sender"`
	Amount uint   `json:"amount"`
}

func (mc *MyContract) Receive(ctx contractapi.TransactionContextInterface) error {
	eventPayload := PaymentReceivedEvent{
		Sender: ctx.GetClientIdentity().GetID(),
		Amount: ctx.GetStub().GetTransient().Get("amount").(uint),
	}

	eventPayloadJSON, err := json.Marshal(eventPayload)
	if err != nil {
		return fmt.Errorf("failed to marshal event payload: %v", err)
	}

	err = ctx.GetStub().SetEvent("PaymentReceived", eventPayloadJSON)
	if err != nil {
		return fmt.Errorf("failed to set event: %v", err)
	}

	return nil
}

func main() {
	chaincode, err := contractapi.NewChaincode(&MyContract{})
	if err != nil {
		fmt.Printf("Error creating MyContract chaincode: %s", err.Error())
		return
	}

	err = chaincode.Start()
	if err != nil {
		fmt.Printf("Error starting MyContract chaincode: %s", err.Error())
	}
}
