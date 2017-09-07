
package com.sg.classroster.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassRosterAuditDaoImpl implements ClassRosterAuditDao {
    
    public static final String AUDIT_FILE = "audit.txt";
   
 
    @Override
    public void writeAuditEntry(String entry) {
        PrintWriter out = null;
        
        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException ex) {
            Logger.getLogger(ClassRosterAuditDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
    }
 
}

    

