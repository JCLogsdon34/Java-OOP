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
        try {
            while (keepGoing == false) {
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
                        keepGoing = true;
                        break;
                    default:
                        unknownCommand();
                        break;
                }
            }
            exitMessage();
        } catch (DvdLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDvd() throws DvdLibraryDaoException {
        view.displayCreateDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getDvdTitle(), newDvd);
        view.displayCreateSuccessBanner();
    }

    private void listDvds() throws DvdLibraryDaoException {
        try {
            view.displayDisplayDvdBanner();
            List<Dvd> dvdList;
            dvdList = dao.getAllDvds();
            view.displayDvdList(dvdList);
        } catch (DvdLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void viewDvd() throws DvdLibraryDaoException {
        String prompt = null;
        view.displayDisplayDvdBanner();
        String dvdTitle = view.getDvdTitleChoice(prompt);
        Dvd dvd = dao.getDvd(dvdTitle);
        view.displayDvd(dvd);
    }

    private void removeDvd() throws DvdLibraryDaoException {
        try {
            view.displayRemoveDvdBanner();
            String prompt = null;
            String dvdTitle = view.getDvdTitleChoice(prompt);
            dao.removeDvd(dvdTitle);
            view.displayRemoveSuccessBanner();
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
