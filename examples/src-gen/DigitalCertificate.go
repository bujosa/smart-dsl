package main

import (
	"fmt"

	"github.com/hyperledger/fabric-contract-api-go/contractapi"
)

type DigitalCertificate struct {
	contractapi.Contract
	verifiers map[string]string
	VerifierAddress string
	IssuerAddress string
	Verifier bool
	Hash string
}

func (sc *DigitalCertificate) GetVerifierAddress(ctx contractapi.TransactionContextInterface) (string, error) {
	return sc.VerifierAddress, nil
}

func (sc *DigitalCertificate) GetIssuerAddress(ctx contractapi.TransactionContextInterface) (string, error) {
	return sc.IssuerAddress, nil
}

func (sc *DigitalCertificate) GetVerifier(ctx contractapi.TransactionContextInterface) (bool, error) {
	return sc.Verifier, nil
}

func (sc *DigitalCertificate) GetHash(ctx contractapi.TransactionContextInterface) (string, error) {
	return sc.Hash, nil
}

func (rc *DigitalCertificate) CreateCertificate(ctx contractapi.TransactionContextInterface) error {
	// This method is for create certificate
	if ctx.GetClientIdentity().GetID()==sc.IssuerAddress {
		return fmt.Errorf("Only valid issuer")
	}

	return nil
}

func (rc *DigitalCertificate) AcceptCertificate(ctx contractapi.TransactionContextInterface) error {
	// This method is for accept certificate
	if ctx.GetClientIdentity().GetID()==sc.VerifierAddress {
		return fmt.Errorf("Only valid verifier")
	}

	return nil
}

func (rc *DigitalCertificate) RejectCertificate(ctx contractapi.TransactionContextInterface) error {
	// This method is for reject certificate
	if ctx.GetClientIdentity().GetID()==sc.VerifierAddress {
		return fmt.Errorf("Only valid verifier")
	}

	return nil
}

func (sc *DigitalCertificate) InitLedger(ctx contractapi.TransactionContextInterface) error {
	sc.VerifierAddress = ""
	sc.IssuerAddress = ""
	sc.Verifier = false
	sc.Hash = ""
	return nil
}

func main() {
	chaincode, err := contractapi.NewChaincode(&DigitalCertificate{})
	if err != nil {
		fmt.Printf("Error creating DigitalCertificate chaincode: %s", err.Error())
		return
	}

	if err := chaincode.Start(); err != nil {
		fmt.Printf("Error starting DigitalCertificate chaincode: %s", err.Error())
	}
}
