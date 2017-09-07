
package com.sg.addressbook;

import com.sg.addressbook.controller.AddressBookController;
import com.sg.addressbook.dao.AddressBookAuditDao;
import com.sg.addressbook.dao.AddressBookAuditDaoImpl;
import com.sg.addressbook.dao.AddressBookDao;
import com.sg.addressbook.dao.AddressBookDaoFileImpl;
import com.sg.addressbook.service.AddressBookServiceLayer;
import com.sg.addressbook.service.AddressBookServiceLayerImpl;
import com.sg.addressbook.ui.AddressBookView;
import com.sg.addressbook.ui.UserIO;
import com.sg.addressbook.ui.UserIOConsoleImpl;


public class App {

   public static void main(String[] args) {

        UserIO myIo = new UserIOConsoleImpl();
        AddressBookView myView = new AddressBookView(myIo);
        AddressBookDao myDao;
        myDao = new AddressBookDaoFileImpl();
        AddressBookAuditDao myAuditDao = new AddressBookAuditDaoImpl();
        AddressBookServiceLayer myService = new AddressBookServiceLayerImpl(myDao);
        AddressBookController controller
                = new AddressBookController(myDao, myView);
        controller.run();
    }

}

