package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.Dvd;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("DD-mm-yyyy");
        io.readLocalDate("Please enter a release date dd-mm-yyyy");
        LocalDate formatted = LocalDate.parse(numberYear, formatter);
        theReleaseDate = formatter.format(formatted);
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

        for (Dvd currentDvd : dvdList) {
            io.print(currentDvd.getDvdTitle() + ": "
                    + currentDvd.getReleaseDate() + ": "
                    + currentDvd.getMpaaRating() + ": "
                    + currentDvd.getDirectorsName() + ": "
                    + currentDvd.getStudioName() + ": "
                    + currentDvd.getUserRating() + " ");
        }
        io.print("Please hit enter to continue.");
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
/*
    add another swtich for input for this
    public String getDvdListOptions() {
        boolean keepOnKeepingOn = true;
        int userSelection;
        String releaseDate;
        String mpaaRating;
        String directorsName;
        String userRating;
        String studioName;

        while (keepOnKeepingOn) {
            userSelection = io.readInt("Please select a number from the following editing options: "
                    + "(1)Get list of movies from the last n amount of years, or"
                    + "older or younger than n years";
                    + "(2)Get list of movies older or younger than n years "
                    + "(3)Find all the movies released by a certain studio "
                    + "(4)Get list of movies by film director, sorted by Mpaa rating "
                    + "(5)Get list of movies by MPAA rating "
                    + "(6)Get list of movies by User Notes"
                    + "(7)Leave Menu");
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
