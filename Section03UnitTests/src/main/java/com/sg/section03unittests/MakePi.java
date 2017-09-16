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
        int i = 0;
        int num1[] = new int [i];
        int num2[] =  new int [n];
 //       int num2[] = new int[n];
        //num1[i] = num1[i] - num2[n];
        int x = n - piArray.length;
        num1[i] = piArray.length + x;
        
// n was piForDisplay[n]; and i was i = n - piArray.length;
        for(i = 0; i >= n; i++){
           // num1[i] = num1[i] - num2[n];
          num2[n] = num1[i];
          //piForDisplay[n] = piArray[i];
        //  piForDisplay[n] = piArray.length + x;
           while(num2[n] < piArray[i]){
          piForDisplay[n++] = piArray[i];
          //  piForDisplay[n] = piArray[i] + x;
           }

         // System.out.println(piForDisplay[piArray[i]]);      
        //piForDisplay[piArray.length - 1] = n;
        }
        return piForDisplay;
    }    
}
