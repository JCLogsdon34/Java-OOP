/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.controller;

import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterDaoException;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
import com.sg.classroster.service.ClassRosterDataValidationException;
import com.sg.classroster.service.ClassRosterDuplicateIdException;
import com.sg.classroster.service.ClassRosterServiceLayer;
import com.sg.classroster.ui.ClassRosterView;
import com.sg.classroster.ui.UserIO;
import com.sg.classroster.ui.UserIOConsoleImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassRosterController {

    ClassRosterView view;
    ClassRosterServiceLayer service;

    public ClassRosterController(ClassRosterDao dao, ClassRosterView view) {
        this.view = view;
    }

    private UserIO io = new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                {
                    try {
                        listStudents();
                    } catch (ClassRosterPersistenceException e) {
                        Logger.getLogger(ClassRosterController.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
                        break;
                    case 2:
                        createStudent();
                        break;
                    case 3:
                {
                    try {
                        viewStudent();
                    } catch (ClassRosterPersistenceException e) {
                        Logger.getLogger(ClassRosterController.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
                        break;
                    case 4:
                {
                    try {
                        removeStudent();
                    } catch (ClassRosterPersistenceException e) {
                        Logger.getLogger(ClassRosterController.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (ClassRosterDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createStudent() throws ClassRosterDaoException {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        try {
            service.createStudent(newStudent);
        } catch (ClassRosterDuplicateIdException | ClassRosterDataValidationException | ClassRosterPersistenceException e) {
            Logger.getLogger(ClassRosterController.class.getName()).log(Level.SEVERE, null, e);
        }
        view.displayCreateSuccessBanner();
    }

    private void listStudents() throws ClassRosterDaoException, ClassRosterPersistenceException {
        view.displayDisplayAllBanner();
        List<Student> studentList = service.getAllStudents();
        view.displayStudentList(studentList);
    }

    private void viewStudent() throws ClassRosterDaoException, ClassRosterPersistenceException {
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = service.getStudent(studentId);
        view.displayStudent(student);
    }

    private void removeStudent() throws ClassRosterDaoException, ClassRosterPersistenceException {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        service.removeStudent(studentId);
        view.displayRemoveSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
