/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KettleOfFish;

/**
 *
 * @author apprentice
 */
public class KettleofFish {

    public static void main(String[] args) {

        for (int fish = 1; fish < 11; fish++) {
            //while(fish < 10){
            while (fish < 11) {
                if (fish < 3) {
                    System.out.println(fish + " fish!");
                }
                if (fish == 3) {
                    do {
                        System.out.println("RED fish!");
                        break;
                    } while (fish == 3);

                    if (fish == 4) {
                        do {
                            System.out.println("BLUE fish!");
                            break;

                        } while (fish > 4);
                        if (fish <= 10) {
                            do {
                                System.out.println(fish + " fish!");
                                break;
                            } while (fish <= 10);

                        }
                    }
                }
                break;
            }
        }
    }
}
