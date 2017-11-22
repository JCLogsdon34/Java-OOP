package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Tax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import static java.math.BigDecimal.ZERO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public final class FlooringTaxDaoImpl implements FlooringTaxDao {
    
    public Map<String, Tax> taxData;
    private final String TAXDATA_FILE;  
    private final String DELIMITER = ",";

    public FlooringTaxDaoImpl() {
        TAXDATA_FILE = "Data/Taxes.txt";
        taxData = new HashMap<>();
    }

    @Override
    public void loadTax() throws FlooringPersistenceException {
        Scanner scanner;
        Tax currentTax;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(TAXDATA_FILE)));

            String currentLine;
            String[] currentTokens;
            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                currentTokens = currentLine.split(DELIMITER);
                currentTax = new Tax();
                currentTax.setState(currentTokens[0]);
                currentTax.setTaxRate(new BigDecimal(currentTokens[1]));

                taxData.put(currentTax.getState(), currentTax);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException(
                    "-_- Could not load roster data into memory.", e);
        }
    }

    @Override
    public Collection<Tax> getAllTaxes() throws FlooringPersistenceException {
        loadTax();
        return new ArrayList<>(taxData.values());
    }

    @Override
    public BigDecimal getTax(String state) throws FlooringPersistenceException {
        BigDecimal taxRate = ZERO;
        Tax tax = new Tax();
        loadTax();
        tax = taxData.get(state);
        taxRate = tax.getTaxRate();
        return taxRate;
    }
}
