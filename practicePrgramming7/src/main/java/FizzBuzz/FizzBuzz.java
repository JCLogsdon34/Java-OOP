/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FizzBuzz;

import java.util.Scanner;

public class FizzBuzz {

    public static void main(String[] args) {
        int fizz;

        Scanner inputReader = new Scanner(System.in);

        System.out.println("How much units fizzing and buzzing do you "
                + "need in your life?");
        fizz = inputReader.nextInt();

        for (int numb = 0; numb <= fizz; numb++) {
            do {
                numb++;
                System.out.println(numb);

                while (numb % 3 == 0) {
                    System.out.println("fizz");
                    break;
                }
                while (numb % 5 == 0) {
                    System.out.println("buzz");
                    break;
                }
                while ((numb % 3 == 0) && (numb % 5 == 0)) {
                    System.out.println("fizz buzz");
                    break;
                }
            } while (numb < fizz);
            if (numb == fizz) {
                while (numb == fizz) {
                    System.out.println("TRADITION");
                    break;
                }
            }

        }
    }
}
