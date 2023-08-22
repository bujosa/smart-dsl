// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract RentingSystem {
    address landLord;
    address tenant;
    address location;
    string name;
    uint256 rent;

    modifier onlyTenant() {
        require(msg.sender == tenant, "Only Tenant");
        _;
    }

    modifier onlyLandLord() {
        require(msg.sender == landLord, "Only LandLord");
        _;
    }

    constructor(
        address _landLord,
        address _tenant,
        address _location,
        string memory _name,
        uint256 _rent
    ) {
        landLord = _landLord;
        tenant = _tenant;
        location = _location;
        name = _name;
        rent = _rent;
    }

    function getLandLord() public view returns (address) {
        return landLord;
    }

    function getTenant() public view returns (address) {
        return tenant;
    }

    function getLocation() public view returns (address) {
        return location;
    }

    function getName() public view returns (string memory) {
        return name;
    }

    function getRent() public view returns (uint256) {
        return rent;
    }

    function setRent(uint256 _rent) public onlyLandLord {
        // This operation is for set the new rent value
        rent = _rent;
    }

    function payRent() public payable onlyTenant {
        // This operation is for pay the rent
    }
}
