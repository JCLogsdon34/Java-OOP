
package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import com.sg.classroster.service.ClassRosterServiceLayer;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ClassRosterDaoTest {
    
    private ClassRosterDao dao = new ClassRosterDaoStubImpl();
    
    public ClassRosterDaoTest() {
        
        ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("applicationContext.xml");
    dao = 
        ctx.getBean("dao", ClassRosterDao.class);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
        List<Student> studentList = dao.getAllStudents();
        for(Student student : studentList){
            dao.removeStudent(student.getStudentId());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addStudent method, of class ClassRosterDao.
     * @throws com.sg.classroster.dao.ClassRosterDaoException
     */
    public void TestGetStudent() throws ClassRosterDaoException {
        Student student = new Student("0001");
        student.setFirstName("Joe");
        student.setLastName("Smith");
        student.setCohort("Java 2000");
        
        dao.addStudent(student.getStudentId(), student);
        
        Student fromDao = dao.getStudent(student.getStudentId());
        
        assertEquals(student, fromDao);
    }
    
    @Test
    public void testAddStudent() throws Exception {
    }

    /**
     * Test of getAllStudents method, of class ClassRosterDao.
     * @throws com.sg.classroster.dao.ClassRosterDaoException
     */
    @Test
    public void testGetAllStudents() throws ClassRosterDaoException {
        Student student1 = new Student("0001");
        student1.setFirstName("Joe");
        student1.setLastName("Smith");
        student1.setCohort("Java 2000");
        
        dao.addStudent(student1.getStudentId(), student1);
        
        Student student2 = new Student("0002");
        student2.setFirstName("Liam");
        student2.setLastName("Gallagher");
        student2.setCohort(".Net 2000");
        
        dao.addStudent(student2.getStudentId(), student2);
        assertEquals(2, dao.getAllStudents().size());
    }

    /**
     * Test of getStudent method, of class ClassRosterDao.
     * @throws com.sg.classroster.dao.ClassRosterDaoException
     */
    @Test
    public void testGetStudent() throws ClassRosterDaoException {
    }

    /**
     * Test of removeStudent method, of class ClassRosterDao.
     * @throws com.sg.classroster.dao.ClassRosterDaoException
     */
    @Test
    public void testRemoveStudent() throws ClassRosterDaoException {
        Student student1 = new Student("0001");
        student1.setFirstName("Joe");
        student1.setLastName("Smith");
        student1.setCohort("Java 2000");
        
        dao.addStudent(student1.getStudentId(), student1);
        
        Student student2 = new Student("0002");
        student2.setFirstName("Liam");
        student2.setLastName("Gallagher");
        student2.setCohort(".Net 2000");
        
        dao.addStudent(student2.getStudentId(), student2);
        
        dao.removeStudent(student1.getStudentId());
        assertEquals(1, dao.getAllStudents().size());
        assertNull(dao.getStudent(student1.getStudentId()));
        
        dao.removeStudent(student2.getStudentId());
        assertEquals(0, dao.getAllStudents().size());
        assertNull(dao.getStudent(student2.getStudentId()));
    }
}
