// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract ERC20 {
	string name;
	string symbol;
	uint256 totalSupply;
	mapping(address => uint256) public balanceOf;

	// Esto es para cuando se haga la transferencia se notifique en la blockchain
	event Transfer(address from, address to, uint256 value);

	modifier validBalance(uint256 value) {
		require(balanceOf[msg.sender] >= value, "Saldo Insufiente");
		_;
	}

	constructor(string memory _name, string memory _symbol, uint256 _totalSupply) {
		name = _name;
		symbol = _symbol;
		totalSupply = _totalSupply;
	}

	function getName() public view returns (string memory) {
		return name;
	}

	function getSymbol() public view returns (string memory) {
		return symbol;
	}

	function getTotalSupply() public view returns (uint256) {
		return totalSupply;
	}

	function transfer(address to, uint256 value) public validBalance(value)  {
		// Este metodo es para transferir dinero
		emit Transfer(msg.sender, to, value);
	}

}