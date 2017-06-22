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
public class Triangle extends Shapes {

    @Override
    protected String getPerimeter() {
        super.getPerimeter();
        perimeter = "a + b + c";
        return perimeter;
    }

    @Override
    protected String getArea() {
        super.getArea();
        area = "(b * h)/ 2";
        return area;

    }
}
