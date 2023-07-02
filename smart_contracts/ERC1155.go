package main

import (
	"encoding/json"
	"fmt"
	"log"

	"github.com/hyperledger/fabric-contract-api-go/contractapi"
)

type Token struct {
	ID     string `json:"id"`
	Owner  string `json:"owner"`
	Amount uint   `json:"amount"`
}

type ERC1155Contract struct {
	contractapi.Contract
}

func (e *ERC1155Contract) Mint(ctx contractapi.TransactionContextInterface, account string, id string, amount uint) error {
	existingTokenBytes, err := ctx.GetStub().GetState(id)
	if err != nil {
		return fmt.Errorf("failed to read token from world state: %v", err)
	}
	if existingTokenBytes != nil {
		return fmt.Errorf("token already exists with ID: %s", id)
	}

	token := Token{
		ID:     id,
		Owner:  account,
		Amount: amount,
	}

	tokenBytes, err := json.Marshal(token)
	if err != nil {
		return fmt.Errorf("failed to marshal token: %v", err)
	}

	err = ctx.GetStub().PutState(id, tokenBytes)
	if err != nil {
		return fmt.Errorf("failed to put token in world state: %v", err)
	}

	return nil
}

func (e *ERC1155Contract) Transfer(ctx contractapi.TransactionContextInterface, recipient string, id string, amount uint) error {
	tokenBytes, err := ctx.GetStub().GetState(id)
	if err != nil {
		return fmt.Errorf("failed to read token from world state: %v", err)
	}
	if tokenBytes == nil {
		return fmt.Errorf("token does not exist with ID: %s", id)
	}

	token := Token{}
	err = json.Unmarshal(tokenBytes, &token)
	if err != nil {
		return fmt.Errorf("failed to unmarshal token: %v", err)
	}

	if token.Amount < amount {
		return fmt.Errorf("insufficient token balance for transfer")
	}

	token.Amount -= amount
	tokenBytes, err = json.Marshal(token)
	if err != nil {
		return fmt.Errorf("failed to marshal updated token: %v", err)
	}

	err = ctx.GetStub().PutState(id, tokenBytes)
	if err != nil {
		return fmt.Errorf("failed to put updated token in world state: %v", err)
	}

	return nil
}

func main() {
	chaincode, err := contractapi.NewChaincode(&ERC1155Contract{})
	if err != nil {
		log.Fatal(err)
	}

	if err := chaincode.Start(); err != nil {
		log.Fatal(err)
	}
}
