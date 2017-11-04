/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.advice;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import org.aspectj.lang.JoinPoint;


public class LoggingAdvice {
    
    VendingMachineAuditDao auditDao;
 
    public LoggingAdvice(VendingMachineAuditDao auditDao) {
        this.auditDao = auditDao;
    }
 
    public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        auditDao.writeAuditEntry(auditEntry);
    }
}
