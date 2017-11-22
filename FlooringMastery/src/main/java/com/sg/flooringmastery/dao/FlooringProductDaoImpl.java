package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Product;
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

public class FlooringProductDaoImpl implements FlooringProductDao {
    
    public Map<String, Product> productData;
    private String PRODUCTSDATA_FILE;
    private static final String DELIMITER = ",";

    public FlooringProductDaoImpl() {
        PRODUCTSDATA_FILE = "Data/Products.txt";
        productData = new HashMap<>();
    }

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
    public Collection<Product> getAllProducts() throws FlooringPersistenceException{
        loadProduct();
        return productData.values();
    }

    @Override
    public Product getProductByType(String productType) throws FlooringPersistenceException {
        Product product = new Product();
        loadProduct();
        product = productData.get(productType);

        return product;
    }

    @Override
    public BigDecimal getProductCostPerSqFt(String productType, Product product) throws FlooringPersistenceException {
        loadProduct();
        return product.getProductCostPerSqFt();
    }

    @Override
    public BigDecimal getLaborCostPerSqFt(String productType, Product product) throws FlooringPersistenceException {
        loadProduct();
        return product.getLaborCostPerSqFt();
    }
}
