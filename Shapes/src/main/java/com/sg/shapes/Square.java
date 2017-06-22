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
public class Square extends Shapes {

    @Override
    protected String getPerimeter() {
        perimeter = "S + S + S + S";
        super.getPerimeter();
        return perimeter;
    }

    @Override
    protected String getArea() {
        area = "area(squared)";
        super.getArea();
        return area;
    }
}
