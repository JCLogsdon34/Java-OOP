/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringForwardFallBack;


public class SpringForwardFakkBack {
    public static void main(String[] args){
        System.out.println("It's Spring...!");
        for (int i = -10; i < 0; i++) {
            System.out.print(i + ", ");
        }//the loop foes from 1-9, as it is not true at 10
        //I hope my solution to three is correct, feels like I am being tricky
        System.out.println("\nOh no, it's fall...");
        for (int i = 10; i > 0; i--) {
            System.out.print(i + ", ");
        } //the loop foes from 9 down to 1, as it subtracts until not true
    }
}
