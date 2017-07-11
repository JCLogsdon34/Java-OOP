/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.dao.DvdLibraryDaoException;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.ui.DVDView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author apprentice
 */
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
        int menuSelection = 0;
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
                    viewDVD();
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
        DVDView newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getDVDTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }

    private void listDvds() throws DvdLibraryDaoException {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = dao.getAllDvds();
        view.displayDVDList(dvdList);
    }

    private void viewDVD() throws DvdLibraryDaoException {
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
