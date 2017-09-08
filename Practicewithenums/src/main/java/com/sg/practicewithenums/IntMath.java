/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.practicewithenums;



public class IntMath {
    
    
    public enum MathOperator {
        PLUS, MINUS, MULTIPLY, DIVIDE
    }
    
    public int mathityMath(int operand1, int operand2){
        MathOperator operator = null;
        return calculate(operator,  operand1, operand2);
    }
    
    public int calculate(MathOperator operator, int operand1, int operand2) {
   
        
         switch(operator) {
                case PLUS:
                      return operand1 + operand2;
                case MINUS:
                      return operand1 - operand2;
                case MULTIPLY:
                      return operand1 * operand2;
                case DIVIDE:
                      return operand1 / operand2;
                default:
                      throw new UnsupportedOperationException();
         }
   }
}
