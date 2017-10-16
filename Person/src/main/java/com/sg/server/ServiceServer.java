
package com.sg.server;

import java.util.List;

private ServerDao dao = new ServerDaoInMemImpl();
Server server = new Server();

public class ServiceServer {
    
    List<Server> dells = dao.getServersByManufacturer("Dell");
     for(Server currentServer : dells) {
    System.out.println(currentServer.getName());
        }

         dells.stream()
        .forEach(s -> System.out.println(s.getName()));
                }
