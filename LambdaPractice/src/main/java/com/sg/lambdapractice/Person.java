/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lambdapractice;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

/*
For Examples from the notes
 */
public class Person {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Tests to see if you are old enough to vote
 //  public boolean test(Person person) {
   //     return person.getAge() >= 18;
    //} 
    //The Above, but as a Lambda
   /* Predicate<Person> oldEnoughToVote = (Person p) -> {
    return p.getAge() >= 18;
}; */
     // Same as above, but with syntax shortcuts
    Predicate<Person> oldEnoughToVote = p -> p.getAge() >= 18;
    
   /* public void accept(Person person) {
    System.out.println(person.getName() 
        + " is " 
        + person.getAge() 
        + " years old.");
} */
    //this is the above as a Lambda
/*  Consumer<Person> howOld = (Person p) -> {
    System.out.println(p.getName()
            + " is "
            + p.getAge()
            + " years old.");
    //no return, this Lambda specifies a void type
};           */
    //Same as the above, but with Syntactical short cuts
    Consumer<Person> howOld = p -> 
            System.out.println(p.getName() + " is " + p.getAge() + " years old.");
    
    //this below is the ToInt<T> 
  /*  public int applyAsInt(Person p) {
    return p.getAge();
}  */
 //   ToIntFunction<Person> toAge = (Person p) -> {
   // return p.getAge();
//};
    //both fo these are valid uses of shortcuts in the syntax
    // The first follows the above shortcut pattern
  //  ToIntFunction<Person> toAge = p -> p.getAge();
    ToIntFunction<Person> toAge = Person::getAge;    //called a method reference
    
    
}
