
package com.sg.dvdlibrary.dto;


public class Dvd {
    public String dvdTitle;
    public String releaseDate;
    public String directorsName;
    public String mpaaRating; 

    public String StudioName;
    public String getStudioName;
    public String userRating;
    public String getUserRating;


    
    public void setDvdTitle(String dvdTitle){
        this.dvdTitle = dvdTitle;
    }
    public String getDvdTitle() {
        return dvdTitle;
    }
    public void setDirectorsName(String directorsName){
        this.directorsName = directorsName;
    }
    public String getDirectorsName(){
        return directorsName;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public String getMpaaRating() {
        return mpaaRating;
    }
    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }   
    public String getStudioName() {
        return StudioName;
    }
    public void setStudioName(String studioName) {
        this.StudioName = studioName;
    }    
    public String getUserRating() {
        return userRating;
    }
    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }  
}
