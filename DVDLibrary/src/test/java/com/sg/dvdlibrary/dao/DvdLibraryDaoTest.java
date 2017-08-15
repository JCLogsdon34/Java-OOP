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
    public void testAddDvd() throws Exception {
        
    }

    /**
     * Test of getAllDvds method, of class DvdLibraryDao.
     */
    @Test
    public void testGetAllDvds() throws Exception {
        
    }

    /**
     * Test of getDvd method, of class DvdLibraryDao.
     */
    @Test
    public void testGetDvd() throws Exception {
       
    }

    /**
     * Test of removeDvd method, of class DvdLibraryDao.
     */
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
