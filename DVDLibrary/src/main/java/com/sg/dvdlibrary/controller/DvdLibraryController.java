
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.dao.DvdLibraryDaoException;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.ui.DVDView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;


public class DvdLibraryController {
    UserIO io = new UserIOConsoleImpl();
    
    DVDView view;
    DvdLibraryDao dao;

    public DvdLibraryController(DvdLibraryDao dao, DVDView view) {
        this.view = view;
        this.dao = dao;
    }
    

    public void run() throws DvdLibraryDaoException {
        boolean keepGoing = true;
        int menuSelection;
        while (keepGoing) {
            
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
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDvd() throws DvdLibraryDaoException {
        view.displayCreateDvdBanner();
        DVDView newDvd = view.getNewDVDInfo();
        dao.addDvd(newDvd.getDVDTitle(), newDvd);
        view.displayCreateSuccessBanner();
    }

    private void listDvds() throws DvdLibraryDaoException {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = dao.getAllDvds();
        view.displayDVDList(dvdList);
    }

    private void viewDvd() throws DvdLibraryDaoException {
        view.displayDisplayDvdBanner();
        String dvdTitle = view.getDvdTitleChoice();
        DVD dvd = dao.getDvd(dvdTitle);
        view.DVDTitle(dvd);
    }

    private void removeDvd() throws DvdLibraryDaoException {
        view.displayRemoveDvdBanner();
        String dvdTitle = view.getDvdtitleChoice();
        dao.removeDvd(dvdTitle);
        view.displayRemoveSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
