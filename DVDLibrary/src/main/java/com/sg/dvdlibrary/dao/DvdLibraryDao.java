package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface DvdLibraryDao {

    Dvd addDvd(String dvdTitle, Dvd dvd)
            throws DvdLibraryPersistenceException;

    List<Dvd> getAllDvds()
            throws DvdLibraryPersistenceException; 
    
    Dvd getDvd(String dvdTitle)
            throws DvdLibraryPersistenceException;

    Dvd removeDvd(String dvdTitle)
            throws DvdLibraryPersistenceException;
    
//  public void addServer(Server server);

//  public Server getServer(String name);

//  public void removeServer(String name);

//  public List<Server> getAllServers();
    

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

    public List<Dvd> getDvdsOlderThan(LocalDate releaseDate)
            throws DvdLibraryPersistenceException;
    
    public Map<LocalDate, List<Dvd>> getDvdsYoungerThanGroupByReleaseDate(LocalDate releaseDate)
            throws DvdLibraryPersistenceException;

    public Map<LocalDate, List<Dvd>> getDvdsOlderThanGroupByReleaseDate(LocalDate releaseDate)
            throws DvdLibraryPersistenceException;
    public double getAverageDvdAge()
            throws DvdLibraryPersistenceException;
    

}
