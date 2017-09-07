
package com.sg.addressbook.dto;

import java.util.Objects;


public class AddressBook {
    
    private AddressBook address;
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
    
   /* public String getAddressLocale(){
        return addressLocale;
    } */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.addressTitle);
        hash = 73 * hash + Objects.hashCode(this.streetName);
        hash = 73 * hash + Objects.hashCode(this.occupantFirstName);
        hash = 73 * hash + Objects.hashCode(this.occupantLastName);
       // hash = 73 * hash + Objects.hashCode(this.addressLocale);
        hash = 73 * hash + Objects.hashCode(this.addressState);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AddressBook other = (AddressBook) obj;
        if (!Objects.equals(this.addressTitle, other.addressTitle)) {
            return false;
        }
        if (!Objects.equals(this.streetName, other.streetName)) {
            return false;
        }
        if (!Objects.equals(this.occupantFirstName, other.occupantFirstName)) {
            return false;
        }
        if (!Objects.equals(this.occupantLastName, other.occupantLastName)) {
            return false;
        }
        /*if (!Objects.equals(this.addressLocale, other.addressLocale)) {
            return false;
        }*/
        if (!Objects.equals(this.addressState, other.addressState)) {
            return false;
        }
        return true;
    }
}
