// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract TestResults {
	string Grade;
	uint256 amount;
	address studentAddress;
	address teacherAddress;
	address parentsAddress;

	modifier onlyParents() {
		require(msg.sender==parentsAddress, "Only Parents");
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

	function setGrade(string memory _value) public {
		Grade = _value;
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

	function CreateContract() public onlyTeacher  {
		// Este metodo es para crear un contracto
	}

	function WithdrawAmount() public onlyStudent  {
		// Este metodo es para retirar fondo
	}

}