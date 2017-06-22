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
public class Rectangle extends Shapes {

    @Override
    protected String getPerimeter() {
        super.getPerimeter();
        perimeter = " 2(w + l)";
        return perimeter;
    }

    @Override
    protected String getArea() {
        super.getArea();
        area = "w * l";
        return area;

    }
}
