
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Tax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import static java.math.BigDecimal.ZERO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class FlooringTaxDaoImpl implements FlooringTaxDao {
    
    @Override
    public BigDecimal getTaxAmount(BigDecimal totalSineTax, BigDecimal taxRate) throws FlooringPersistenceException {
        BigDecimal taxAmount = ZERO;
        taxAmount = totalSineTax.multiply(taxRate);
        return taxAmount;
    }

    @Override
    public List<Tax> getTaxesByState() throws FlooringPersistenceException {
        loadTax();
        ArrayList<Tax> arrayList = new ArrayList<>();
        
        return arrayList;
    }


    @Override
    public BigDecimal getTax(String state) throws FlooringPersistenceException {
        BigDecimal taxRate = ZERO;
        loadTax();
        taxRate = taxData.get(state);
        return taxRate;
    }
    
    public Map<String, BigDecimal> taxData = new HashMap<>();
    public String TAXDATA_FILE = "DataTaxes.txt";
    public static final String DELIMITER = ",";
    
    @Override
     public void loadTax() throws FlooringPersistenceException {
        Scanner scanner;
        Tax currentTax;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(TAXDATA_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException("-_- Could not load tax data.", e);
        }
        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            currentTax = new Tax();
            currentTax.setState(currentTokens[0]);
            currentTax.setTaxRate(new BigDecimal(currentTokens[1]));

            taxData.put(currentTax.getState(), currentTax.getTaxRate());
        }
        scanner.close();
    }

    @Override
    public void writeTax() throws FlooringPersistenceException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(TAXDATA_FILE));
        } catch (IOException e) {
            throw new FlooringPersistenceException(
                    "Could not save tax data.", e);
        }
        List<Tax> taxList = this.getTaxesByState();
        taxList.stream().map((currentOrder) -> {
            out.println(currentOrder.getState() + DELIMITER
                    + currentOrder.getTaxRate());      
            return currentOrder;
        }).forEach((_tax) -> {
            out.flush();
        });
        out.close();
    }
}