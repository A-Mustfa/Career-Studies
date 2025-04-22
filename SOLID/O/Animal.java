package SOLID.O;

public abstract class Animal {
    private String colour;
    private String type;
    public Animal(String colour, String type){
        this.colour = colour;
        this.type = type;
    }
    public abstract void eat();

    public String getType() {
        return type;
    }
}
