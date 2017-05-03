/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForByFor;


public class ForByFor {
    public static void main(String[] args){
        
         for (int i = 0; i < 3; i++) {
            System.out.print("|");

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    do{
                        System.out.print("*");
                       break;
                    }while(k==0);
                    do{
                    System.out.print("$");
                   break;
                    }while( k==1);
                    do{
                        System.out.print("*");
                        break;
                    }while(k==2);
                }
                System.out.print("|");
            }
            System.out.println("");
        }
    }
}
