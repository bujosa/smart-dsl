// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract DoctorBill {
	address insurer;
	address doctor;
	string patient;
	uint256 amount;

	modifier onlyDoctor() {
		require(msg.sender == doctor, "Only Doctor");
		_;
	}

	modifier onlyInsurer() {
		require(msg.sender == insurer, "Only Insurer");
		_;
	}

	constructor(address _insurer, address _doctor, string memory _patient, uint256 _amount) {
		insurer = _insurer;
		doctor = _doctor;
		patient = _patient;
		amount = _amount;
	}

	function getInsurer() public view returns (address) {
		return insurer;
	}

	function getDoctor() public view returns (address) {
		return doctor;
	}

	function getPatient() public view returns (string memory) {
		return patient;
	}

	function getAmount() public view returns (uint256) {
		return amount;
	}

	function CreateInvoice() public onlyDoctor  {
		// This method is for create the invoice
	}

	function PayInvoice() public onlyInsurer  {
		// This method is for pay the invoice
	}

}