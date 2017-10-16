
package com.sg.person;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;


public class PersonLambdas {
    
    Person person = new Person();
    
    public boolean testAge(Person person){
        return person.getAge() >= 18;
    }
    
    Predicate<Person> oldEnoughToVote = (Person p) -> {
        return p.getAge() >= 18;
    }; 
    
    public void accept(Person person){
        System.out.println(person.getName()
        + " is "
        + person.getAge()
        + " years old");
    }
    
    Consumer<Person> howOld = (Person p) -> {
        System.out.println(p.getName()
        + " is "
        + p.getAge()
        + " years old");
    };
    
    public int applyAsInt(Person p){
        return p.getAge();
    }
    
    ToIntFunction<Person> toAge = (Person p) -> {
        return p.getAge();
    };
    
        //shortcut of the above
        //ToIntFunction<Person> toAge = Person::getAge();
        //thew above has what is called a method reference
    
    
}
