/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FruitBasket;


public class FruitBasket {

    public static void main(String[] args) {
        String[] fruit = {"Orange", "Apple", "Orange", "Apple", "Orange",
            "Apple", "Orange", "Apple", "Orange", "Orange", "Orange",
            "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple",
            "Apple", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple",
            "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple",
            "Orange", "Orange", "Orange", "Orange", "Apple", "Apple", "Apple",
            "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple",
            "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple",
            "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange",
            "Orange"};

        // Scanner fruity = new Scanner();
        // i = fruity.nextLine();
        int numberOfApples =0;
        int numberOfOranges =0;
        
        String[] apple = new String[fruit.length];

        String[] orange = new String[fruit.length];
        for (int i = 0; i < fruit.length; i++) {
            //loop through the fruit basket one time and put them in their appropriate arrays.
            if(fruit[i].equals("Orange")){
                orange[i] = "Orange";    
            }else if(fruit[fruit.length].equals("Apples")){
           
                apple[i] = "Apples";
            }
            }
//loop through each array and count number of apples and oranges
        int sum = numberOfApples + numberOfOranges; 
        int apples = numberOfApples;
        int oranges = numberOfOranges;
        
            System.out.println("The Sum of this array is " + sum);
              System.out.println("The number of apples in this array is " 
                      + apples);
                System.out.println("The oranges of this array is " 
                        + oranges);
    }
}


