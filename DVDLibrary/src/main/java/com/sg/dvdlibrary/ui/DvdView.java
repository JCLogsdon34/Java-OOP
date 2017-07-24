package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.Dvd;
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
        io.print("5. Exit");
        io.print("Please enter the number of your choice from"
                + " the above listed options.");
        String msg = "Please select from the above choices.";

        return io.readInt(msg);
    }

    public Dvd getNewDvdInfo() {

        Dvd currentDvd = new Dvd();

        String dvdTitle = io.readString("Please enter DVD title");
        currentDvd.setDvdTitle(dvdTitle);
        String releaseDate = io.readString("Please enter the DVD release date");
        currentDvd.setReleaseDate(releaseDate);
        String mpaaRating = io.readString("Please enter the MPAA rating");
        currentDvd.setMpaaRating(mpaaRating);
        String directorsName = io.readString("Please enter the director's name");
        currentDvd.setDirectorsName(directorsName);
        String studioName = io.readString("Please enter the production studio's name");
        currentDvd.setStudioName(studioName);
        String userRating = io.readString("Please enter your rating or note about the DVD");
        currentDvd.setUserRating(userRating);

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

            io.print("Please hit enter to continue.");
        }
    }

    public void displayDisplayDvdBanner() {
        io.print("=== Display DVD ===");
    }

    public String getDvdTitleChoice(String prompt) {

        return io.readString(prompt);
    }

    public void displayDvd(Dvd dvd) {

        if (dvd != null) {
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

        io.readString("Please hit enter to continue.");
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

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
