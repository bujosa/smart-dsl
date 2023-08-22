// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract VehicleAuction {
	address owner;
	address bidder;
	string name;
	uint256 bidAmount;

	modifier onlyBidder() {
		require(msg.sender == bidder, "Only Bidder");
		_;
	}

	modifier onlyOwner() {
		require(msg.sender == owner, "Only Owner");
		_;
	}

	constructor(address _owner, address _bidder, string memory _name, uint256 _bidAmount) {
		owner = _owner;
		bidder = _bidder;
		name = _name;
		bidAmount = _bidAmount;
	}

	function getOwner() public view returns (address) {
		return owner;
	}

	function getBidder() public view returns (address) {
		return bidder;
	}

	function getName() public view returns (string memory) {
		return name;
	}

	function getBidAmount() public view returns (uint256) {
		return bidAmount;
	}

	function placeBid(uint256 newAmount) public onlyBidder  {
		// This operation if for bid
	}

	function changeOwner(address _owner) public onlyOwner  {
		// This operation is only for change the owner
	}

}