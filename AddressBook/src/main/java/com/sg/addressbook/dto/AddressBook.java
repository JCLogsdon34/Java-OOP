
package com.sg.addressbook.dto;


public class AddressBook {
    
    public String addressTitle;
    public String streetName;
    public String occupantFirstName;
    public String occupantLastName;
    public String addressState;

    public void setAddressTitle(String addressTitle) {
        this.addressTitle = addressTitle;
    }
    
    public String getAddressTitle() {
        return addressTitle;
    }
    
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetName(){
        return streetName;
    }
    
    public void setOccupantFirstName(String occupantFirstName) {
        this.occupantFirstName = occupantFirstName;      
    }

    public String getOccupantFirstName() {
        return occupantFirstName;
    }

    public void setOccupantLastName(String occupantLastName) {
        this.occupantLastName = occupantLastName;
    }

    public String getOccupantLastName() {
        return occupantLastName;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public String getAddressState() {
        return addressState;
    }
}
