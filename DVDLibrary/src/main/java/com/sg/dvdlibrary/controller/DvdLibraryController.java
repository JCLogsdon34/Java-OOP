package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.dao.DvdLibraryPersistenceException;
import com.sg.dvdlibrary.dto.Dvd;
import com.sg.dvdlibrary.service.DvdLibraryDataValidationException;
import com.sg.dvdlibrary.service.DvdLibraryDuplicateIdException;
import com.sg.dvdlibrary.service.DvdLibraryServiceLayer;
import com.sg.dvdlibrary.ui.DvdView;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DvdLibraryController {

    DvdView view;
    private DvdLibraryServiceLayer service;

    public DvdLibraryController(DvdLibraryServiceLayer service, DvdView view) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection;

        while (keepGoing) {
            menuSelection = getMenuSelection();
            switch (menuSelection) {
                case 1:
                    try {
                        listDvds();
                    } catch (DvdLibraryPersistenceException e) {
                        view.displayErrorMessage(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        createDvd();
                    } catch (DvdLibraryPersistenceException | DvdLibraryDuplicateIdException | DvdLibraryDataValidationException e) {
                        view.displayErrorMessage(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        viewDvd();
                    } catch (DvdLibraryPersistenceException e) {
                        view.displayErrorMessage(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        removeDvd();
                    } catch (DvdLibraryPersistenceException e) {
                        view.displayErrorMessage(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        editDvd();
                    } catch (DvdLibraryPersistenceException e) {
                        view.displayErrorMessage(e.getMessage());
                    }
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
                    break;
            }
        }
        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDvd() throws DvdLibraryPersistenceException, DvdLibraryDuplicateIdException, DvdLibraryDataValidationException {
        Dvd newDvd;
        view.displayCreateDvdBanner();
        boolean hasErrors = false;
    do {
        newDvd = view.getNewDvdInfo();
        try {
            service.createDvd(newDvd);
            view.displayCreateSuccessBanner();
            hasErrors = false;
        } catch (DvdLibraryDuplicateIdException | DvdLibraryDataValidationException e) {
            hasErrors = true;
            view.displayErrorMessage(e.getMessage());
        }
    } while (hasErrors);
    
        view.displayCreateSuccessBanner();
        }

    private void listDvds() throws DvdLibraryPersistenceException {
        List<Dvd> dvdList;
            view.displayDisplayDvdBanner();
            dvdList = service.getAllDvds();
            view.displayDvdList(dvdList); 
    }

    private void viewDvd() throws DvdLibraryPersistenceException {
        String dvdTitle;
        Dvd dvd;
        view.displayDisplayDvdBanner();
        dvdTitle = view.getDvdTitleChoice();
        dvd = service.getDvd(dvdTitle);
        view.displayDvd(dvd);
    }

    private void removeDvd() throws DvdLibraryPersistenceException {
        String dvdTitle;
            view.displayRemoveDvdBanner();
            dvdTitle = view.getDvdTitleChoice();
            service.removeDvd(dvdTitle);
            view.displayRemoveSuccessBanner();
    }

    private void editDvd() throws DvdLibraryPersistenceException {
        String dvdTitle;
        Dvd currentDvd;
            view.displayEditDvdBanner();
            dvdTitle = view.getDvdTitleChoice();
            currentDvd = service.getDvd(dvdTitle);
            currentDvd = view.getDvdForUserEdit(dvdTitle, currentDvd);
            view.displayCreateSuccessBanner();
        view.displayEditSuccessBanner();
    }
    

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
