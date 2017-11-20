
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Product;
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


public class FlooringProductDaoImpl implements FlooringProductDao {

    @Override
    public List<Product> getAllProducts() throws FlooringPersistenceException {
       loadProduct();     
        return new ArrayList<>();
    }

    @Override
    public Product getProductByType(String productType) throws FlooringPersistenceException {       
        Product product = new Product();
        loadProduct();
        product = productData.get(productType);
        return product;
    }

    @Override
    public BigDecimal getProductCostPerSqFt(String productType) throws FlooringPersistenceException {
        BigDecimal cost = ZERO;
        loadProduct(); 
        cost = cost.add(productData.get(productType).getProductCostPerSqFt());
        return cost;
    }

    @Override
    public BigDecimal getLaborCostPerSqFt(String productType) throws FlooringPersistenceException {
        BigDecimal labor = ZERO;
        loadProduct();        
        labor = labor.add(productData.get(productType).getLaborCostPerSqFt());
        return labor;
    }
    
    
    public Map<String, Product> productData = new HashMap<>();
    public String PRODUCTSDATA_FILE = "DataProducts.txt";
    public static final String DELIMITER = ",";
    
    @Override
     public void loadProduct() throws FlooringPersistenceException {
        Scanner scanner;
        Product currentProduct;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(PRODUCTSDATA_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException("-_- Could not load product data.", e);
        }
        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            currentProduct = new Product();
            currentProduct.setProductType(currentTokens[0]);
            currentProduct.setProductCostPerSqFt(new BigDecimal(currentTokens[1]));
            currentProduct.setLaborCostPerSqFt(new BigDecimal(currentTokens[2]));
            
            productData.put(currentProduct.getProductType(), currentProduct);
        }
        scanner.close();
    }

    @Override
    public void writeProduct() throws FlooringPersistenceException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(PRODUCTSDATA_FILE));
        } catch (IOException e) {
            throw new FlooringPersistenceException(
                    "Could not save product data.", e);
        }
        List<Product> productList = this.getAllProducts();
        productList.stream().map((currentProduct) -> {
            out.println(currentProduct.getProductType() + DELIMITER
                    + currentProduct.getProductCostPerSqFt() + DELIMITER
                    + currentProduct.getLaborCostPerSqFt());      
            return currentProduct;
        }).forEach((_product) -> {
            out.flush();
        });
        
        out.close();
    }
}
