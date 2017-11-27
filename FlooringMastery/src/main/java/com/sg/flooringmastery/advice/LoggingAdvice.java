package com.sg.flooringmastery.advice;

import com.sg.flooringmastery.dao.FlooringAuditDao;
import com.sg.flooringmastery.dao.FlooringNoOrdersForThatDateException;
import com.sg.flooringmastery.dao.FlooringPersistenceException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import org.aspectj.lang.JoinPoint;

public class LoggingAdvice {

    FlooringAuditDao auditDao;

    public LoggingAdvice(FlooringAuditDao auditDao) {
        this.auditDao = auditDao;
    }

    public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + " : ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (FlooringPersistenceException e) {
            System.err.println(
                    "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }

    public void afterLogging(JoinPoint jp, FlooringNoOrdersForThatDateException exception) throws FlooringPersistenceException {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + " : " + exception;
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        auditDao.writeAuditEntry(auditEntry);
    }

    public void afterLog(JoinPoint jp, FlooringPersistenceException exception1) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + " : " + exception1;
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (FlooringPersistenceException ex) {
            System.err.println(
                    "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }

    public static String selectMode() throws FlooringPersistenceException {
        Scanner scanner;
        String mode = null;
        String currentLine = null;
        String MODES_FILE = "Modes.txt";
        String[] currentTokens = new String[]{};
        try {
             scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(MODES_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException("-_- Could not load order data.", e);
        }
        
        while (scanner.hasNextLine()) {
        currentLine = scanner.nextLine();
        mode = (currentTokens[0]);
        }
        scanner.close(); 
        return mode;
    }
}
