/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class DvdLibraryDaoTest {
    
    private DvdLibraryDao dao =  new DvdLibraryDaoFileImpl();
    
    public DvdLibraryDaoTest() {
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

    /**
     * Test of addDvd method, of class DvdLibraryDao.
     */
    @Test
    public void testGetDvd() throws Exception {
        Dvd dvd = new Dvd();
        dvd.setDvdTitle("Joe");
        dvd.setDirectorsName("Smith");
        dvd.setReleaseDate("2017");
        dvd.setStudioName("Applewood");
        dvd.setUserRating("A");
        
        dao.addDvd(dvd.getDvdTitle(), dvd);
        
        Dvd fromDao = dao.getDvd(dvd.getDvdTitle());
        
        assertEquals(dvd, fromDao); 
    }

    /**
     * Test of getAllDvds method, of class DvdLibraryDao.
     */
    @Test
    public void testGetAllDvds() throws Exception {
        Dvd dvd1 = new Dvd();
        dvd1.setDvdTitle("Joe");
        dvd1.setDirectorsName("Smith");
        dvd1.setReleaseDate("2017");
        dvd1.setStudioName("Applewood");
        dvd1.setUserRating("A");
        
        dao.addDvd(dvd1.getDvdTitle(), dvd1);
        
        Dvd dvd2 = new Dvd();
        dvd2.setDvdTitle("Jill");
        dvd2.setDirectorsName("Stein");
        dvd2.setReleaseDate("2016");
        dvd2.setStudioName("San Francisco");
        dvd2.setUserRating("B+");
        
        dao.addDvd(dvd2.getDvdTitle(), dvd2);
        
        dao.removeDvd(dvd1.getDvdTitle());
        assertEquals(1, dao.getAllDvds().size());
        assertNull(dao.getDvd(dvd1.getDvdTitle()));
        
        dao.removeDvd(dvd2.getDvdTitle());
        assertEquals(2, dao.getAllDvds().size());
        assertNull(dao.getDvd(dvd2.getDvdTitle()));
    }

    @Test
    public void testRemoveDvd() throws Exception {
        
    }

    public class DvdLibraryDaoImpl implements DvdLibraryDao {

        public Dvd addDvd(String dvdTitle, Dvd dvd) throws DvdLibraryPersistenceException {
            return null;
        }

        public List<Dvd> getAllDvds() throws DvdLibraryPersistenceException {
            return null;
        }

        public Dvd getDvd(String dvdTitle) throws DvdLibraryPersistenceException {
            return null;
        }

        public Dvd removeDvd(String dvdTitle) throws DvdLibraryPersistenceException {
            return null;
        }
    } 
    
}
