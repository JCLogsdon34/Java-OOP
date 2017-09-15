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
//use the double MATH.PI

        int i = 0;
        int piArray[] = {3,1,4,1,5,9,2,6,5,3,5};
       // int piForDisplay[] = new int [piArray.length - n];
       
        int num1 = piArray[n];
            num1 =  piArray[i];
        
        for(i = 0; i <= piArray.length - n; i++){
          System.out.println(piArray[i - n]);
        
        
        //piForDisplay[piArray.length - 1] = n;
        }
        return piArray;
    }
    
}
