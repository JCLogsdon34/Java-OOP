package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.dao.DvdLibraryDaoException;
import com.sg.dvdlibrary.dto.Dvd;
import com.sg.dvdlibrary.ui.DvdView;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DvdLibraryController {

    DvdView view;
    DvdLibraryDao dao;

    public DvdLibraryController(DvdLibraryDao dao, DvdView view) {
        this.view = view;
        this.dao = dao;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection;
        do {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    listDvds();
                    break;
                case 2:
                    createDvd();
                    break;
                case 3:
                    viewDvd();
                    break;
                case 4:
                    removeDvd();
                    break;
                case 5:
                    if (menuSelection == 5) {
                        keepGoing = false;
                    }
                    break;
                default:
                    unknownCommand();
            }
        } while (keepGoing);
        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDvd() {
        view.displayCreateDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();

        try {
            dao.addDvd(newDvd.getDvdTitle(), newDvd);
        } catch (DvdLibraryDaoException ex) {
            Logger.getLogger(DvdLibraryController.class.getName()).log(Level.SEVERE, null, ex);
        }

        view.displayCreateSuccessBanner();
    }

    private void listDvds() {
        view.displayDisplayDvdBanner();
        List<Dvd> dvdList = null;
        try {
            dvdList = dao.getAllDvds();
        } catch (DvdLibraryDaoException ex) {
            Logger.getLogger(DvdLibraryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        view.displayDvdList(dvdList);
    }

    private void viewDvd() {
        view.displayDisplayDvdBanner();
        String dvdTitle = view.getDvdTitleChoice();
        Dvd dvd = null;
        try {
            dvd = dao.getDvd(dvdTitle);
        } catch (DvdLibraryDaoException ex) {
            Logger.getLogger(DvdLibraryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        view.displayDvd(dvd);
    }

    private void removeDvd() {
        view.displayRemoveDvdBanner();
        String dvdTitle = view.getDvdTitleChoice();
        try {
            dao.removeDvd(dvdTitle);
        } catch (DvdLibraryDaoException ex) {
            Logger.getLogger(DvdLibraryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        view.displayRemoveSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
