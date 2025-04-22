package SOLID.O;

public class Cat extends Animal {



        public Cat(String colour,String type){
            super(colour,type);
        }
        @Override
        public void eat() {
            System.out.println("cat is eating");
        }


    public static void catEatingState() {
        System.out.println("cat is eating now");
    }



    }


