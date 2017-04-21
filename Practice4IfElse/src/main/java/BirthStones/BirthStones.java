/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BirthStones;

import java.util.Scanner;

public class BirthStones {
    public static void main(String[] args){
        int userMonth;
        String monthJewel = "";
        
    Scanner inputReader = new Scanner(System.in);
    
        System.out.println("What is the number of the month you were born?");
        userMonth = inputReader.nextInt();
        
        switch (userMonth) {
            case 1:
                monthJewel = "January - Garnet";
                break;
            case 2:
                monthJewel = "February - Amethyst";
                break;
            case 3:
                monthJewel = "March - Aquamarine";    
                break;
            case 4:
                monthJewel = "April - Diamond";
                break;
            case 5:
                monthJewel = "May - Emerald";
                break;
            case 6:
                monthJewel = "June - Pearl";
                break;
            case 7:
                monthJewel = "July - Ruby";
                break;
            case 8:
                monthJewel = "August - Peridot";
                break;
            case 9:
                monthJewel = "September - Sapphire";
            case 10:
                monthJewel = "October - Opal";
                break;
            case 11:
                monthJewel = "November - Topaz";
                break;
            case 12:
                monthJewel = "December _ Turquoise";
                break;
            default:
                monthJewel = "Invalid number for month";
        } 
        System.out.println(monthJewel);
    }
}
