package main

import (
	"encoding/json"
	"fmt"

	"github.com/hyperledger/fabric-contract-api-go/contractapi"
)

type ERC1155TokenContract struct {
	contractapi.Contract
}

type Token struct {
	ID      uint256
	Owner   string
	Balance uint256
}

func (t *ERC1155TokenContract) BalanceOf(ctx contractapi.TransactionContextInterface, owner string, id uint256) (uint256, error) {
	tokenKey := fmt.Sprintf("%s:%d", owner, id)
	tokenBytes, err := ctx.GetStub().GetState(tokenKey)
	if err != nil {
		return 0, fmt.Errorf("failed to read token balance: %w", err)
	}
	if tokenBytes == nil {
		return 0, nil
	}

	token := new(Token)
	err = json.Unmarshal(tokenBytes, token)
	if err != nil {
		return 0, fmt.Errorf("failed to unmarshal token balance: %w", err)
	}

	return token.Balance, nil
}

func (t *ERC1155TokenContract) BalanceOfBatch(ctx contractapi.TransactionContextInterface, owners []string, ids []uint256) ([]uint256, error) {
	if len(owners) != len(ids) {
		return nil, fmt.Errorf("length mismatch between owners and ids")
	}

	batchBalances := make([]uint256, len(owners))
	for i := 0; i < len(owners); i++ {
		balance, err := t.BalanceOf(ctx, owners[i], ids[i])
		if err != nil {
			return nil, err
		}
		batchBalances[i] = balance
	}

	return batchBalances, nil
}

func (t *ERC1155TokenContract) SetApprovalForAll(ctx contractapi.TransactionContextInterface, operator string, approved bool) error {
	err := validateAddress(operator)
	if err != nil {
		return fmt.Errorf("invalid operator address: %w", err)
	}

	owner := ctx.GetClientIdentity().GetID()

	approvalKey := fmt.Sprintf("%s:%s", owner, operator)
	err = ctx.GetStub().PutState(approvalKey, []byte(strconv.FormatBool(approved)))
	if err != nil {
		return fmt.Errorf("failed to set operator approval: %w", err)
	}

	return nil
}

func (t *ERC1155TokenContract) IsApprovedForAll(ctx contractapi.TransactionContextInterface, owner string, operator string) (bool, error) {
	err := validateAddress(owner)
	if err != nil {
		return false, fmt.Errorf("invalid owner address: %w", err)
	}

	err = validateAddress(operator)
	if err != nil {
		return false, fmt.Errorf("invalid operator address: %w", err)
	}

	approvalKey := fmt.Sprintf("%s:%s", owner, operator)
	approvalBytes, err := ctx.GetStub().GetState(approvalKey)
	if err != nil {
		return false, fmt.Errorf("failed to read operator approval: %w", err)
	}
	if approvalBytes == nil {
		return false, nil
	}

	approved, err := strconv.ParseBool(string(approvalBytes))
	if err != nil {
		return false, fmt.Errorf("failed to parse operator approval: %w", err)
	}

	return approved, nil
}

func (t *ERC1155TokenContract) TransferFrom(ctx contractapi.TransactionContextInterface, from string, to string, id uint256, value uint256) error {
	err := validateAddress(from)
	if err != nil {
		return fmt.Errorf("invalid sender address: %w", err)
	}

	err = validateAddress(to)
	if err != nil {
		return fmt.Errorf("invalid recipient address: %w", err)
	}

	if value <= 0 {
		return fmt.Errorf("invalid token value")
	}

	fromBalance, err := t.BalanceOf(ctx, from, id)
	if err != nil {
		return err
	}

	if value > fromBalance {
		return fmt.Errorf("insufficient balance")
	}

	toBalance, err := t.BalanceOf(ctx, to, id)
	if err != nil {
		return err
	}

	fromToken := &Token{
		ID:      id,
		Owner:   from,
		Balance: fromBalance - value,
	}

	toToken := &Token{
		ID:      id,
		Owner:   to,
		Balance: toBalance + value,
	}

	err = t.updateToken(ctx, fromToken)
	if err != nil {
		return fmt.Errorf("failed to update sender's token: %w", err)
	}

	err = t.updateToken(ctx, toToken)
	if err != nil {
		return fmt.Errorf("failed to update recipient's token: %w", err)
	}

	return nil
}

func (t *ERC1155TokenContract) TransferBatch(ctx contractapi.TransactionContextInterface, from string, to string, ids []uint256, values []uint256) error {
	if len(ids) != len(values) {
		return fmt.Errorf("length mismatch between ids and values")
	}

	err := validateAddress(from)
	if err != nil {
		return fmt.Errorf("invalid sender address: %w", err)
	}

	err = validateAddress(to)
	if err != nil {
		return fmt.Errorf("invalid recipient address: %w", err)
	}

	for i := 0; i < len(ids); i++ {
		id := ids[i]
		value := values[i]

		if value <= 0 {
			return fmt.Errorf("invalid token value")
		}

		fromBalance, err := t.BalanceOf(ctx, from, id)
		if err != nil {
			return err
		}

		if value > fromBalance {
			return fmt.Errorf("insufficient balance")
		}

		toBalance, err := t.BalanceOf(ctx, to, id)
		if err != nil {
			return err
		}

		fromToken := &Token{
			ID:      id,
			Owner:   from,
			Balance: fromBalance - value,
		}

		toToken := &Token{
			ID:      id,
			Owner:   to,
			Balance: toBalance + value,
		}

		err = t.updateToken(ctx, fromToken)
		if err != nil {
			return fmt.Errorf("failed to update sender's token: %w", err)
		}

		err = t.updateToken(ctx, toToken)
		if err != nil {
			return fmt.Errorf("failed to update recipient's token: %w", err)
		}
	}

	return nil
}

