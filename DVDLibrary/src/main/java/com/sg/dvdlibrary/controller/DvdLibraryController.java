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

    public void run() throws DvdLibraryDaoException  {
        boolean keepGoing = true;
        int menuSelection;
        do {
            menuSelection = getMenuSelection();
            switch (menuSelection) {
                case 1:
            {
                try {
                    listDvds();
                } catch (DvdLibraryDaoException e) {
            throw new DvdLibraryDaoException(
                    "Could not save DVD data.", e);
        }
            }
                    break;
                case 2:
                    try{
                    createDvd();
                    } catch (DvdLibraryDaoException e) {
            throw new DvdLibraryDaoException(
                    "Could not save DVD data.", e);
        }
                    break;
                case 3:
                    try{
                    viewDvd();
                    } catch (DvdLibraryDaoException e) {
            throw new DvdLibraryDaoException(
                    "Could not save DVD data.", e);
        }
                    break;
                case 4:
                    try{
                    removeDvd();
                    } catch (DvdLibraryDaoException e) {
            throw new DvdLibraryDaoException(
                    "Could not save DVD data.", e);
        }
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

    private void createDvd() throws DvdLibraryDaoException {
        view.displayCreateDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();

        try {
            dao.addDvd(newDvd.getDvdTitle(), newDvd);
        } catch (DvdLibraryDaoException e) {
            throw new DvdLibraryDaoException(
                    "Could not save DVD data.", e);
        }
        view.displayCreateSuccessBanner();
    }

    private void listDvds() throws DvdLibraryDaoException {
        view.displayDisplayDvdBanner();
        List<Dvd> dvdList = null;
        try {
            dvdList = dao.getAllDvds();
        } catch (DvdLibraryDaoException e) {
            throw new DvdLibraryDaoException(
                    "Could not save DVD data.", e);
        }
        view.displayDvdList(dvdList);
    }

    private void viewDvd() throws DvdLibraryDaoException {
        view.displayDisplayDvdBanner();
        String dvdTitle = view.getDvdTitleChoice();
        Dvd dvd = null;
        try {
            dvd = dao.getDvd(dvdTitle);
        } catch (DvdLibraryDaoException e) {
            throw new DvdLibraryDaoException(
                    "Could not save DVD data.", e);
        }
        view.displayDvd(dvd);
    }

    private void removeDvd() throws DvdLibraryDaoException {
        view.displayRemoveDvdBanner();
        String dvdTitle = view.getDvdTitleChoice();
        try {
            dao.removeDvd(dvdTitle);
        } catch (DvdLibraryDaoException e) {
            throw new DvdLibraryDaoException(
                    "Could not save DVD data.", e);
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
