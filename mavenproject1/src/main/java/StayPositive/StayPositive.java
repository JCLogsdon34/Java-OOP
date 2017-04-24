/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StayPositive;

import java.util.Scanner;

public class StayPositive {
    public static void main(String[] args){
        int limit = 0;

        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("What number should I count down from?");
        int num = inputReader.nextInt();
        
        
            while(num > limit){
                System.out.println(num);
                num--;
                }       
            System.out.println(num);
            
        }    
        
    }
