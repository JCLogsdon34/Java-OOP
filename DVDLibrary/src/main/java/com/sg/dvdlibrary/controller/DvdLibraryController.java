package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.dao.DvdLibraryDaoException;
import com.sg.dvdlibrary.dto.Dvd;
import com.sg.dvdlibrary.ui.DvdView;
import java.util.List;

public class DvdLibraryController {

    DvdView view;
    DvdLibraryDao dao;

    public DvdLibraryController(DvdLibraryDao dao, DvdView view) {
        this.view = view;
        this.dao = dao;
    }

    public void run() {
        boolean keepGoing = false;
        int menuSelection;

        while (keepGoing) {
            menuSelection = getMenuSelection();
            switch (menuSelection) {
                case 1:
                    try {
                        listDvds();
                    } catch (DvdLibraryDaoException e) {
                        view.displayErrorMessage(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        createDvd();
                    } catch (DvdLibraryDaoException e) {
                        view.displayErrorMessage(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        viewDvd();
                    } catch (DvdLibraryDaoException e) {
                        view.displayErrorMessage(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        removeDvd();
                    } catch (DvdLibraryDaoException e) {
                        view.displayErrorMessage(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        editDvd();
                    } catch (DvdLibraryDaoException e) {
                        view.displayErrorMessage(e.getMessage());
                    }
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
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDvd() throws DvdLibraryDaoException {
        Dvd newDvd;
        view.displayCreateDvdBanner();
        newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getDvdTitle(), newDvd);
        view.displayCreateSuccessBanner();
    }

    private void listDvds() throws DvdLibraryDaoException {
        List<Dvd> dvdList;
        try {
            view.displayDisplayDvdBanner();
            dvdList = dao.getAllDvds();
            view.displayDvdList(dvdList);
        } catch (DvdLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void viewDvd() throws DvdLibraryDaoException {
        String dvdTitle;
        Dvd dvd;
        view.displayDisplayDvdBanner();
        dvdTitle = view.getDvdTitleChoice();
        dvd = dao.getDvd(dvdTitle);
        view.displayDvd(dvd);
    }

    private void removeDvd() throws DvdLibraryDaoException {
        String dvdTitle;
        try {
            view.displayRemoveDvdBanner();
            dvdTitle = view.getDvdTitleChoice();
            dao.removeDvd(dvdTitle);
            view.displayRemoveSuccessBanner();
        } catch (DvdLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void editDvd() throws DvdLibraryDaoException {
        String dvdTitle;
        Dvd currentDvd;
        Dvd dvd;
        try {
            view.displayEditDvdBanner();
            dvdTitle = view.getDvdTitleChoice();
            currentDvd = dao.getDvd(dvdTitle);
            dvd = view.getDvdForUserEdit(dvdTitle, currentDvd);
            dao.addDvd(dvdTitle, dvd);
            view.displayEditSuccessBanner();
        } catch (DvdLibraryDaoException e) {
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
