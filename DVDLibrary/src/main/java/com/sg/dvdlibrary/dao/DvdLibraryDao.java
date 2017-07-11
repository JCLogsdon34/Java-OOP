/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.ui.DVDView;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface DvdLibraryDao {
    /**
     * Adds the given Student to the roster and associates it with the given
     * student id. If there is already a student associated with the given
     * student id it will return that student object, otherwise it will return
     * null.
     *
     * @param studentId id with which student is to be associated
     * @param student student to be added to the roster
     * @return the Student object previously associated with the given student
     * id if it exists, null otherwise
     * @throws com.sg.classroster.dao.ClassRosterDaoException
     */
    DVD addDvd(String dvdTitle, DVD dvd)
            throws DvdLibraryDaoException;

    /**
     * Returns a String array containing the student ids of all students in the
     * roster.
     *
     * @return String array containing the ids of all the students in the roster
     * @throws com.sg.dvdlibrary.dao.DvdLibraryDaoException
     * @throws com.sg.dvdlibrary.dao.DvdLibraryDaoException
     * @throws com.sg.dvdlibrary.dao.DvdLibraryDaoException
     * @throws com.sg.classroster.dao.ClassRosterDaoException
     */
    List<DVD> getAllDvds()
            throws DvdLibraryDaoException;

    /**
     * Returns the student object associated with the given student id. Returns
     * null if no such student exists
     *
     * @param dvdTitle
     * @param studentId ID of the student to retrieve
     * @return the Student object associated with the given student id, null if
     * no such student exists
     * @throws com.sg.dvdlibrary.dao.DvdLibraryDaoException
     * @throws com.sg.classroster.dao.ClassRosterDaoException
     */
    DVD getDvd(String dvdTitle)
            throws DvdLibraryDaoException;

    /**
     * Removes from the roster the student associated with the given id. Returns
     * the student object that is being removed or null if there is no student
     * associated with the given id
     *
     * @param studentId id of student to be removed
     * @return Student object that was removed or null if no student was
     * associated with the given student id
     * @throws com.sg.dvdlibrary.dao.DvdLibraryDaoException
     * @throws com.sg.classroster.dao.ClassRosterDaoException
     */
    DVD removeDvd(String dvdTitle)
            throws DvdLibraryDaoException;

    public void addDVD(String dvdTitle, DVDView newDVD);
}


