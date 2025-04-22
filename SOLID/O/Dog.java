package SOLID.O;

public class Dog extends Animal{


    public Dog(String colour,String type){
        super(colour,type);
    }
    @Override
    public void eat() {
        System.out.println("dog is eating");
    }
    public static void dogEatingState() {
        System.out.println("dog is eating now");
    }
}
