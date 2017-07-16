
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.ui.DVDView;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DvdLibraryDaoFileImpl implements DvdLibraryDao {

    
    

    
    @Override
    public DVD addDvd(String dvdTitle, DVD dvd)
            throws DvdLibraryDaoException {
        DVD newDvd = dvds.put(dvdTitle, dvd);
        writeLibrary();
        return newDvd;
    }

    @Override
    public List<DVD> getAllDvds()
            throws DvdLibraryDaoException {
        try {
            loadRoster();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DvdLibraryDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD getDvd(String dvdTitle)
            throws DvdLibraryDaoException {
        try {
            loadRoster();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DvdLibraryDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dvds.get(dvdTitle);
    }

    @Override
    public DVD removeDvd(String dvdTitle)
            throws DvdLibraryDaoException {
        DVD removedDvd = dvds.remove(dvdTitle);
        writeLibrary();
        return removedDvd;
    }

    private Map<String, DVD> dvds = new HashMap<>();

    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";

    private void loadRoster() throws DvdLibraryDaoException, FileNotFoundException {
        Scanner scanner;

        try {
            
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException(
                    "-_- Could not load roster data into memory.", e);
        }
       
        String currentLine;
        
        String[] currentTokens;
       
        while (scanner.hasNextLine()) {
       
            currentLine = scanner.nextLine();
           
            currentTokens = currentLine.split(DELIMITER);
            
            DVD currentDvd = new DVD(currentTokens[0]); 
            currentDvd.setDvdTitle(currentTokens[1]);
            currentDvd.setReleaseDate(currentTokens[2]);
            currentDvd.setMpaaRating(currentTokens[3]);
            currentDvd.setDirectorsName(currentTokens[4]);
            currentDvd.setStudioName(currentTokens[5]);
            currentDvd.setUserRating(currentTokens[6]);
            
      
            dvds.put(currentDvd.getDvdTitle(), currentDvd);
        }
      
        scanner.close();
    }

    
    private void writeLibrary() throws DvdLibraryDaoException {
        
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new DvdLibraryDaoException(
                    "Could not save student data.", e);
        }

        
        List<DVD> dvdList = this.getAllDvds();
        for (DVD currentDvd : dvdList) {
            
            out.println(currentDvd.getDvdTitle() + DELIMITER
                    + currentDvd.getReleaseDate() + DELIMITER
                    + currentDvd.getMpaaRating() + DELIMITER
                    + currentDvd.getDirectorsName() + DELIMITER
                    + currentDvd.getStudioName() + DELIMITER
                    + currentDvd.getUserRating() + DELIMITER);
            
            out.flush();
        }
        
        out.close();
    }
    @Override
    public void addDvd(String dvdTitle, DVDView newDvd) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}


