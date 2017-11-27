
package com.sg.flooringmastery.app;

import static com.sg.flooringmastery.advice.LoggingAdvice.selectMode;
import com.sg.flooringmastery.controller.FlooringController;
import com.sg.flooringmastery.dao.FlooringPersistenceException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    public static void main(String[] args) throws FlooringPersistenceException {

        ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext.xml");
        FlooringController controller = ctx.getBean("controller", FlooringController.class);
        
        String mode = selectMode();
        if(mode.equalsIgnoreCase("training")){
            controller = ctx.getBean("trainingController", FlooringController.class);
        } else { 
            controller = ctx.getBean("prodController", FlooringController.class);
        }
        controller.run();
    }
}
