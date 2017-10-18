package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DvdLibraryDaoFileImpl implements DvdLibraryDao {

    @Override
    public Dvd addDvd(String dvdTitle, Dvd dvd) throws DvdLibraryPersistenceException {
            Dvd newDvd = null;
             
            loadRoster();
            dvdLibrary.get(dvdTitle);
            dvdLibrary.keySet();
                for(String key: dvdLibrary.keySet()){
                if(key.contains(dvdTitle)){
                    System.out.println("You already have this DVD");
                } 
            }
            newDvd = dvdLibrary.put(dvd.getDvdTitle(), dvd);
            writeLibrary();               
            return newDvd;  
    }
    

    @Override
    public List<Dvd> getAllDvds() throws DvdLibraryPersistenceException {
            loadRoster();     
        return new ArrayList<>(dvdLibrary.values());
    }

    @Override
    public Dvd getDvd(String dvdTitle) throws DvdLibraryPersistenceException {
            loadRoster();
            
        return dvdLibrary.get(dvdTitle);
    }

    @Override
    public Dvd removeDvd(String dvdTitle) throws DvdLibraryPersistenceException {
        Dvd removedDvd;
            removedDvd = dvdLibrary.remove(dvdTitle);
            writeLibrary();       
        return removedDvd;
    }

    private Map<String, Dvd> dvdLibrary = new HashMap<>();

    public static final String LIBRARY_FILE = "library.txt";
    public static final String DELIMITER = "::";
    
    @Override
    public void addDvd(Dvd dvd){
        dvdLibrary.put(dvd.getDvdTitle(), dvd);
    }
         
    @Override
    public Map<String, List<Dvd>> getAllDvdsGroupByProductionStudio(String studioName) {
        return dvdLibrary.values()
                .stream()
                .collect(Collectors.groupingBy(Dvd::getStudioName));
    }

    @Override
    public List<Dvd> getDvdsByProductionStudio(String studioName) {
        return dvdLibrary.values()
            .stream()
            .filter(s -> s.getStudioName().equalsIgnoreCase(studioName))
            .collect(Collectors.toList());
    }

    @Override
    public List<Dvd> getDvdsOlderThan(String releaseDate) {

       return dvdLibrary.values()
                .stream()
                .filter(dvd -> dvd.getReleaseDate().equalsIgnoreCase(releaseDate))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Dvd> getDvdsYoungerThan(String releaseDate) {
       return dvdLibrary.values()
                .stream()
                .filter(dvd -> dvd.getReleaseDate().equalsIgnoreCase(releaseDate))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Dvd>> getDvdsOlderThanGroupByReleaseDate(String releaseDate){
      /*      Long releaseDates;
            String theReleaseDate;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("DD-mm-yyyy");
            LocalDate formatted = LocalDate.parse(releaseDate, formatter);
            theReleaseDate = formatter.format(formatted);
            releaseDates = Long.parseLong(theReleaseDate);
       */     
        return dvdLibrary.values()
                .stream()
                .filter(dvd -> dvd.getReleaseDate().equalsIgnoreCase(releaseDate))
                .collect(Collectors.groupingBy(Dvd::getReleaseDate));  
    }

    @Override
    public List<Dvd> getAverageDvdAge(String releaseDate) {
      return dvdLibrary.values()
                .stream()
                .filter(s -> s.getReleaseDate().equalsIgnoreCase(releaseDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<Dvd> getDvdsByMpaaRating(String mpaaRating) throws DvdLibraryPersistenceException {
      
       return dvdLibrary.values()
                .stream()
                .filter(s -> s.getMpaaRating().equalsIgnoreCase(mpaaRating))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Dvd>> getAllDvdsGroupByMpaaRating(String mpaaRating) throws DvdLibraryPersistenceException {
        return dvdLibrary.values()
                .stream()
                .collect(Collectors.groupingBy(Dvd::getMpaaRating));
    }
    
    @Override
    public Map<String, List<Dvd>> getAllDvdsGroupByDirectorsName(String directorsName) throws DvdLibraryPersistenceException {
        return dvdLibrary.values()
                .stream()
                .collect(Collectors.groupingBy(Dvd::getDirectorsName));
    }

    @Override
    public List<Dvd> getDvdsByDirectorsName(String directorsName) throws 
            DvdLibraryPersistenceException {
        
       return dvdLibrary.values()
                .stream()
                .filter(s -> s.getDirectorsName().equalsIgnoreCase(directorsName))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Dvd>> getAllDvdsGroupByUserRating(String userRating) throws DvdLibraryPersistenceException {
        return dvdLibrary.values()
                .stream()
                .collect(Collectors.groupingBy(Dvd::getUserRating));
    }

    @Override
    public List<Dvd> getDvdsByUserRating(String userRating) throws 
            DvdLibraryPersistenceException {
        
       return dvdLibrary.values()
                .stream()
                .filter(s -> s.getDirectorsName().equalsIgnoreCase(userRating))
                .collect(Collectors.toList());
    }
    
    @Override
    public Map<String, List<Dvd>> getDvdsYoungerThanGroupByReleaseDate(String releaseDate) throws DvdLibraryPersistenceException {
       return dvdLibrary.values()
                .stream()
                .collect(Collectors.groupingBy(Dvd::getUserRating));
    }

    
    public double getAverageDvdAge() {
        return dvdLibrary.values()
                .stream()
                .mapToLong(Dvd::getDvdAge)
                .average()
                .getAsDouble();
    }

    public void loadRoster() throws DvdLibraryPersistenceException {
        Scanner scanner;
        Dvd currentDvd;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryPersistenceException("-_- Could not load Dvd data.", e);
        }
        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            currentDvd = new Dvd();
            currentDvd.setDvdTitle(currentTokens[0]);
            currentDvd.setReleaseDate(currentTokens[1]);
            currentDvd.setMpaaRating(currentTokens[2]);
            currentDvd.setDirectorsName(currentTokens[3]);
            currentDvd.setStudioName(currentTokens[4]);
            currentDvd.setUserRating(currentTokens[5]);

            dvdLibrary.put(currentDvd.getDvdTitle(), currentDvd);
        }
        scanner.close();
    }

    public void writeLibrary() throws DvdLibraryPersistenceException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DvdLibraryPersistenceException(
                    "Could not save DVD data.", e);
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
