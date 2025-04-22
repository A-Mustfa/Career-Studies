package SOLID;

import SOLID.O.Animal;
import SOLID.O.Cat;
import SOLID.O.Dog;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }



//-----------------------------Open-Closed-Principle----------------------------------------------------//
    /*
    next method violates the open closed Principle because when adding a new animal
    we will have to come and edit this method
     */
    public static void eatState(Animal animal){
        if(animal.getType().equals("cat")){
            Cat.catEatingState();
        } else if (animal.getType().equals("cat")) {
            Dog.dogEatingState();
        }
    }

    /*
    we can solve it by abstraction (polymorphism)
     */

    public static void enhancedState(Animal animal){
        animal.eat();
    }
//------------------------------------------------------------------------------------------------------//
}