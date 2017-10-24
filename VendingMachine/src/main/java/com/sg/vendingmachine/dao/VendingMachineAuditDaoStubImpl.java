
package com.sg.vendingmachine.dao;

import static com.sg.vendingmachine.dao.VendingMachineAuditDaoImpl.AUDIT_FILE;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VendingMachineAuditDaoStubImpl  implements VendingMachineAuditDao {
    
    @Override
    public void writeAuditEntry(String entry){
       PrintWriter out = null;
        
        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            Logger.getLogger("Could not load Or save data as requested");
        }

        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
    }
    
}
