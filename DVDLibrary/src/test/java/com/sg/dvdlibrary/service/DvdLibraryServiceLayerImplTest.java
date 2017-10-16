
package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dao.DvdLibraryAuditDao;
import com.sg.dvdlibrary.dao.DvdLibraryAuditDaoImpl;
import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.sg.dvdlibrary.dao.DvdLibraryPersistenceException;
import com.sg.dvdlibrary.dto.Dvd;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class DvdLibraryServiceLayerImplTest {
    
    private DvdLibraryDao dao = new DvdLibraryDaoFileImpl();
    private DvdLibraryAuditDao auditDao = new DvdLibraryAuditDaoImpl();
    private DvdLibraryServiceLayer service = new DvdLibraryServiceLayerImpl(dao, auditDao);
    
    public DvdLibraryServiceLayerImplTest() {

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
    public void testCreateDvd() throws Exception {
      Dvd dvd = new Dvd();
        dvd.setDvdTitle("Joe");
        dvd.setDirectorsName("Smith");
        dvd.setReleaseDate("04-17-1990");
        dvd.setStudioName("Applewood");
        dvd.setUserRating("A");
        
        dao.addDvd(dvd.getDvdTitle(), dvd);
        
        Dvd fromDao = service.getDvd(dvd.getDvdTitle());
        
        assertEquals(fromDao, service.getDvd(dvd.getDvdTitle())); 
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
        
        service.removeDvd(dvd1.getDvdTitle());
        assertEquals(1, service.getAllDvds().size());
        assertNull(service.getDvd(dvd1.getDvdTitle()));
        
        service.removeDvd(dvd2.getDvdTitle());
        assertEquals(0, service.getAllDvds().size());
        assertNull(service.getDvd(dvd2.getDvdTitle()));
    }

    
    @Test
    public void testGetDvd() throws DvdLibraryPersistenceException {
        
        Dvd dvd = new Dvd();
        dvd.setDvdTitle("Joe");
        dvd.setDirectorsName("Smith");
        dvd.setReleaseDate("04-17-1990");
        dvd.setStudioName("Applewood");
        dvd.setUserRating("A");
        
        dao.addDvd(dvd.getDvdTitle(), dvd);
        Dvd dvd1 = dao.getDvd("Joe");
        Dvd fromDao = service.getDvd(dvd.getDvdTitle());
        
        assertEquals(dvd1, fromDao); 
        
    }    
}
