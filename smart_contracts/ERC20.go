package main

import (
	"fmt"

	"github.com/hyperledger/fabric-contract-api-go/contractapi"
)

type ERC20Contract struct {
	contractapi.Contract
}

type Token struct {
	ID     string `json:"id"`
	Owner  string `json:"owner"`
	Balance uint   `json:"balance"`
}

func (e *ERC20Contract) InitLedger(ctx contractapi.TransactionContextInterface) error {
	tokens := []Token{
		{ID: "token1", Owner: "owner1", Balance: 100},
		{ID: "token2", Owner: "owner2", Balance: 200},
	}

	for _, token := range tokens {
		tokenJSON, err := json.Marshal(token)
		if err != nil {
			return err
		}

		err = ctx.GetStub().PutState(token.ID, tokenJSON)
		if err != nil {
			return fmt.Errorf("failed to put token: %v", err)
		}
	}

	return nil
}

func (e *ERC20Contract) Transfer(ctx contractapi.TransactionContextInterface, recipient string, amount uint) error {
	sender, err := ctx.GetClientIdentity().GetID()
	if err != nil {
		return err
	}

	senderTokenBytes, err := ctx.GetStub().GetState(sender)
	if err != nil {
		return fmt.Errorf("failed to read sender token: %v", err)
	}
	if senderTokenBytes == nil {
		return fmt.Errorf("sender token does not exist")
	}

	recipientTokenBytes, err := ctx.GetStub().GetState(recipient)
	if err != nil {
		return fmt.Errorf("failed to read recipient token: %v", err)
	}
	if recipientTokenBytes == nil {
		return fmt.Errorf("recipient token does not exist")
	}

	senderToken := Token{}
	err = json.Unmarshal(senderTokenBytes, &senderToken)
	if err != nil {
		return err
	}

	if senderToken.Balance < amount {
		return fmt.Errorf("insufficient balance")
	}

	recipientToken := Token{}
	err = json.Unmarshal(recipientTokenBytes, &recipientToken)
	if err != nil {
		return err
	}

	senderToken.Balance -= amount
	recipientToken.Balance += amount

	senderTokenJSON, err := json.Marshal(senderToken)
	if err != nil {
		return err
	}

	recipientTokenJSON, err := json.Marshal(recipientToken)
	if err != nil {
		return err
	}

	err = ctx.GetStub().PutState(sender, senderTokenJSON)
	if err != nil {
		return fmt.Errorf("failed to update sender token: %v", err)
	}

	err = ctx.GetStub().PutState(recipient, recipientTokenJSON)
	if err != nil {
		return fmt.Errorf("failed to update recipient token: %v", err)
	}

	return nil
}

func main() {
	contract := new(ERC20Contract)

	cc, err := contractapi.NewChaincode(contract)
	if err != nil {
		fmt.Printf("Error creating ERC20 chaincode: %v", err)
		return
	}

	if err := cc.Start(); err != nil {
		fmt.Printf("Error starting ERC20 chaincode: %v", err)
	}
}
