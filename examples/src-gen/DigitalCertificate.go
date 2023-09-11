package main

import (
	"fmt"

	"github.com/hyperledger/fabric-contract-api-go/contractapi"
)

type DigitalCertificate struct {
	contractapi.Contract
	verifiers map[string]string
	verifierAddress string
	issuerAddress string
	verifier bool
	Hash string
}

func (sc *DigitalCertificate) GetVerifierAddress(ctx contractapi.TransactionContextInterface) (string, error) {
	return sc.verifierAddress, nil
}

func (sc *DigitalCertificate) GetIssuerAddress(ctx contractapi.TransactionContextInterface) (string, error) {
	return sc.issuerAddress, nil
}

func (sc *DigitalCertificate) GetVerifier(ctx contractapi.TransactionContextInterface) (bool, error) {
	return sc.verifier, nil
}

func (sc *DigitalCertificate) GetHash(ctx contractapi.TransactionContextInterface) (string, error) {
	return sc.Hash, nil
}

func (sc *DigitalCertificate) CreateCertificate(ctx contractapi.TransactionContextInterface) error {
	// This method is for create certificate
	if ctx.GetClientIdentity().GetID()==sc.issuerAddress {
		return fmt.Errorf("Only valid issuer")
	}

	return nil
}

func (sc *DigitalCertificate) AcceptCertificate(ctx contractapi.TransactionContextInterface) error {
	// This method is for accept certificate
	if ctx.GetClientIdentity().GetID()==sc.verifierAddress {
		return fmt.Errorf("Only valid verifier")
	}

	if sc.verifiers[ctx.GetClientIdentity().GetID()]!="" {
		return fmt.Errorf("The verifier need to be in the list of verifiers")
	}

	return nil
}

func (sc *DigitalCertificate) RejectCertificate(ctx contractapi.TransactionContextInterface) error {
	// This method is for reject certificate
	if ctx.GetClientIdentity().GetID()==sc.verifierAddress {
		return fmt.Errorf("Only valid verifier")
	}

	if sc.Hash!="" {
		return fmt.Errorf("The certificate need to be valid")
	}

	if sc.verifiers[ctx.GetClientIdentity().GetID()]!="" {
		return fmt.Errorf("The verifier need to be in the list of verifiers")
	}

	return nil
}

func (sc *DigitalCertificate) InitLedger(ctx contractapi.TransactionContextInterface) error {
	sc.verifierAddress = ""
	sc.issuerAddress = ""
	sc.verifier = false
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
