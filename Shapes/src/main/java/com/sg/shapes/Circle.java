/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shapes;

/**
 *
 * @author apprentice
 */
public class Circle extends Shapes {

    @Override
    protected String getPerimeter() {
        perimeter = "2 * pie * r";
        super.getPerimeter();
        return perimeter;
    }

    @Override
    protected String getArea() {
        area = "pie * r (squared)";
        super.getArea();
        return area;

    }
}
