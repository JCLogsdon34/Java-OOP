
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;
import com.sg.dvdlibrary.service.DvdLibraryDataValidationException;
import com.sg.dvdlibrary.service.DvdLibraryServiceLayer;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DvdLibraryDaoTest {
    
    private DvdLibraryDao dao =  new DvdLibraryDaoFileImpl();
    
    public DvdLibraryDaoTest() {
        ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("applicationContext.xml");
    dao = 
        ctx.getBean("dao", DvdLibraryDaoFileImpl.class);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws DvdLibraryPersistenceException {
        List<Dvd>dvdList = dao.getAllDvds();
        for(Dvd dvd : dvdList) {
            dao.removeDvd(dvd.getDvdTitle());
        }
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testGetDvd() throws DvdLibraryDataValidationException, 
            DvdLibraryPersistenceException {
        
        Dvd dvd = new Dvd();
        dvd.setDvdTitle("Joe");
        dvd.setDirectorsName("Smith");
        dvd.setReleaseDate("04-17-1990");
        dvd.setStudioName("Applewood");
        dvd.setUserRating("A");
        
        dao.addDvd(dvd.getDvdTitle(), dvd);
        
        Dvd fromDao = dao.getDvd(dvd.getDvdTitle());
        
        assertEquals(fromDao, dao.getDvd(dvd.getDvdTitle())); 
    }

    
    @Test
    public void testGetAllDvds() throws 
            DvdLibraryDataValidationException, 
            DvdLibraryPersistenceException {
        
        Dvd dvd1 = new Dvd();
        dvd1.setDvdTitle("Joe");
        dvd1.setDirectorsName("Smith");
        dvd1.setReleaseDate("04-17-1990");
        dvd1.setStudioName("Applewood");
        dvd1.setUserRating("A");
        
        dao.addDvd(dvd1.getDvdTitle(), dvd1);
        
        Dvd dvd2 = new Dvd();
        dvd2.setDvdTitle("Bill");
        dvd2.setDirectorsName("Yates");
        dvd2.setReleaseDate("04-17-1990");
        dvd2.setStudioName("Baton Rouge");
        dvd2.setUserRating("B+");
        
        dao.addDvd(dvd2.getDvdTitle(), dvd2);
        
        dao.removeDvd(dvd1.getDvdTitle());
        assertEquals(1, dao.getAllDvds().size());
        assertNull(dao.getDvd(dvd1.getDvdTitle()));
        
        dao.removeDvd(dvd2.getDvdTitle());
        assertEquals(0, dao.getAllDvds().size());
        assertNull(dao.getDvd(dvd2.getDvdTitle()));
    }

    @Test
    public void testRemoveDvd() throws 
            DvdLibraryDataValidationException, DvdLibraryPersistenceException{
        String dvdTitle = "Bill";
        Dvd dvd1 = new Dvd();
        dvd1.setDvdTitle("Johann S. Bach: Old School OG");
        dvd1.setDirectorsName("Dr Dre");
        dvd1.setReleaseDate("04-17-1990");
        dvd1.setStudioName("umm, Germany?");
        dvd1.setUserRating("A");
        

        dao.addDvd(dvd1.getDvdTitle(), dvd1);
        dao.removeDvd(dvd1.getDvdTitle());
        
        assertNull(dvdTitle, dao.removeDvd(dvd1.getDvdTitle()));


    }
}
