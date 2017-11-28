
package com.sg.flooringmastery.app;

import com.sg.flooringmastery.controller.FlooringController;
import com.sg.flooringmastery.dao.FlooringPersistenceException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    public static void main(String[] args) throws FlooringPersistenceException {

        ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext.xml");
        FlooringController controller = ctx.getBean("controller", FlooringController.class);; 
/*        
        if(args[0].equalsIgnoreCase("training")){
            controller = ctx.getBean("trainingController", FlooringController.class);
        } else { 
            controller = ctx.getBean("controller", FlooringController.class);
        }
   */     
        controller.run();
    }
}
