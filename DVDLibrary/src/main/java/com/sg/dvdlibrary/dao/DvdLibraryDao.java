package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;
import java.util.List;

public interface DvdLibraryDao {

    Dvd addDvd(String dvdTitle, Dvd dvd)
            throws DvdLibraryDaoException;
//changge release date  //do not allow this to take only black title
    List<Dvd> getAllDvds()
            throws DvdLibraryDaoException;
    
    Dvd getDvd(String dvdTitle)
            throws DvdLibraryDaoException;

    Dvd removeDvd(String dvdTitle)
            throws DvdLibraryDaoException;

}
