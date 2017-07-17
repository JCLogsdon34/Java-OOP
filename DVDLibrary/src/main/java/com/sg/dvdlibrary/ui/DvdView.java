
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

        return io.readInt("Please select from the above choices.");
        
    }

    public Dvd getNewDvdInfo() {
        String dvdTitle = io.readString("Please enter DVD title");
        String releaseDate= io.readString("Please enter the DVD release date");
        String mpaaRating = io.readString("Please enter the MPAA rating");
        String directorsName = io.readString("Please enter the director's name");
        String studioName = io.readString("Please enter the production studio's name");
        String userRating = io.readString("Please enter your rating or note about the DVD");
        Dvd currentDvd = new Dvd();
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setDirectorsName(directorsName);
        currentDvd.setStudioName(studioName);
        currentDvd.setUserRating(userRating);
        return currentDvd;
    }

    public void displayCreateDvdBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "DVD successfully created.  Please hit enter to continue");
    }

    public void displayDvdList(List<Dvd> dvdList) {
        for (Dvd currentDvd : dvdList) {
            io.print(currentDvd.getDvdTitle() + ": "
                    + currentDvd.getReleaseDate() + " "
                    + currentDvd.getMpaaRating()
                    + currentDvd.getDirectorsName()
                    + currentDvd.getStudioName()
                    + currentDvd.getUserRating());
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayDvdBanner() {
        io.print("=== Display DVD ===");
    }

    public String getDvdTitleChoice() {
        return io.readString("Please enter the DVD Title.");
    }

    public void displayDvd(Dvd dvd) {
        if (dvd!= null) {
            io.print(dvd.getDvdTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getDirectorsName());
            io.print(dvd.getStudioName());
            io.print(dvd.getUserRating());
            io.print("");
        } else {
            io.print("No such dvd.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDvdBanner() {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("DVD successfully removed. Please hit enter to continue.");
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
