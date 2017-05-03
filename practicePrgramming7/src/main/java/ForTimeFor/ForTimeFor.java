/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForTimeFor;

import java.util.Scanner;

public class ForTimeFor {
    public static void main(String[] args){
         int num;
        int times;
        int product;
        int input;
        Scanner inputReader = new Scanner(System.in);
        System.out.println("What times table shall I recite?");
        num =inputReader.nextInt();
        
        for(times = 0; times < 16; times++){
             do{
                 times++;
                 product = (num * times);
           //System.out.println(num + "*" + times + "=" + product);
           System.out.println(times + "*" + num + "is: ");
           input = inputReader.nextInt();
           if(input * times == num){
               System.out.println("Correct!");
           } else{
               System.out.println("Wrong too bad!");
           }
           //System.out.println(num * times);
           break;
        }while(times < 16);
    }
}
}
