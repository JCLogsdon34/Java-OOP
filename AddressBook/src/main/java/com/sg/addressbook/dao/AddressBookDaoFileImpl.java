
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.AddressBook;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class AddressBookDaoFileImpl implements AddressBookDao {

    @Override
    public AddressBook addAddress(String addressTitle, AddressBook address) throws AddressBookDaoException {
        AddressBook newAddress = addressLibrary.put(addressTitle, address);
        writeLibrary();
        return newAddress;
    }

    @Override
    public List<AddressBook> getAllAddresses() throws AddressBookDaoException {
        loadRoster();
        return new ArrayList<>(addressLibrary.values());
    }

    @Override
    public AddressBook getAddress(String addressTitle) throws AddressBookDaoException {
        try{
            loadRoster();
        } catch (AddressBookDaoException e) {
            throw new AddressBookDaoException(
                    "Could not save Address Entry data.", e);
        }
        return addressLibrary.get(addressTitle);
    }

    @Override
    public AddressBook removeAddress(String addressTitle) throws AddressBookDaoException {
        AddressBook removedAddress;
        try {
            removedAddress = addressLibrary.remove(addressTitle);
            writeLibrary();
        } catch (AddressBookDaoException e) {
            throw new AddressBookDaoException(
                    "Could not save Address Entry data.", e);
        }
        return removedAddress;
    }

    private Map<String, AddressBook> addressLibrary = new HashMap<>();

    public static final String LIBRARY_FILE = "library.txt";
    public static final String DELIMITER = "::";

    public void loadRoster() throws AddressBookDaoException {
        Scanner scanner;
        AddressBook currentAddress;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new AddressBookDaoException("-_- Could not load Address Entry data.", e);
        }
        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            currentAddress = new AddressBook();
            currentAddress.setAddressTitle(currentTokens[0]);
            currentAddress.setStreetName(currentTokens[1]);
            currentAddress.setOccupantFirstName(currentTokens[2]);
            currentAddress.setOccupantLastName(currentTokens[3]);
            currentAddress.setAddressState(currentTokens[4]);

            addressLibrary.put(currentAddress.getAddressTitle(), currentAddress);
        }
        scanner.close();
    }

    public void writeLibrary() throws AddressBookDaoException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new AddressBookDaoException(
                    "Could not save Address Entry data.", e);
        }

        List<AddressBook> addressList = this.getAllAddresses();
        for (AddressBook currentAddress : addressList) {
            out.println(currentAddress.getAddressTitle() + DELIMITER
                    + currentAddress.getStreetName() + DELIMITER
                    + currentAddress.getOccupantFirstName() + DELIMITER
                    + currentAddress.getOccupantLastName() + DELIMITER
                    + currentAddress.getAddressState());
            out.flush();
        }
        out.close();
    }
}



    
