
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.ui.DVDView;
import java.util.List;


public interface DvdLibraryDao {
    
    DVD addDvd(String dvdTitle, DVD dvd)
            throws DvdLibraryDaoException;

    List<DVD> getAllDvds()
            throws DvdLibraryDaoException;

    DVD getDvd(String dvdTitle)
            throws DvdLibraryDaoException;

    DVD removeDvd(String dvdTitle)
            throws DvdLibraryDaoException;

    public void addDvd(String dvdTitle, DVDView newDvd);

}