func (t *ERC1155TokenContract) Mint(ctx contractapi.TransactionContextInterface, to string, id uint256, value uint256) error {
	err := validateAddress(to)
	if err != nil {
		return fmt.Errorf("invalid recipient address: %w", err)
	}

	if value <= 0 {
		return fmt.Errorf("invalid token value")
	}

	toBalance, err := t.BalanceOf(ctx, to, id)
	if err != nil {
		return err
	}

	token := &Token{
		ID:      id,
		Owner:   to,
		Balance: toBalance + value,
	}

	err = t.updateToken(ctx, token)
	if err != nil {
		return fmt.Errorf("failed to mint token: %w", err)
	}

	return nil
}

func (t *ERC1155TokenContract) MintBatch(ctx contractapi.TransactionContextInterface, to string, ids []uint256, values []uint256) error {
	if len(ids) != len(values) {
		return fmt.Errorf("length mismatch between ids and values")
	}

	err := validateAddress(to)
	if err != nil {
		return fmt.Errorf("invalid recipient address: %w", err)
	}

	for i := 0; i < len(ids); i++ {
		id := ids[i]
		value := values[i]

		if value <= 0 {
			return fmt.Errorf("invalid token value")
		}

		toBalance, err := t.BalanceOf(ctx, to, id)
		if err != nil {
			return err
		}

		token := &Token{
			ID:      id,
			Owner:   to,
			Balance: toBalance + value,
		}

		err = t.updateToken(ctx, token)
		if err != nil {
			return fmt.Errorf("failed to mint token: %w", err)
		}
	}

	return nil
}

func (t *ERC1155TokenContract) Burn(ctx contractapi.TransactionContextInterface, from string, id uint256, value uint256) error {
	err := validateAddress(from)
	if err != nil {
		return fmt.Errorf("invalid owner address: %w", err)
	}

	if value <= 0 {
		return fmt.Errorf("invalid token value")
	}

	fromBalance, err := t.BalanceOf(ctx, from, id)
	if err != nil {
		return err
	}

	if value > fromBalance {
		return fmt.Errorf("insufficient balance")
	}

	fromToken := &Token{
		ID:      id,
		Owner:   from,
		Balance: fromBalance - value,
	}

	err = t.updateToken(ctx, fromToken)
	if err != nil {
		return fmt.Errorf("failed to burn token: %w", err)
	}

	return nil
}

func (t *ERC1155TokenContract) BurnBatch(ctx contractapi.TransactionContextInterface, from string, ids []uint256, values []uint256) error {
	if len(ids) != len(values) {
		return fmt.Errorf("length mismatch between ids and values")
	}

	err := validateAddress(from)
	if err != nil {
		return fmt.Errorf("invalid owner address: %w", err)
	}

	for i := 0; i < len(ids); i++ {
		id := ids[i]
		value := values[i]

		if value <= 0 {
			return fmt.Errorf("invalid token value")
		}

		fromBalance, err := t.BalanceOf(ctx, from, id)
		if err != nil {
			return err
		}

		if value > fromBalance {
			return fmt.Errorf("insufficient balance")
		}

		fromToken := &Token{
			ID:      id,
			Owner:   from,
			Balance: fromBalance - value,
		}

		err = t.updateToken(ctx, fromToken)
		if err != nil {
			return fmt.Errorf("failed to burn token: %w", err)
		}
	}

	return nil
}

func (t *ERC1155TokenContract) updateToken(ctx contractapi.TransactionContextInterface, token *Token) error {
	tokenKey := fmt.Sprintf("%s:%d", token.Owner, token.ID)
	tokenBytes, err := json.Marshal(token)
	if err != nil {
		return fmt.Errorf("failed to marshal token: %w", err)
	}

	err = ctx.GetStub().PutState(tokenKey, tokenBytes)
	if err != nil {
		return fmt.Errorf("failed to update token: %w", err)
	}

	return nil
}

func validateAddress(address string) error {
	// Aquí se puede implementar la validación de direcciones según las reglas del contrato
	// Por ejemplo, verificar la longitud y el formato correcto de la dirección.
	// Si la dirección no es válida, puedes devolver un error.
	// De lo contrario, devuelve nil si la dirección es válida.

	return nil
}

func main() {
	chaincode, err := contractapi.NewChaincode(new(ERC1155TokenContract))
	if err != nil {
		fmt.Printf("Error creating ERC1155TokenContract chaincode: %s", err.Error())
		return
	}

	if err := chaincode.Start(); err != nil {
		fmt.Printf("Error starting ERC1155TokenContract chaincode: %s", err.Error())
	}
}
