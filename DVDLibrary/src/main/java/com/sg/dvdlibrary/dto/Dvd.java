package com.sg.dvdlibrary.dto;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.stream.LongStream;

public class Dvd {

    public String dvdTitle;
    public String releaseDate;
    public LocalDate releaseDates;
    public String directorsName;
    public String mpaaRating;
    public String studioName;
    public String userRating;

    @Override
    public String toString() {
        return "Title: " + dvdTitle + " |Release Date: " + releaseDate + 
              " |Director: " + directorsName + "|MPAA rating" + mpaaRating + "|Studio Name" 
                + studioName + "|Rating by User" + userRating + " ";
    }

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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public LocalDate getReleaseDates() {
        return releaseDates;
    }

    public void setReleaseDates(LocalDate releaseDates) {
        this.releaseDates = releaseDates;
    }

    public long getDvdAge() {
        Period p = releaseDates.until(LocalDate.now());
        return p.getYears();
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.dvdTitle);
        hash = 61 * hash + Objects.hashCode(this.releaseDate);
        hash = 61 * hash + Objects.hashCode(this.directorsName);
        hash = 61 * hash + Objects.hashCode(this.mpaaRating);
        hash = 61 * hash + Objects.hashCode(this.studioName);
        hash = 61 * hash + Objects.hashCode(this.userRating);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dvd other = (Dvd) obj;
        if (!Objects.equals(this.dvdTitle, other.dvdTitle)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.directorsName, other.directorsName)) {
            return false;
        }
        if (!Objects.equals(this.mpaaRating, other.mpaaRating)) {
            return false;
        }
        if (!Objects.equals(this.studioName, other.studioName)) {
            return false;
        } else if (!Objects.equals(this.userRating, other.userRating)) {
            return false;
        }
        return true;
    }
}
