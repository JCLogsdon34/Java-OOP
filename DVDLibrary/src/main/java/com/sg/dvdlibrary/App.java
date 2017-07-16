
package com.sg.dvdlibrary;

import com.sg.dvdlibrary.controller.DvdLibraryController;
import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.dao.DvdLibraryDaoException;
import com.sg.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.sg.dvdlibrary.ui.DVDView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;


public class App {
    
     public static void main(String[] args) throws DvdLibraryDaoException {
        UserIO myIo = new UserIOConsoleImpl();
        DVDView myView = new DVDView(myIo);
        DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
        DvdLibraryController controller 
                = new DvdLibraryController(myDao, myView);
        controller.run();
        
    }
}
