
package com.sg.flooringmastery.ui;

import java.math.BigDecimal;
import java.time.LocalDate;


public interface UserIo {
    void print(String message);
    
    LocalDate readLocalDate(String msg);
    
    BigDecimal readBigDecimal(String msg)throws FlooringInvalidEntryException;

    double readDouble(String prompt);

    double readDouble(String prompt, double min, double max);

    float readFloat(String prompt);

    float readFloat(String prompt, float min, float max);

    int readInt(String prompt)throws FlooringInvalidEntryException;

    int readInt(String prompt, int min, int max)throws FlooringInvalidEntryException;

    long readLong(String prompt);

    long readLong(String prompt, long min, long max);

    String readString(String prompt);
}
