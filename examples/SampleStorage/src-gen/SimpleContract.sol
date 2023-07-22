// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract SimpleContract {
	uint256 total;
	address owner;

	event PaymentReceived(address sender, uint amount);
	event NumberUpdated(uint256 total);

	modifier onlyOwner() {
		require(msg.sender == owner, "Only the contract owner can call this function.");
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

	function example(uint256 x, string memory name, string memory lastname) public onlyOwner returns (uint256, string memory) {
		// This is a sample of method
	}

}