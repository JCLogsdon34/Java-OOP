/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public DvdLibraryDaoFileImpl() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
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
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException(
                    "-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentTokens holds each of the parts of the currentLine after it has
        // been split on our DELIMITER
        // NOTE FOR APPRENTICES: In our case we use :: as our delimiter.  If
        // currentLine looks like this:
        // 1234::Joe::Smith::Java-September2013
        // then currentTokens will be a string array that looks like this:
        //
        // ___________________________________
        // |    |   |     |                  |
        // |1234|Joe|Smith|Java-September2013|
        // |    |   |     |                  |
        // -----------------------------------
        //  [0]  [1]  [2]         [3]
        String[] currentTokens;
        // Go through ROSTER_FILE line by line, decoding each line into a 
        // Student object.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // break up the line into tokens
            currentTokens = currentLine.split(DELIMITER);
            // Create a new Student object and put it into the map of students
            // NOTE FOR APPRENTICES: We are going to use the student id
            // which is currentTokens[0] as the map key for our student object.
            // We also have to pass the student id into the Student constructor
            DVD currentDvd = new DVD (currentTokens[0]);
            // Set the remaining vlaues on currentStudent manually
            currentDvd.setDVDTitle(currentTokens[1]);
            currentDvd.setReleaseDate(currentTokens[2]);
            currentDvd.setMpaaRating(currentTokens[3]);
            currentDvd.setDirectorsName(currentTokens[4]);
            currentDvd.setStudioName(currentTokens[5]);
            currentDvd.setUserRating(currentTokens[6]);
            
            // Put currentStudent into the map using studentID as the key
            dvds.put(currentDvd.getDvdTitle(), currentDvd);
        }
        // close scanner
        scanner.close();
    }

    /**
     * Writes all students in the roster out to a ROSTER_FILE. See loadRoster
     * for file format.
     *
     * @throws ClassRosterDaoException if an error occurs writing to the file
     */
    private void writeLibrary() throws DvdLibraryDaoException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new DvdLibraryDaoException(
                    "Could not save student data.", e);
        }

        // Write out the Student objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the student map,
        // get the Collection of Students and iterate over them but we've
        // already created a method that gets a List of Students so
        // we'll reuse it.
        List<DVD> dvdList = this.getAllDvds();
        for (DVD currentDvd : dvdList) {
            // write the Student object to the file
            out.println(currentDvd.getDvdTitle() + DELIMITER
                    + currentDvd.getReleaseDate() + DELIMITER
                    + currentDvd.getMpaaRating() + DELIMITER
                    + currentDvd.getDirectorsName() + DELIMITER
                    + currentDvd.getStudioName() + DELIMITER
                    + currentDvd.getUserRating() + DELIMITER);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }

    @Override
    public void addDVD(String dvdTitle, DVDView newDVD) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


