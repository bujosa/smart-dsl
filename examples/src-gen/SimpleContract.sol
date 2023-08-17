// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract SimpleContract {
	uint256 total;
	address owner;

	event PaymentReceived(address sender, uint amount);
	// Este evento es para notificar cuando el numero se ha actualizado
	event XUpdated(uint256 x);
	// Este evento es para notificar cuando el name se ha actualizado
	event NameUpdated(string name);

	modifier onlyOwner() {
		require(msg.sender== owner, "Only the contract owner can call this function.");
		_;
	}

	modifier validNumber(uint256 x) {
		require(x>4, "The number must be greater than 4");
		_;
	}

	constructor(uint256 _total) {
		total = _total;
		owner = msg.sender;
	}

	function setTotal(uint256 _value) public {
		total = _value;
	}

	function getTotal() public view returns (uint256) {
		return total;
	}

	receive() external payable {
		emit PaymentReceived(msg.sender, msg.value);
	}

	function example(uint256 x, string memory name, string memory lastname) public onlyOwner validNumber(x)  returns (uint256, string memory) {
		// This is a sample of method
		emit XUpdated(x);
		emit NameUpdated(name);
	}

}