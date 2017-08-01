
package com.sg.addressbook.ui;

import java.util.List;


public class AddressBookView {
    private UserIO io;

    public AddressBookView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {

        io.print("Main Menu");
        io.print("1. List Address Titles");
        io.print("2. Create New Address Entry");
        io.print("3. View an Address Entry");
        io.print("4. Remove an Address Entry");
        io.print("5. Edit");
        io.print("6. Exit");

        String msg = "Please enter the number of your choice from"
                + " the above listed options.";
        return io.readInt(msg);
    }

    public Address getNewAddressInfo() {

        Address currentaddress = new Address();

        String addressTitle = io.readString("Please enter Address Entry title");
        currentAddress.setAddressTitle(addressTitle);
        String releaseDate = io.readString("Please enter the DVD release date");
        currentAddress.setReleaseDate(releaseDate);
        String mpaaRating = io.readString("Please enter the MPAA rating");
        currentAddress.setMpaaRating(mpaaRating);
        String directorsName = io.readString("Please enter the director's name");
        currentAddress.setDirectorsName(directorsName);
        String studioName = io.readString("Please enter the production studio's name");
        currentAddress.setStudioName(studioName);
        String userRating = io.readString("Please enter your rating or note about the Address");
        currentAddress.setUserRating(userRating);
        io.readString("Please hit enter to continue");
        return currentAddress;
    }

    public void displayCreateAddressEntryBanner() {
        io.print("=== Create Address Entry ===");
    }

    public void displayCreateSuccessBanner() {
        io.print(
                "Entry successfully created.  Please hit enter to continue");
    }

    public void displayAddressList(List<Address> addressList) {

        for (Address currentAddress : addressList) {
            io.print(currentAddress.getAddressTitle() + ": "
                    + currentAddress.getReleaseDate() + ": "
                    + currentAddress.getMpaaRating() + ": "
                    + currentAddress.getDirectorsName() + ": "
                    + currentAddress.getStudioName() + ": "
                    + currentAddress.getUserRating() + " ");
        }
        io.print("Please hit enter to continue.");
    }

    public void displayDisplayAddressEntryBanner() {
        io.print("=== Display Address Entry ===");
    }

    public String getAddressTitleChoice() {

        return io.readString("Please enter a dvdTitle");
    }

    public void displayAddress(Address address) {
        Address viewAddress = new Address();

        try {
            io.readString(address.getAddressTitle());
            io.readString(address.getReleaseDate());
            io.readString(address.getMpaaRating());
            io.readString(address.getDirectorsName());
            io.readString(address.getStudioName());
            io.readString(address.getUserRating());
            io.readString(" ");
        } catch (NullPointerException e) {
            io.readString("No such dvd.");
        }
        io.readString("Please hit enter to continue.");
    }

    public Address getAddressForUserEdit(String addressTitle, Address currentAddress) {
        boolean keepOnKeepingOn = true;
        int userSelection;
        String releaseDate;
        String mpaaRating;
        String directorsName;
        String userRating;
        Address editedAddressInfo = currentAddress;

        while(keepOnKeepingOn == true) {
            userSelection = io.readInt("Please select a number from the following editing options: "
                    + "(1)Release Date "
                    + "(2)MPAA Rating "
                    + "(3)Director's Name"
                    + "(4)User Notes"
                    + "(5)Leave Menu");
            switch (userSelection) {
                case 1:
                    releaseDate = io.readString("Please enter your desired changes for the Release Date");
                    editedAddressInfo.setReleaseDate(releaseDate);
                    io.print("Your change to the Release Date has been noted");
                    break;
                case 2:
                    mpaaRating = io.readString("Please enter your desired changes for the MPAA Rating");
                    editedAddressInfo.setMpaaRating(mpaaRating);
                    io.print("Your change to the MPAA Rating has been noted");
                    break;
                case 3:
                    directorsName = io.readString("Please enter your desired changes for the Director's Name");
                    editedAddressInfo.setDirectorsName(directorsName);
                    io.print("Your change to the Director's Name has been noted");
                    break;
                case 4:
                    userRating = io.readString("Please enter your desired changes for User Notes");
                    editedAddressInfo.setUserRating(userRating);
                    io.print("Your change to the User Notes have been noted");
                    break;
                case 5:
                    keepOnKeepingOn = false;
                    break;
                default:
                    io.print("Invalid Input, please enter one of the numbered chocies");
                    break;
            }
        } 
        return editedAddressInfo;
    }

    public void displayRemoveAddressEntryBanner() {
        io.print("=== Remove Address Entry ===");
    }

    public void displayRemoveSuccessBanner() {
        io.print("Entry successfully removed. Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayEditAddressEntryBanner() {
        io.print("=== Edit a Dvd ===");
    }

    public void displayEditSuccessBanner() {
        io.print("=== Edit Success ===");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        errorMsg = "Could not save data";
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
