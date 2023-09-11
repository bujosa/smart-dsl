// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract TestResults {
	string Grade;
	uint256 amount;
	address studentAddress;
	address teacherAddress;
	address parentsAddress;

	// Send event when the grade is updated
	event NewGrade(string _Grade);
	// Send event when the money is withdrawn
	event MoneyWithdrawn();

	modifier validAmount() {
		require(amount > 0, "The amount needs to be greater than zero");
		_;
	}

	modifier validGrade() {
		require(keccak256(bytes(Grade))!=0, "The grade cant be empty");
		_;
	}

	modifier checkGrade() {
		require(keccak256(bytes(Grade))==keccak256(bytes("A")), "The grade needs to be an A");
		_;
	}

	modifier onlyParents() {
		require(msg.sender == parentsAddress, "Only Parents");
		_;
	}

	modifier onlyTeacher() {
		require(msg.sender == teacherAddress, "Only Teacher");
		_;
	}

	modifier onlyStudent() {
		require(msg.sender == studentAddress, "OnlyStudent");
		_;
	}

	constructor(string memory _Grade, uint256 _amount, address _studentAddress, address _teacherAddress, address _parentsAddress) {
		Grade = _Grade;
		amount = _amount;
		studentAddress = _studentAddress;
		teacherAddress = _teacherAddress;
		parentsAddress = _parentsAddress;
	}

	function getGrade() public view returns (string memory) {
		return Grade;
	}

	function getAmount() public view returns (uint256) {
		return amount;
	}

	function getStudentAddress() public view returns (address) {
		return studentAddress;
	}

	function getTeacherAddress() public view returns (address) {
		return teacherAddress;
	}

	function getParentsAddress() public view returns (address) {
		return parentsAddress;
	}

	function CreateContract() public onlyParents  {
		// This method is for create the contract
	}

	function WithdrawAmount() public onlyStudent validAmount checkGrade  {
		// This method is for withdraw the reward amount
		emit MoneyWithdrawn();
	}

	function SetGrade(string memory _Grade) public onlyTeacher validGrade  {
		// This method is for set the grade
		Grade = _Grade;
		emit NewGrade(_Grade);
	}

}