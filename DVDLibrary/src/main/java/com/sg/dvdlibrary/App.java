package com.sg.dvdlibrary;

import com.sg.dvdlibrary.controller.DvdLibraryController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args)  {
/*        UserIO myIo = new UserIOConsoleImpl();
        DvdView myView = new DvdView(myIo);
        DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
        DvdLibraryAuditDao myAuditDao = new DvdLibraryAuditDaoImpl();
        DvdLibraryServiceLayer myService = new DvdLibraryServiceLayerImpl(myDao,myAuditDao);
        DvdLibraryController controller = new DvdLibraryController(myService, myView);
        controller.run();
*/
    ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext.xml");
        DvdLibraryController controller = 
           ctx.getBean("controller", DvdLibraryController.class);
        controller.run();
    }
}
