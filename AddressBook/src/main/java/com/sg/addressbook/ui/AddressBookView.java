
package com.sg.addressbook.ui;

import com.sg.addressbook.dto.AddressBook;
import java.util.List;


public class AddressBookView {
    private UserIO io;

    public AddressBookView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {

        io.print("Main Menu");
        io.print("1. List Addresses");
        io.print("2. Create New Address Entry");
        io.print("3. View an Address Entry");
        io.print("4. Remove an Address Entry");
        io.print("5. Edit");
        io.print("6. Exit");

        String msg = "Please enter the number of your choice from"
                + " the above listed options.";
        return io.readInt(msg);
    }

    public AddressBook getNewAddressInfo() {
        AddressBook currentAddress = new AddressBook();
        boolean newInput;
        do {
            String streetName;
            streetName = io.readString("Please enter the street name");
            if (streetName != null && !streetName.isEmpty()) {
                currentAddress.setStreetName(streetName);
                newInput = true;
            } else {
                newInput = false;
            }
        } while (newInput == false);
        String numberStreet;
        boolean intChecker;
        do {
            numberStreet = io.readString("Please enter a number for the street number of the address");
                if (numberStreet != null && !numberStreet.isEmpty()){ 
                int houseNumber = Integer.parseInt(numberStreet);
                currentAddress.setAddressTitle(numberStreet); 
                intChecker = true;
                }else{        
                io.readString("That is not a number, please enter a number");
                intChecker = false;
                }
        } while (intChecker == false);

        String addressTitle = io.readString("Please enter Address street number");
        currentAddress.setAddressTitle(addressTitle);
        String streetName = io.readString("Please enter the street name");
        currentAddress.setStreetName(streetName);
        String occupantFirstName = io.readString("Please enter the occupant's first name");
        currentAddress.setOccupantFirstName(occupantFirstName);
        String occupantLastName = io.readString("Please enter the occupant's last name");
        currentAddress.setOccupantLastName(occupantLastName);
        String addressState = io.readString("Please enter the name of the state or province");
        currentAddress.setAddressState(addressState);
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

    public void displayAddressList(List<AddressBook> addressList) {

        for (AddressBook currentAddress : addressList) {
            io.print(currentAddress.getAddressTitle() + ": "
                    + currentAddress.getStreetName() + ": "
                    + currentAddress.getOccupantFirstName() + ": "
                    + currentAddress.getOccupantLastName() + ": "
                    + currentAddress.getAddressState() + " ");
        }
        io.print("Please hit enter to continue.");
    }

    public void displayDisplayAddressEntryBanner() {
        io.print("=== Display Address Entry ===");
    }

    public String getAddressTitleChoice() {

        return io.readString("Please enter a dvdTitle");
    }

    public void displayAddress(AddressBook address) {
        if(address != null){

        try {
            io.readString(address.getAddressTitle());
            io.readString(address.getStreetName());
            io.readString(address.getOccupantFirstName());
            io.readString(address.getOccupantLastName());
            io.readString(address.getAddressState());
            io.readString(" ");
        } catch (NullPointerException e) {
            io.readString("No such address.");
        }
        io.readString("Please hit enter to continue.");
       }
    }
    

    public AddressBook getAddressForUserEdit(String addressTitle, AddressBook currentAddress) {
        boolean keepOnKeepingOn = true;
        int userSelection;
        String streetName;
        String occupantFirstName;
        String occupantLastName;
        String addressState;
 

        while(keepOnKeepingOn == true) {
            userSelection = io.readInt("Please select a number from the following editing options: "
                    + "(1)Street Name "
                    + "(2)Occupant First Name"
                    + "(3)Occupant Last Name"
                    + "(4)Address State/Province"
                    + "(5)Address Country");
            
            switch (userSelection) {
               case 1:
                    boolean newInput;
                    do {
                        streetName = io.readString("Please enter your desired changes for the Release Date");
                        if (streetName != null && !streetName.isEmpty()) {
                            currentAddress.setStreetName(streetName);
                            io.print("Your change to the Street name has been noted");
                            newInput = true;
                        } else {
                            newInput = false;
                        }
                    } while (newInput == false);
                    break;
                case 2:
                    boolean inputTry;
                    do {
                        occupantFirstName = io.readString("Please enter your desired changes for the MPAA Rating");
                        if (occupantFirstName != null && !occupantFirstName.isEmpty()) {
                            currentAddress.setOccupantFirstName(occupantFirstName);
                            io.print("Your change to the MPAA Rating has been noted");
                            inputTry = true;
                        } else {
                            inputTry = false;
                        }
                    } while (inputTry == false);
                    break;
                case 3:
                    boolean inputValidate;
                    do {
                        occupantLastName = io.readString("Please enter your desired changes for the Director's Name");
                        if (occupantLastName != null && !occupantLastName.isEmpty()) {
                            currentAddress.setOccupantLastName(occupantLastName);
                            io.print("Your change to the Director's Name has been noted");
                            inputValidate = true;
                        } else {
                            inputValidate = false;
                        }
                    } while (inputValidate == false);
                    break;
                case 4:
                    boolean inputBool;
                    do {
                        addressState = io.readString("Please enter your desired changes for User Notes");
                        if (addressState != null && !addressState.isEmpty()) {
                            currentAddress.setAddressState(addressState);
                            io.print("Your change to the User Notes have been noted");
                            inputBool = true;
                        } else {
                            inputBool = false;
                        }
                    } while (inputBool == false);
                    break;
                case 5:
                    keepOnKeepingOn = false;
                    break;
                default:
                    io.print("Invalid Input, please enter one of the numbered chocies");
                    break;
            }
        }
        return currentAddress;
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
