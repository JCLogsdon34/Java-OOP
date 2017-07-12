/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dto;

/**
 *
 * @author apprentice
 */
public class DVD {
    
    
    private final String dvdTitle;
    private String releaseDate;
    private String mpaaRating; // Java or .Net + cohort month/year

    private String userRating;
    public String getStudioName;
    private String StudioName;

    
    public DVD(String dvdTitle) {
        this.dvdTitle = dvdTitle;
    }
    
    public String getDvdTitle() {
        return dvdTitle;
    }
    
    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
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
    
    public String getDVDTitle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDirectorsName(String currentToken) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDirectorsName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDVDTitle(String currentToken) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
