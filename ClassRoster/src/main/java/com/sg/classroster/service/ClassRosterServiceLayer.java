/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterDaoException;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
import java.util.List;


public interface ClassRosterServiceLayer {
    void createStudent(Student student) throws
            ClassRosterDuplicateIdException,
            ClassRosterDataValidationException,
            ClassRosterPersistenceException,
            ClassRosterDaoException;
 
    List<Student> getAllStudents() throws
            ClassRosterPersistenceException,
            ClassRosterDaoException;
 
    Student getStudent(String firstName) throws
            ClassRosterPersistenceException,
            ClassRosterDaoException;
 
    Student removeStudent(String firstName) throws
            ClassRosterPersistenceException,
            ClassRosterDaoException;
}
