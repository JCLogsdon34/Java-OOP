package com.sg.dvdlibrary.dto;

public class Dvd {

    public String dvdTitle;
    public String releaseDate;
    public String directorsName;
    public String mpaaRating;
    public String studioName;
    public String userRating;

    public void setDvdTitle(String dvdTitle) {
        this.dvdTitle = dvdTitle;
    }

    public String getDvdTitle() {
        return dvdTitle;
    }

    public void setDirectorsName(String directorsName) {
        this.directorsName = directorsName;
    }

    public String getDirectorsName() {
        return directorsName;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public String getUserRating() {
        return userRating;
    }
}
