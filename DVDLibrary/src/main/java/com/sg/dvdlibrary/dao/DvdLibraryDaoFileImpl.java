package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;

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
    public Dvd addDvd(String dvdTitle, Dvd dvd)
            throws DvdLibraryDaoException {
        Dvd newDvd = dvdRoster.put(dvdTitle, dvd);
        writeLibrary();
        return newDvd;
    }

    @Override
    public List<Dvd> getAllDvds()
            throws DvdLibraryDaoException {
        try {
            loadRoster();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DvdLibraryDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<Dvd>(dvdRoster.values());
    }

    @Override
    public Dvd getDvd(String dvdTitle)
            throws DvdLibraryDaoException {
        try {
            loadRoster();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DvdLibraryDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dvdRoster.get(dvdTitle);
    }

    @Override
    public Dvd removeDvd(String dvdTitle)
            throws DvdLibraryDaoException {
        Dvd removedDvd = dvdRoster.remove(dvdTitle);
        writeLibrary();
        return removedDvd;
    }

    private Map<String, Dvd> dvdRoster = new HashMap<>();

    public static final String LIBRARY_FILE = "library.txt";
    public static final String DELIMITER = "::";

    private void loadRoster() throws DvdLibraryDaoException, FileNotFoundException {
        Scanner scanner;

        try {

            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException(
                    "-_- Could not load roster data into memory.", e);
        }

        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);

            Dvd currentDvd = new Dvd();
            currentDvd.setDvdTitle(currentTokens[0]);
            currentDvd.setReleaseDate(currentTokens[1]);
            currentDvd.setMpaaRating(currentTokens[2]);
            currentDvd.setDirectorsName(currentTokens[3]);
            currentDvd.setStudioName(currentTokens[4]);
            currentDvd.setUserRating(currentTokens[5]);

            dvdRoster.put(currentDvd.getDvdTitle(), currentDvd);
        }
        scanner.close();
    }

    private void writeLibrary() throws DvdLibraryDaoException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DvdLibraryDaoException(
                    "Could not save student data.", e);
        }

        List<Dvd> dvdList = this.getAllDvds();
        for (Dvd currentDvd : dvdList) {

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
}