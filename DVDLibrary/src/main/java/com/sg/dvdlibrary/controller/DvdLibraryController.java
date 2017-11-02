package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DvdLibraryPersistenceException;
import com.sg.dvdlibrary.dto.Dvd;
import com.sg.dvdlibrary.service.DvdLibraryDataValidationException;
import com.sg.dvdlibrary.service.DvdLibraryDuplicateIdException;
import com.sg.dvdlibrary.service.DvdLibraryServiceLayer;
import com.sg.dvdlibrary.ui.DvdView;
import java.util.List;
import java.util.Map;

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
        Map<String, List<Dvd>> lambdaDvdMap;
        String theStringChoice;
        boolean keepOnKeepingOn = true;
        int userSelection;

        while (keepOnKeepingOn) {
            userSelection = view.getUserListChoice();
            // theStringChoice = view.getUserListChoice(userSelection);
            switch (userSelection) {
                case 1:
                    //Get list of movies from the last n amount of years
                     // theStringChoice = view.getUserListChoice(userSelection);
                    userSelection = 1;
                    break;
                case 2:
                    //trigger a new method here
                    //Get list of movies older than n years"
                     // theStringChoice = view.getUserListChoice(userSelection);
                    userSelection = 2;
                    break;
                case 3:
                    //trigger a new method here too
                    //Get list of movies younger than n years"
                     // theStringChoice = view.getUserListChoice(userSelection);
                    userSelection = 3;
                    break;
                case 4:
                    //Find all the movies released by a certain studio "
                     // theStringChoice = view.getUserListChoice(userSelection);
                    userSelection = 4;
                    break;
                case 5:
                    //Get list of movies by film director, sorted by Mpaa rating 
                     // theStringChoice = view.getUserListChoice(userSelection);
                    userSelection = 5;
                    break;
                case 6:
                    //Get list of movies by MPAA rating 
                     // theStringChoice = view.getUserListChoice(userSelection);
                    keepOnKeepingOn = false;
                    userSelection = 6;
                    break;
                case 7:
                    //Get list of movies by User Notes"
                     // theStringChoice = view.getUserListChoice(userSelection);
                    keepOnKeepingOn = false;
                    userSelection = 6;
                    break;
                case 8:
                    //Leave the menu
                    keepOnKeepingOn = false;
                    break;
                default:
                    break;
            }
        }
        view.displayDisplayDvdBanner();
        dvdList = service.getAllDvds();
        //      service.callUpLambda(lambdaListChoice);
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
