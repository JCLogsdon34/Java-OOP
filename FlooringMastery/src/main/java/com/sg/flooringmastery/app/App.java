
package com.sg.flooringmastery.app;

import com.sg.flooringmastery.controller.FlooringController;


public class App {
    public static void main(String[] args) {

        ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext.xml");
        FlooringController controller = 
           ctx.getBean("controller", FlooringController.class);
        controller.run();
    }
}
