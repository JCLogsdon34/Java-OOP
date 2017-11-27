
package com.sg.flooringmastery.app;

import com.sg.flooringmastery.controller.FlooringController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    public static void main(String[] args) {

        ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext.xml");
        FlooringController controller = ctx.getBean("controller", FlooringController.class);
        
        String mode = controller.selectMode();
        if(mode.equalsIgnoreCase("training")){
            controller = ctx.getBean("trainingController", FlooringController.class);
        } else { 
            controller = ctx.getBean("prodController", FlooringController.class);
        }
        controller.run();
    }
}
