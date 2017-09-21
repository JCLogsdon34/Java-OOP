/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;



public class MakePi {
    
    /*public enum piMaker{
         PI;
    } */
    
     // Return an int array length n containing the first n digits of pi.
    //
    // makePi(3) -> {3,1 4,1,5,9,2,65,3,5,9}

    public int[] makePi(int n) {

        
        int piArray[] = {3,1,4,1,5,9,2,6,5,3,5};
        int piForDisplay[] = new int [n];     

        int num1 = 0;
   //   int num2;

 //       int num2[] = new int[n];
        //num1[i] = num1[i] - num2[n];
         
// n was piForDisplay[n]; and i was i = n - piArray.length;
        for(int i = 0; i <= n; i++){
            while(i <= n){

                piArray[i] = num1;
           //     num2 = num1 + i;
                piForDisplay[n] += num1;
            }
           // num1[i] = num1[i] - num2[n];
       /*    if(n <= 5){
              num1[i] = piArray.length;  
              int x = n - num1[i];
              num1[i] = num1[i - n];
           } else if(n > 5){
            num1[i] = piArray.length;  
              int x = n - num1[i];
              num1[i] = num1[i - n];
        }  */
        }
        return piForDisplay;
    }    
    /////Comments
}
