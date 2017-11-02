
package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterAuditDao;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterDaoException;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
import java.util.List;


public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer {

    ClassRosterDao dao;
    ClassRosterAuditDao auditDao;

    public ClassRosterServiceLayerImpl(ClassRosterDao dao, ClassRosterAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
        public void createStudent(Student student) throws
            ClassRosterDuplicateIdException,
            ClassRosterDataValidationException,
            ClassRosterPersistenceException,
            ClassRosterDaoException {

        if (dao.getStudent(student.getFirstName()) != null) {
            throw new ClassRosterDuplicateIdException(
                    "ERROR: Could not create Dvd.  Dvd title"
                    + student.getFirstName()
                    + " already exists");
        }
        validateStudentData(student);
        dao.addStudent(student.getFirstName(), student);
        
     /*   auditDao.writeAuditEntry(
            "Student " + student.getFirstName() + " CREATED.");
            */
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException, ClassRosterDaoException {
        return dao.getAllStudents();
    }

    @Override
    public Student getStudent(String firstName) throws ClassRosterPersistenceException, ClassRosterDaoException {
        return dao.getStudent(firstName);
    }

    @Override
    public Student removeStudent(String firstName) throws ClassRosterPersistenceException, ClassRosterDaoException {
        Student removeStudent = dao.removeStudent(firstName);

    //auditDao.writeAuditEntry("Student " + firstName + " REMOVED.");
        return dao.removeStudent(firstName);
    }

    private void validateStudentData(Student student) throws
            ClassRosterDataValidationException {

        if (student.getFirstName() == null
                || student.getFirstName().trim().length() == 0
                || student.getLastName() == null
                || student.getLastName().trim().length() == 0
                || student.getStudentId() == null
                || student.getStudentId().trim().length() == 0
                || student.getCohort() == null
                || student.getCohort().trim().length() == 0) {

            throw new ClassRosterDataValidationException(
                    "ERROR: All fields [Dvd Title, Directors Name, Mpaa Rating"
                    + " Studio Name, user Rating, and Dvd] are required.");
        }
    }
}
