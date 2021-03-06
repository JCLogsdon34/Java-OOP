package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.Dvd;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class DvdView {

    private UserIO io;

    public DvdView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {

        io.print("Main Menu");
        io.print("1. List DVD Titles");
        io.print("2. Create New Dvd");
        io.print("3. View a DVD");
        io.print("4. Remove a DVD");
        io.print("5. Edit");
        io.print("6. Exit");

        String msg = "Please enter the number of your choice from"
                + " the above listed options.";
        return io.readInt(msg);
    }

    public int getUserListChoice() {
        int userSelection;
        do {
            userSelection = io.readInt("Please select a number from the following editing options: "
                    + "(1)Get List of all movies, grouped by production Studio"
                    + "(2)Get list of movies from a certain production studio"
                    + "(3)Get list of movies older than n years"
                    + "(4)Get list of movies younger than n years"
                    + "(5)Get list of movies made before a certain year, sorted by Mpaa rating "
                    + "(6)Get Average age of movies in your Dvd library"
                    + "(7)Get list of movies by MPAA rating"
                    + "(8)Get all movies, grouped by directors name"
                    + "(9)Get movies by director's name"
                    + "(10)Get all movies, grouped by user rating"
                    + "(11)Get Movies by user rating"
                    + "(12)Get List of movies made after a year, grouped by release date"
                    + "(13)Leave Menu");
            if ((userSelection > 13) || (userSelection < 1)) {
                io.print("Invalid Input, please enter one of the numbered chocies");
            }
        } while ((userSelection >= 14) || (userSelection <= 0));
        return userSelection;
    }

    public Dvd getNewDvdInfo() {
        Dvd currentDvd = new Dvd();
        boolean newInput;
        String theReleaseDate;
        do {
            String dvdTitle;
            dvdTitle = io.readString("Please enter DVD title");
            if (dvdTitle != null && !dvdTitle.isEmpty()) {
                currentDvd.setDvdTitle(dvdTitle);
                newInput = true;
            } else {
                newInput = false;
            }
        } while (newInput == false);
        String numberYear = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        numberYear = io.readString("Please enter a release date MM-dd-yyyy");
        LocalDate date = LocalDate.parse(numberYear, formatter);
        theReleaseDate = date.format(formatter);
        currentDvd.setReleaseDate(theReleaseDate);
        String mpaaRating = io.readString("Please enter the MPAA rating");
        currentDvd.setMpaaRating(mpaaRating);
        String directorsName = io.readString("Please enter the director's name");
        currentDvd.setDirectorsName(directorsName);
        String studioName = io.readString("Please enter the production studio's name");
        currentDvd.setStudioName(studioName);
        String userRating = io.readString("Please enter your rating or note about the DVD");
        currentDvd.setUserRating(userRating);
        io.readString("Please hit enter to continue");
        return currentDvd;
    }

    public void displayCreateDvdBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayCreateSuccessBanner() {
        io.print(
                "DVD successfully created.  Please hit enter to continue");
    }

    public void displayDvdList(List<Dvd> dvdList) {

        dvdList.stream().forEach((currentDvd) -> {
            io.print(currentDvd.getDvdTitle() + ": "
                    + currentDvd.getReleaseDate() + ": "
                    + currentDvd.getMpaaRating() + ": "
                    + currentDvd.getDirectorsName() + ": "
                    + currentDvd.getStudioName() + ": "
                    + currentDvd.getUserRating() + " ");
        });
        io.print("Please hit enter to continue.");
    }

    
    public void displayDvdMap(Map<String, List<Dvd>> lambdaDvdMap) {
        List <Dvd> dvdList;
        lambdaDvdMap.entrySet().stream().forEach((Map.Entry<String, List<Dvd>> e) -> {
            io.print(e.getKey() + " " + e.getValue());
        });
    }

    public void displayDisplayDvdBanner() {
        io.print("=== Display DVD ===");
    }

    public String getDvdTitleChoice() {
        return io.readString("Please enter a dvdTitle");
    }

    public void displayDvd(Dvd dvd) {
        if (dvd != null) {
            Dvd viewDvd = new Dvd();
            io.print(dvd.getDvdTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getDirectorsName());
            io.print(dvd.getStudioName());
            io.print(dvd.getUserRating());
            io.print(" ");
        } else {
            io.print("No such dvd.");
        }
        io.print("Please hit enter to continue.");
    }

    public String getUserListChoiceInput() {
        String choice;
        choice = io.readString("Please enter what you would like a list of");
        return choice;
    }

    public Dvd getDvdForUserEdit(String dvdTitle, Dvd currentDvd) {
        boolean keepOnKeepingOn = true;
        int userSelection;
        String releaseDate;
        String mpaaRating;
        String directorsName;
        String userRating;

        while (keepOnKeepingOn) {
            userSelection = io.readInt("Please select a number from the following editing options: "
                    + "(1)Release Date "
                    + "(2)MPAA Rating "
                    + "(3)Director's Name"
                    + "(4)User Notes"
                    + "(5)Leave Menu");
            switch (userSelection) {
                case 1:
                    LocalDate formatted;
                    String theReleaseDate;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("DD-mm-yyyy");
                    io.readLocalDate("Please enter a release date dd-mm-yyyy");
                    formatted = io.readLocalDate("Please enter your desired changes for the Release Date"
                            + "dd-mm-yyyy");
                    theReleaseDate = formatter.format(formatted);
                    currentDvd.setReleaseDate(theReleaseDate);
                    io.print("Your change to the Release Date has been noted");
                    break;
                case 2:
                    boolean inputTry;
                    do {
                        mpaaRating = io.readString("Please enter your desired changes for the MPAA Rating");
                        if (mpaaRating != null && !mpaaRating.isEmpty()) {
                            currentDvd.setMpaaRating(mpaaRating);
                            io.print("Your change to the MPAA Rating has been noted");
                            inputTry = true;
                        } else {
                            inputTry = false;
                        }
                    } while (inputTry == false);
                    break;
                case 3:
                    boolean inputValidate;
                    do {
                        directorsName = io.readString("Please enter your desired changes for the Director's Name");
                        if (directorsName != null && !directorsName.isEmpty()) {
                            currentDvd.setDirectorsName(directorsName);
                            io.print("Your change to the Director's Name has been noted");
                            inputValidate = true;
                        } else {
                            inputValidate = false;
                        }
                    } while (inputValidate == false);
                    break;
                case 4:
                    boolean inputBool;
                    do {
                        userRating = io.readString("Please enter your desired changes for User Notes");
                        if (userRating != null && !userRating.isEmpty()) {
                            currentDvd.setUserRating(userRating);
                            io.print("Your change to the User Notes have been noted");
                            inputBool = true;
                        } else {
                            inputBool = false;
                        }
                    } while (inputBool == false);
                    break;
                case 5:
                    keepOnKeepingOn = false;
                    break;
                default:
                    io.print("Invalid Input, please enter one of the numbered chocies");
                    break;
            }
        }
        return currentDvd;
    }

    public void displayRemoveDvdBanner() {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveSuccessBanner() {
        io.print("DVD successfully removed. Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayEditDvdBanner() {
        io.print("=== Edit a Dvd ===");
    }

    public void displayEditSuccessBanner() {
        io.print("=== Edit Success ===");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        errorMsg = "Could not save data";
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
