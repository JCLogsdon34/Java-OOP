package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;
import java.util.List;

public interface DvdLibraryDao {

    Dvd addDvd(String dvdTitle, Dvd dvd)
            throws DvdLibraryPersistenceException;

    List<Dvd> getAllDvds()
            throws DvdLibraryPersistenceException; 
    
    Dvd getDvd(String dvdTitle)
            throws DvdLibraryPersistenceException;

    Dvd removeDvd(String dvdTitle)
            throws DvdLibraryPersistenceException;

}
