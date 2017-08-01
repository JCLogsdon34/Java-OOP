
package com.sg.addressbook.dao;

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
    public Address addAddress(String addressTitle, Address address) throws AddressBookDaoException {
        try {
            Address newAddress = addressLibrary.put(addressTitle, address);
            writeLibrary();
            return newAddress;
        } catch (AddressBookDaoException e) {
            throw new AddressBookDaoException(
                    "Could not save Address Entry data.", e);
        }
    }

    @Override
    public List<Address> getAllAddresses() throws AddressBookDaoException {
        try {
            loadRoster();
        } catch (AddressBookDaoException e) {
            throw new AddressBookDaoException(
                    "Could not save Address Entry data.", e);
        }
        return new ArrayList<>(addressLibrary.values());
    }

    @Override
    public Address getAddress(String addressTitle) throws AddressBookDaoException {
            loadRoster();
        } catch (AddressBookDaoException e) {
            throw new AddressBookDaoException(
                    "Could not save Address Entry data.", e);
        }
        return addressLibrary.get(addressTitle);
    }

    @Override
    public Address removeAddress(String addressTitle) throws AddressBookDaoException {
        Address removedAddress;
        try {
            removedAddress = addressLibrary.remove(addressTitle);
            writeLibrary();
        } catch (AddressBookDaoException e) {
            throw new AddressBookDaoException(
                    "Could not save Address Entry data.", e);
        }
        return removedAddress;
    }

    private Map<String, Address> addressLibrary = new HashMap<>();

    public static final String LIBRARY_FILE = "library.txt";
    public static final String DELIMITER = "::";

    public void loadRoster() throws AddressBookDaoException {
        Scanner scanner;
        Dvd currentAddress;
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
            currentAddress = new Address();
            currentAddress.setAddressTitle(currentTokens[0]);
            currentAddress.setReleaseDate(currentTokens[1]);
            currentAddress.setMpaaRating(currentTokens[2]);
            currentAddress.setDirectorsName(currentTokens[3]);
            currentAddress.setStudioName(currentTokens[4]);
            currentAddress.setUserRating(currentTokens[5]);

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
        List<Address> addressList = this.getAllAddresses();
        for (Address currentAddress : addressList) {
            out.println(currentAddress.getAddressTitle() + DELIMITER
                    + currentAddress.getReleaseDate() + DELIMITER
                    + currentAddress.getMpaaRating() + DELIMITER
                    + currentAddress.getDirectorsName() + DELIMITER
                    + currentAddress.getStudioName() + DELIMITER
                    + currentAddress.getUserRating() + DELIMITER);
            out.flush();
        }
        out.close();
    }
}


    
