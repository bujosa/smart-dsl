// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract SimpleContract {
    uint256 total;
    string name;
    address owner;

    event PaymentReceived(address sender, uint amount);
    event NumberUpdated(uint256 total);
    event NameUpdated(string name);

    modifier onlyOwner() {
        require(
            msg.sender == owner,
            "Only the contract owner can call this function."
        );
        _;
    }

    constructor(uint256 _total, string memory _name) {
        total = _total;
        name = _name;
        owner = msg.sender;
    }

    function setTotal(uint256 _value) public {
        total = _value;
    }

    function getTotal() public view returns (uint256) {
        return total;
    }

    function setName(string memory _value) public {
        name = _value;
    }

    function getName() public view returns (string memory) {
        return name;
    }
}
