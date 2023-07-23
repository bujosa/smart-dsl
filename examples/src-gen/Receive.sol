// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract Receive {
	event PaymentReceived(address sender, uint amount);

	constructor() {
	}

	receive() external payable {
		emit PaymentReceived(msg.sender, msg.value);
	}

}