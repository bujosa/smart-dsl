pragma solidity ^0.8.0;

contract MyContract {
    event PaymentReceived(address sender, uint amount);

    receive() external payable {
        emit PaymentReceived(msg.sender, msg.value);
    }

    function makePayment() external payable {
        emit PaymentReceived(msg.sender, msg.value);
    }
}
