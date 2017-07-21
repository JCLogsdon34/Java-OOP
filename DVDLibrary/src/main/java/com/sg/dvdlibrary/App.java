package com.sg.dvdlibrary;

import com.sg.dvdlibrary.controller.DvdLibraryController;
import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.dao.DvdLibraryDaoException;
import com.sg.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.sg.dvdlibrary.ui.DvdView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    public static void main(String[] args) throws DvdLibraryDaoException {
        try {
            UserIO myIo = new UserIOConsoleImpl();
            DvdView myView = new DvdView(myIo);
            DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
            DvdLibraryController controller
                    = new DvdLibraryController(myDao, myView);
            controller.run();
        } catch (DvdLibraryDaoException e) {
            throw new DvdLibraryDaoException(
                    "Could not save DVD data.", e);
        }
    }
}
