// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

import "https://github.com/OpenZeppelin/openzeppelin-contracts/blob/v4.1.0/contracts/token/ERC777/ERC777.sol";

contract ERC777Token is ERC777 {
    constructor(
        string memory _name,
        string memory _symbol,
        address[] memory _defaultOperators,
        uint256 _initialSupply,
        address _initialHolder
    ) ERC777(_name, _symbol, _defaultOperators) {
        _mint(_initialHolder, _initialSupply, "", "");
    }
}
