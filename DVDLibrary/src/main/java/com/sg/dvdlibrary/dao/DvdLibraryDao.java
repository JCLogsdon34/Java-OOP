package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface DvdLibraryDao {

    Dvd addDvd(String dvdTitle, Dvd dvd)
            throws DvdLibraryPersistenceException;

    List<Dvd> getAllDvds()
            throws DvdLibraryPersistenceException; 
    
    Dvd getDvd(String dvdTitle)
            throws DvdLibraryPersistenceException;

    Dvd removeDvd(String dvdTitle)
            throws DvdLibraryPersistenceException;
    
    public void addDvd(Dvd dvd)
          throws DvdLibraryPersistenceException;

    public Map<String, List<Dvd>> getAllDvdsGroupByProductionStudio(String studioName)
        throws DvdLibraryPersistenceException;

    public List<Dvd> getDvdsByProductionStudio(String studioName)
            throws DvdLibraryPersistenceException;
    
    public List <Dvd> getDvdsByMpaaRating(String mpaaRating)
            throws DvdLibraryPersistenceException;
    
    public Map<String, List<Dvd>> getAllDvdsGroupByMpaaRating(String mpaaRating)
        throws DvdLibraryPersistenceException;
    
    public Map<String, List<Dvd>> getAllDvdsGroupByDirectorsName(String directorsName)
        throws DvdLibraryPersistenceException;

    public List<Dvd> getDvdsByDirectorsName(String directorsName)
            throws DvdLibraryPersistenceException;

    public List<Dvd> getDvdsOlderThan(String releaseDate)
            throws DvdLibraryPersistenceException;
    
    public List<Dvd> getDvdsYoungerThan(String releaseDate)
             throws DvdLibraryPersistenceException;
    
    public Map<String, List<Dvd>> getDvdsYoungerThanGroupByReleaseDate(String releaseDate)
            throws DvdLibraryPersistenceException;

    public Map<String, List<Dvd>> getDvdsOlderThanGroupByReleaseDate(String releaseDate)
            throws DvdLibraryPersistenceException;
    
    public List<Dvd> getAverageDvdAge(String releaseDate)
            throws DvdLibraryPersistenceException;
    
    public Map<String, List<Dvd>> getAllDvdsGroupByUserRating(String userRating) 
            throws DvdLibraryPersistenceException;

    public List<Dvd> getDvdsByUserRating(String UserRating) throws 
            DvdLibraryPersistenceException;
}
