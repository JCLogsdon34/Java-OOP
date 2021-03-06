/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterDaoException;
import com.sg.classroster.dao.ClassRosterDaoStubImpl;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class ClassRosterServiceLayerTest {
    
    ClassRosterServiceLayer service;
    
    public ClassRosterServiceLayerTest() {
   /*   ClassRosterDao dao = new ClassRosterDaoStubImpl();
        ClassRosterAuditDao auditDao = new ClassRosterAuditDaoStubImpl();
 
        service = new ClassRosterServiceLayerImpl(dao, auditDao);
   */
   ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("applicationContext.xml");
    service = 
        ctx.getBean("serviceLayer", ClassRosterServiceLayer.class);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testCreateStudent() throws ClassRosterDuplicateIdException, ClassRosterDataValidationException, ClassRosterPersistenceException, ClassRosterDaoException {
        Student student = new Student("0002");
        student.setFirstName("Sally");
        student.setLastName("Yates");
        student.setCohort("2000 C++");
        service.createStudent(student);
    }

    @Test
    public void testCreateStudentDuplicateId()throws ClassRosterDataValidationException, ClassRosterPersistenceException, ClassRosterDaoException {
        Student student = new Student("0002");
        student.setFirstName("Sally");
        student.setLastName("Yates");
        student.setCohort("2000 C++");
        
        try{
            service.createStudent(student);
            fail("Expected ClassRosterDuplicateIdException was not thrown");
        }catch(ClassRosterDuplicateIdException e) {
            return;
        }
    }
    
    @Test
    public void testCreateStudentInvalidData() throws ClassRosterPersistenceException, ClassRosterDaoException, ClassRosterDuplicateIdException{
        Student student = new Student("0002");
        student.setFirstName("");
        student.setLastName("Yates");
        student.setCohort("2000 C++");
        
        try{
            service.createStudent(student);
            fail("Expected ClassRosterDataValidationException was not thrown");
        }catch(ClassRosterDataValidationException e) {
            return;
        }
    }
    
    @Test
    public void testGetAllStudents()  throws ClassRosterPersistenceException, ClassRosterDaoException {
        assertEquals(1, service.getAllStudents().size());
    }


    @Test
    public void testGetStudent()  throws ClassRosterPersistenceException, ClassRosterDaoException {
        Student student = new Student("0001");
        assertNotNull(student);
        student = service.getStudent("9999");
        assertNull(student);
        
    }

    @Test
    public void testRemoveStudent()  throws ClassRosterPersistenceException, ClassRosterDaoException{
        Student student = service.removeStudent("0001");
        assertNotNull(student);
        student = service.removeStudent("9999");
        assertNull(student);
    }
    
}
