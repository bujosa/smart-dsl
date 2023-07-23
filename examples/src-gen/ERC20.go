package main

import (
	"fmt"

	"github.com/hyperledger/fabric-contract-api-go/contractapi"
)

type ERC20 struct {
	contractapi.Contract
	Name string
	Symbol string
	TotalSupply uint64
}

func (sc *ERC20) GetName(ctx contractapi.TransactionContextInterface) (string, error) {
	return sc.Name, nil
}

func (sc *ERC20) GetSymbol(ctx contractapi.TransactionContextInterface) (string, error) {
	return sc.Symbol, nil
}

func (sc *ERC20) GetTotalSupply(ctx contractapi.TransactionContextInterface) (uint64, error) {
	return sc.TotalSupply, nil
}

func (sc *ERC20) InitLedger(ctx contractapi.TransactionContextInterface) error {
	// Inicializa los valores de los atributos
	sc.Name = ""
	sc.Symbol = ""
	sc.TotalSupply = 0
	return nil
}

func main() {
	chaincode, err := contractapi.NewChaincode(&ERC20{})
	if err != nil {
		fmt.Printf("Error creating ERC20 chaincode: %s", err.Error())
		return
	}

	if err := chaincode.Start(); err != nil {
		fmt.Printf("Error starting ERC20 chaincode: %s", err.Error())
	}
}
