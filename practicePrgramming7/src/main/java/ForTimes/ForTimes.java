/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForTimes;

import java.util.Scanner;

public class ForTimes {
    public static void main(String[] args){
        int num;
        int times;
        int product;
        Scanner inputReader = new Scanner(System.in);
        System.out.println("Give me a number");
        num =inputReader.nextInt();
        
        for(times = 0; times < 16; times++){
             do{
                 product = (num * times);
           System.out.println(num + "*" + times + "=" + product);
           break;
        }while(times < 16);
        }
    }
}
