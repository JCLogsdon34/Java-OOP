
package com.sg.vendingmachine.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VendingMachineAuditDaoImpl  implements VendingMachineAuditDao {
    
    public static final String AUDIT_FILE = "audit.txt";
 
    @Override
    public void writeAuditEntry(String entry) {
        PrintWriter out = null;
        
        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            Logger.getLogger(VendingMachineAuditDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry + " : ");
        out.flush();
    }
}
