
package com.sg.flooringmastery.app;

import com.sg.flooringmastery.controller.FlooringController;
import com.sg.flooringmastery.dao.FlooringPersistenceException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    public static void main(String[] args) throws FlooringPersistenceException{

        ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext.xml");
        FlooringController controller;// = ctx.getBean("controller", FlooringController.class);; 
      
        Scanner scanner;
        String MODES_FILE = "Modes.txt";
        try {

                        scanner = new Scanner(
                                new BufferedReader(
                                        new FileReader(MODES_FILE)));
                    } catch (FileNotFoundException e) {
                        throw new FlooringPersistenceException("-_- Could not load mode data.", e);
                    }
            String mode = scanner.nextLine();       
        scanner.close();
        
        if(mode.equals("training")){
            controller = ctx.getBean("trainingController", FlooringController.class);
        } else { 
            controller = ctx.getBean("controller", FlooringController.class);
        }
        
        controller.run();
    }
}
