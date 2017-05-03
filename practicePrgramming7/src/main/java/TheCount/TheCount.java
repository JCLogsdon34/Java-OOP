/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheCount;

import java.util.Scanner;

public class TheCount {
    public static void main(String[] args){
        int first;
        int second;
        int third;
        int output =0;
        int times;
        
        Scanner inputReader = new Scanner(System.in);

        //for(output == 0; first <= second; first++){
            
        
     
       
       
        System.out.println("Hey, please give me a number?");
        first = inputReader.nextInt();
        
        System.out.println("Cool! Please give me another number.");
        second = inputReader.nextInt();
        
        System.out.println("Alright, please provide me with a last number.");
        third = inputReader.nextInt();
        
        while(first < second){
           do{
               first++;
            output = first +=third;
            System.out.println(output + " " + output + " " + output);
            break;
            }while (first < third);
        }
       
        
    } 

}