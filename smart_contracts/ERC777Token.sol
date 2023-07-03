// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract ERC777Token {
    string public name;
    string public symbol;
    uint256 public totalSupply;
    mapping(address => uint256) public balanceOf;

    event Transfer(address indexed from, address indexed to, uint256 value);
    event TokensReceived(
        address indexed operator,
        address indexed from,
        address indexed to,
        uint256 value,
        bytes data
    );

    constructor(
        string memory _name,
        string memory _symbol,
        uint256 _totalSupply
    ) {
        name = _name;
        symbol = _symbol;
        totalSupply = _totalSupply;
        balanceOf[msg.sender] = _totalSupply;
    }

    function send(address _to, uint256 _value, bytes memory _data) public {
        require(balanceOf[msg.sender] >= _value, "Insufficient balance");
        balanceOf[msg.sender] -= _value;
        balanceOf[_to] += _value;
        emit Transfer(msg.sender, _to, _value);

        // Invoke the tokensReceived function of the recipient contract if it implements it
        if (isContract(_to)) {
            IERC777Recipient receiver = IERC777Recipient(_to);
            receiver.tokensReceived(msg.sender, msg.sender, _to, _value, _data);
            emit TokensReceived(msg.sender, msg.sender, _to, _value, _data);
        }
    }

    function isContract(address _address) private view returns (bool) {
        uint256 size;
        assembly {
            size := extcodesize(_address)
        }
        return size > 0;
    }
}

interface IERC777Recipient {
    function tokensReceived(
        address operator,
        address from,
        address to,
        uint256 value,
        bytes calldata data
    ) external;
}
