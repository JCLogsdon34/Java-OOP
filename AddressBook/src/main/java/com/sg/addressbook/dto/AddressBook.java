
package com.sg.addressbook.dto;


public class AddressBook {
    public Address address;
    public Address currentAddress;
    public String addressTitle;
    public String releaseDate;
    public String directorsName;
    public String mpaaRating;
    public String studioName;
    public String userRating;

    public Address getAddress() {
        return Address;
    }
    
    public void setAddress(Address address) {
        this.address= address;
    }

    public void setCurrentAddress(Address currentAddress){
        this.currentAddress = currentAddress;
    }
    
    public Address getCurrentAddress() {
        return currentAddress;      
    }

    public void setAddressTitle(String addressTitle) {
        this.addressTitle = addressTitle;
    }

    public String getAddressTitle() {
        return addressTitle;
    }

    public void setDirectorsName(String directorsName) {
        this.directorsName = directorsName;
    }

    public String getDirectorsName() {
        return directorsName;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public String getUserRating() {
        return userRating;
    }
}
