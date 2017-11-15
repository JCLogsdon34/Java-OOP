
package com.sg.flooringmastery.ui;

import com.sg.flooringmastery.dto.Order;


public class FlooringView {
    
    private UserIo io;

    public FlooringView(UserIo io) {
        this.io = io;
    }
    
    public int printMenuAndGetSelection() {
        io.print("<<Flooring Main Menu>>");
        io.print("1. Display Orders");
        io.print("2. Add An Order");
        io.print("3. Edit An Order");
        io.print("4. Remove An Order");
        io.print("5. Save Current Work");
        io.print("6. Quit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
    
    public void displayOrder(Order currentOrder) {
        if (currentOrder != null) {
            io.print(currentOrder.getOrderNumber().toString());
            io.print(currentOrder.getCustomerName());
            io.print(currentOrder.getProduct().toString());
            io.print(currentOrder.getTax().toString());
            io.print(currentOrder.getArea().toString());
            io.print(currentOrder.getMaterialCost().toString());
            io.print(currentOrder.getLaborCost().toString());
            io.print(currentOrder.getTotal().toString());
            io.print("");
        } else {
            io.print("No such order.");
        }
        io.readString("Please hit enter to continue.");
    }
}
