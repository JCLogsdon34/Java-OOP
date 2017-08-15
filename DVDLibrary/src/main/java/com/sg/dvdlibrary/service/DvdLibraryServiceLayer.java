
package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dao.DvdLibraryPersistenceException;
import com.sg.dvdlibrary.dto.Dvd;
import java.util.List;

public interface DvdLibraryServiceLayer {
    
    void createDvd(Dvd dvd) throws
            DvdLibraryDuplicateIdException,
            DvdLibraryDataValidationException,
            DvdLibraryPersistenceException;
 
    List<Dvd> getAllDvds() throws
            DvdLibraryPersistenceException;
 
    Dvd getDvd(String dvdtitle) throws
            DvdLibraryPersistenceException;
 
    Dvd removeDvd(String dvdTitle) throws
            DvdLibraryPersistenceException;
            
}
