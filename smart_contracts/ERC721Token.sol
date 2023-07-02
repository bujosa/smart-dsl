// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract ERC721Token {
    string public name;
    string public symbol;
    uint256 public totalSupply;
    mapping(uint256 => address) public ownerOf;
    mapping(address => uint256[]) public ownedTokens;

    event Transfer(
        address indexed from,
        address indexed to,
        uint256 indexed tokenId
    );

    constructor(string memory _name, string memory _symbol) {
        name = _name;
        symbol = _symbol;
    }

    function mint(uint256 tokenId) public {
        require(ownerOf[tokenId] == address(0), "Token already minted");
        ownerOf[tokenId] = msg.sender;
        ownedTokens[msg.sender].push(tokenId);
        totalSupply++;
        emit Transfer(address(0), msg.sender, tokenId);
    }

    function transfer(address to, uint256 tokenId) public {
        require(ownerOf[tokenId] == msg.sender, "Not the token owner");
        ownerOf[tokenId] = to;
        emit Transfer(msg.sender, to, tokenId);
    }
}
