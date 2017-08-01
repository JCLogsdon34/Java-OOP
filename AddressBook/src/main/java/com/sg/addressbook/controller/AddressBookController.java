
package com.sg.addressbook.controller;

import com.sg.addressbook.dao.AddressBookDao;
import com.sg.addressbook.dao.AddressBookDaoException;
import com.sg.addressbook.ui.AddressBookView;
import java.util.List;


public class AddressBookController {
    AddressBookView view;
    AddressBookDao dao;

    public AddressBookController(AddressBookDao dao, AddressBookView view) {
        this.view = view;
        this.dao = dao;
    }

    public void run() {
        boolean keepGoing = false;
        int menuSelection;
        try {
            while (keepGoing == false) {
                menuSelection = getMenuSelection();
                switch (menuSelection) {
                    case 1:
                        listAddresses();
                        break;
                    case 2:
                        createAddress();
                        break;
                    case 3:
                        viewAddress();
                        break;
                    case 4:
                        removeAddress();
                        break;
                    case 5:
                        editAddress();
                        break;
                    case 6:
                        keepGoing = true;
                        break;
                    default:
                        unknownCommand();
                        break;
                }
            }
            exitMessage();
        } catch (AddressBookDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createAddress() throws AddressBookDaoException {
        Address newAddress;
        view.displayCreateAddressEntryBanner();
        newAddress = view.getNewAddressInfo();
        dao.addAddress(newAddress.getAddressTitle(), newAddress);
        view.displayCreateSuccessBanner();
    }

    private void listAddresses() throws AddressBookDaoException {
        List<Address> addressList;
        try {
            view.displayDisplayAddressEntryBanner();
            addressList = dao.getAllAddresses();
            view.displayDvdList(addressList);
        } catch (AddressBookDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void viewAddress() throws AddressBookDaoException {
        String addressTitle;
        Address address;
        view.displayDisplayAddressEntryBanner();
        addressTitle = view.getAddressTitleChoice();
        address = dao.getAddress(addressTitle);
        view.displayAddress(address);
    }

    private void removeAddress() throws AddressBookDaoException {
        String addressTitle;
        try {
            view.displayRemoveAddressEntryBanner();
            addressTitle = view.getAddressTitleChoice();
            dao.removeAddress(addressTitle);
            view.displayRemoveSuccessBanner();
        } catch (AddressBookDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void editAddress() throws AddressBookDaoException {
        String addressTitle;
        Address currentAddress;
        Address address;
        try {
            view.displayEditAddressEntryBanner();
            addressTitle = view.getAddressTitleChoice();
            currentAddress = dao.getAddress(addressTitle);
            address = view.getAddressForUserEdit(addressTitle, currentAddress);
            dao.addAddressvd(addressTitle, address);
            view.displayEditSuccessBanner();
        } catch (AddressBookDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}


