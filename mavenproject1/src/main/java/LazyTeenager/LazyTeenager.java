/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LazyTeenager;

import java.util.Random;

public class LazyTeenager {
    public static void main(String[] args){

        int times = 1;
        int clean = 0;
        int pork;
        Random Randomizer = new Random(); 
        Random ops = new Random();
        
         System.out.println("Clean your room!");

do{
    pork = ops.nextInt(50);
        
  do{
      clean = Randomizer.nextInt(100) + 1;
     
        do{
            System.out.println("Clean your room now!");
            times++;    
            break;
        }while (times < 15);
    } while(clean % 2 != 0); 
                              
        if(times == 15){
            System.out.println("You are grounded! And I am taking your XBOX");           
             }
  
       if(clean % 2 == 0){
          System.out.println("Finally! Took you long enough!");
        }

       } while (pork % 2 == 0);  
    }
}
