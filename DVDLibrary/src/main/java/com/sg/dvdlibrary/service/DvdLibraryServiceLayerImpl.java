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
    /*
        public String getDvdListOptionChoice() {
        boolean keepOnKeepingOn = true;
        int userSelection;
        String releaseDate;
        String mpaaRating;
        String directorsName;
        String userRating;
        String studioName;

        while (keepOnKeepingOn) {

            switch (userSelection) {
                case 1:
                    LocalDate formatted;
                    String theReleaseDate;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("DD-mm-yyyy");
                     io.readLocalDate("Please enter a release date dd-mm-yyyy");
                    formatted = io.readLocalDate("Please enter a Release Date from which to start  a list to the present"
                    + "dd-mm-yyyy");
                    theReleaseDate = formatter.format(formatted);
                    io.print("Thank You, here you go");
                    keepOnKeepingOn = false;
                    return theReleaseDate;
                    break;
                case 2:
                    LocalDate formatted;
                    String theReleaseDate;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("DD-mm-yyyy");
                     io.readLocalDate("Please enter a release date dd-mm-yyyy");
                    formatted = io.readLocalDate("Please enter a Release Date from which to start a list to the present"
                    + "dd-mm-yyyy");
                    theReleaseDate = formatter.format(formatted);
                    keepOnKeepingOn = false;
                    return theReleaseDate;
                    break;
                case 3:
                    
                    boolean inputValidate;
                    do {
                        studioName = io.readString("Please enter the studio name by which you want to list your dvds");
                        if (directorsName != null && !directorsName.isEmpty()) {
                            currentDvd.setDirectorsName(directorsName);
                            io.print("Your change to the Director's Name has been noted");
                            inputValidate = true;
                        } else {
                            inputValidate = false;
                        }
                    } while (inputValidate == false);
                     keepOnKeepingOn = false;
                    return studioName;
                    break;
                case 4:
                    boolean inputBool;
                    do {
                        directorsName= io.readString("Please enter the name of the director by which to organize a list");
                        if (directorsName != null && !directorsName.isEmpty()) {
                            io.print("Thank You");
                            inputBool = true;
                        } else {
                            inputBool = false;
                        }
                    } while (inputBool == false);
                     keepOnKeepingOn = false;
                    return directorsName;
                    break;
                case 5:
                     boolean inputTry;
                    do {
                        mpaaRating = io.readString("Please enter your desired changes for the MPAA Rating");
                        if (mpaaRating != null && !mpaaRating.isEmpty()) {

                            io.print("Thank You");
                            inputTry = true;
                        } else {
                            inputTry = false;
                        }
                    } while (inputTry == false);
                    keepOnKeepingOn = false;
                    return mpaaRating;
                    break;
                case 6:
                    boolean inputTry;
                    do {
                        userRating = io.readString("Please enter user rating by which you would like to organize a list");
                        if (userRating != null && !userRating.isEmpty()) {
                            io.print("Thank You");
                            inputTry = true;
                        } else {
                            inputTry = false;
                        }
                    } while (inputTry == false);
                     keepOnKeepingOn = false;
                    return userRating;
                    break;
                case 7:
                    keepOnKeepingOn = false;
                    break;
                default:
                    io.print("Invalid Input, please enter one of the numbered chocies");
                    break;
            }
        }
        return currentDvd;
    }
    */
    
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
