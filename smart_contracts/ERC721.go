package main

import (
	"fmt"
	"log"

	"github.com/hyperledger/fabric-contract-api-go/contractapi"
)

type Token struct {
	ID     string `json:"id"`
	Owner  string `json:"owner"`
}

type ERC721Contract struct {
	contractapi.Contract
}

func (e *ERC721Contract) Mint(ctx contractapi.TransactionContextInterface, account string, id string) error {
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

func (e *ERC721Contract) Transfer(ctx contractapi.TransactionContextInterface, recipient string, id string) error {
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

	token.Owner = recipient
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
	chaincode, err := contractapi.NewChaincode(&ERC721Contract{})
	if err != nil {
		log.Fatal(err)
	}

	if err := chaincode.Start(); err != nil {
		log.Fatal(err)
	}
}
