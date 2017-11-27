
package com.sg.flooringmastery.advice;

import com.sg.flooringmastery.dao.FlooringAuditDao;
import com.sg.flooringmastery.dao.FlooringNoOrdersForThatDateException;
import com.sg.flooringmastery.dao.FlooringPersistenceException;
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
        String auditEntry = jp.getSignature().getName()+" : "+exception;
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        auditDao.writeAuditEntry(auditEntry);
    }

    public void afterLog(JoinPoint jp, FlooringPersistenceException exception1){
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName()+" : "+exception1;
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
}