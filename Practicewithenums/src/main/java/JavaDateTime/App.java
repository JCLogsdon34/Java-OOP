/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaDateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author apprentice
 */
public class App {
    
    public static void main(String[] args){
        
        LocalDate Id = LocalDate.now();
        System.out.println(Id);
        
        Id = LocalDate.parse("2015-01-01");
        System.out.println(Id);
        
        Id = LocalDate.parse("02/07/2010", DateTimeFormatter.ofPattern("MM/dd/yy"));
        System.out.println(Id);
        
        String isoDate = Id.toString();
        System.out.println(isoDate);        
        Id = LocalDate.parse(isoDate);
        System.out.println(Id);
        
        String formatted = Id.format(DateTimeFormatter.ofPattern("MM/dd/yy"));
        System.out.println(formatted);
        
        formatted = Id.format(DateTimeFormatter.ofPattern("MM/dd/yy+=+=+="));
        System.out.println(formatted);
        
        formatted = Id.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        System.out.println(formatted);
        
        LocalDate past = Id.minusDays(6);
        formatted = Id.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        System.out.println(formatted);
        
        past = Id.minusMonths(3);
        formatted = past.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        System.out.println(formatted);
        
        Period diff = Id.until(past);
        System.out.println(diff);
        System.out.println(diff.getMonths());
        diff = past.until(Id);
        System.out.println(diff.getMonths());
        
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        formatted = ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        System.out.println(formatted);
        
        Date legacyDate = new Date();
        System.out.println(legacyDate);
        
        GregorianCalendar legacyCalendar = new GregorianCalendar();
        System.out.println(legacyCalendar);
        
        ZonedDateTime zdt = ZonedDateTime.ofInstant(legacyDate.toInstant(), ZoneId.systemDefault());
        Id = zdt.toLocalDate();
        System.out.println(Id);
        
        zdt = legacyCalendar.toZonedDateTime();
        Id = zdt.toLocalDate();
        System.out.println(Id);
    }
}
