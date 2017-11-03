package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dao.DvdLibraryPersistenceException;
import com.sg.dvdlibrary.dto.Dvd;
import java.util.List;
import java.util.Map;

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

    public Map<String, List<Dvd>> getAllDvdsGroupByProductionStudio(String theStringChoice) throws
            DvdLibraryPersistenceException;

    public List<Dvd> getDvdsByProductionStudio(String theStringChoice) throws
            DvdLibraryPersistenceException;

    public List<Dvd> getDvdsOlderThan(String theStringChoice) throws
            DvdLibraryPersistenceException;

    public List<Dvd> getDvdsYoungerThan(String theStringChoice) throws
            DvdLibraryPersistenceException;

    public Map<String, List<Dvd>> getDvdsOlderThanGroupByReleaseDate(String theStringChoice) throws
            DvdLibraryPersistenceException;

    public List<Dvd> getAverageDvdAge(String theStringChoice) throws
            DvdLibraryPersistenceException;

    public List<Dvd> getDvdsByMpaaRating(String theStringChoice) throws
            DvdLibraryPersistenceException;
    
    public Map<String, List<Dvd>> getAllDvdsGroupByMpaaRating(String theStringChoice)
            throws DvdLibraryPersistenceException;

    public Map<String, List<Dvd>> getAllDvdsGroupByDirectorsName(String theStringChoice) throws
            DvdLibraryPersistenceException;

    public List<Dvd> getDvdsByDirectorsName(String theStringChoice) throws
            DvdLibraryPersistenceException;

    public Map<String, List<Dvd>> getAllDvdsGroupByUserRating(String theStringChoice) throws
            DvdLibraryPersistenceException;

    public List<Dvd> getDvdsByUserRating(String theStringChoice) throws
            DvdLibraryPersistenceException;

    public Map<String, List<Dvd>> getDvdsYoungerThanGroupByReleaseDate(String theStringChoice) throws
            DvdLibraryPersistenceException;

}
