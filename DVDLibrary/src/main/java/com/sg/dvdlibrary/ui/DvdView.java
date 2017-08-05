package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.Dvd;
import java.util.InputMismatchException;
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
        
        String dvdTitle;
        dvdTitle = io.readString("Please enter DVD title"); 
        if(dvdTitle != null && !dvdTitle.isEmpty()){
        currentDvd.setDvdTitle(dvdTitle);
        }
        int numberYear;
        try{
        String releaseDate = io.readString("Please enter an Integer for the year the DVD was released");
        numberYear = Integer.parseInt(releaseDate);
        
        if (numberYear != 0){
            currentDvd.setReleaseDate(releaseDate);
        }
        }catch(InputMismatchException e){
            io.print("Not an Integer, please enter an integer");
        }
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
        Dvd viewDvd = new Dvd();

        if(dvd != null){
            io.print(dvd.getDvdTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getDirectorsName());
            io.print(dvd.getStudioName());
            io.print(dvd.getUserRating());
            io.print(" ");
        }else{
            io.print("No such dvd.");
        }
        io.print("Please hit enter to continue.");
    }

    public Dvd getDvdForUserEdit(String dvdTitle, Dvd currentDvd) {
        boolean keepOnKeepingOn = true;
        int userSelection;
        String releaseDate;
        String mpaaRating;
        String directorsName;
        String userRating;


        while(keepOnKeepingOn) {
            userSelection = io.readInt("Please select a number from the following editing options: "
                    + "(1)Release Date "
                    + "(2)MPAA Rating "
                    + "(3)Director's Name"
                    + "(4)User Notes"
                    + "(5)Leave Menu");
            switch (userSelection) {
                case 1:
                    releaseDate = io.readString("Please enter your desired changes for the Release Date");
                    currentDvd.setReleaseDate(releaseDate);
                    io.print("Your change to the Release Date has been noted");
                    break;
                case 2:
                    mpaaRating = io.readString("Please enter your desired changes for the MPAA Rating");
                    currentDvd.setMpaaRating(mpaaRating);
                    io.print("Your change to the MPAA Rating has been noted");
                    break;
                case 3:
                    directorsName = io.readString("Please enter your desired changes for the Director's Name");
                    currentDvd.setDirectorsName(directorsName);
                    io.print("Your change to the Director's Name has been noted");
                    break;
                case 4:
                    userRating = io.readString("Please enter your desired changes for User Notes");
                    currentDvd.setUserRating(userRating);
                    io.print("Your change to the User Notes have been noted");
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
