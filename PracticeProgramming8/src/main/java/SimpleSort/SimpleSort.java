/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleSort;

public class SimpleSort {

    public static void main(String[] args) {

        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 55, 67, 88, 99};

        int[] secondHalf = {1, 4, 8, 11, 15, 18, 21, 44, 54, 79, 89, 100};

        int[] wholeNumbers = new int[24];

        for (int i = 1; i < wholeNumbers.length; i++) {
            for (int j = 0; j < wholeNumbers.length - 1; j++) {

                if (wholeNumbers[j] > wholeNumbers[j + 1]) {
                    int num = wholeNumbers[j];
                    wholeNumbers[j] = wholeNumbers[j + 1];
                    wholeNumbers[j + 1] = num;

                }

            }
        }

    }
}
// Sorting code should go here!

