package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dao.DvdLibraryAuditDao;
import com.sg.dvdlibrary.dao.DvdLibraryAuditDaoImpl;
import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.sg.dvdlibrary.dao.DvdLibraryPersistenceException;
import com.sg.dvdlibrary.dto.Dvd;
import java.util.List;
import java.util.Map;

public class DvdLibraryServiceLayerImpl implements
        DvdLibraryServiceLayer {

    private DvdLibraryDao dao = new DvdLibraryDaoFileImpl();
    private DvdLibraryAuditDao auditDao = new DvdLibraryAuditDaoImpl();

    public DvdLibraryServiceLayerImpl(DvdLibraryDao dao, DvdLibraryAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void createDvd(Dvd dvd) throws
            DvdLibraryDuplicateIdException,
            DvdLibraryDataValidationException,
            DvdLibraryPersistenceException {

        if (dao.getDvd(dvd.getDvdTitle()) != null) {
            throw new DvdLibraryDuplicateIdException(
                    "ERROR: Could not create Dvd.  Dvd title"
                    + dvd.getDvdTitle()
                    + " already exists");
        }
        validateDvdData(dvd);
        dao.addDvd(dvd.getDvdTitle(), dvd);
        
        auditDao.writeAuditEntry(
            "Dvd " + dvd.getDvdTitle() + " CREATED.");
    }

    @Override
    public List<Dvd> getAllDvds() throws DvdLibraryPersistenceException {
        return dao.getAllDvds();
    }
    
    
    public List<Dvd> getAllDvdsOlderThan(String releaseDate) 
            throws DvdLibraryPersistenceException{
    //    List<Dvd> dvdsOlderThan;
      //         dvdsOlderThan  = dao.getDvdsOlderThan(releaseDate);
               
              return dao.getDvdsOlderThan(releaseDate);
    } 
    
    public Map<String, List<Dvd>> getDvdsOlderThanGroupByReleaseDate(String releaseDate)
            throws DvdLibraryPersistenceException{
        
        return dao.getDvdsOlderThanGroupByReleaseDate(releaseDate);
    }
    //use a for-loop to detertmine which, or rather a switch
    public List<Dvd> getAllDvdsYoungThan(String releaseDate) 
            throws DvdLibraryPersistenceException{
        return dao.getDvdsYoungerThan(releaseDate);
    }
    
    
    
    @Override
    public Dvd getDvd(String dvdTitle) throws DvdLibraryPersistenceException {
        return dao.getDvd(dvdTitle);
    }

    @Override
    public Dvd removeDvd(String dvdTitle) throws DvdLibraryPersistenceException {
        Dvd removedDvd = dao.removeDvd(dvdTitle);

    auditDao.writeAuditEntry("Dvd " + dvdTitle+ " REMOVED.");
        return dao.removeDvd(dvdTitle);
    }

    private void validateDvdData(Dvd dvd) throws
            DvdLibraryDataValidationException {

        if (dvd.getDvdTitle() == null
                || dvd.getDvdTitle().trim().length() == 0
                || dvd.getDirectorsName() == null
                || dvd.getDirectorsName().trim().length() == 0
                || dvd.getMpaaRating() == null
                || dvd.getMpaaRating().trim().length() == 0
                || dvd.getStudioName() == null
                || dvd.getStudioName().trim().length() == 0
                || dvd.getUserRating() == null
                || dvd.getUserRating().trim().length() == 0) {

            throw new DvdLibraryDataValidationException(
                    "ERROR: All fields [Dvd Title, Directors Name, Mpaa Rating"
                    + " Studio Name, user Rating, and Dvd] are required.");
        }
    }
}
