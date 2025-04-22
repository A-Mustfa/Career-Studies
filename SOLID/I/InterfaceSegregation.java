package SOLID.I;

public interface InterfaceSegregation {
    void welcome();
    void print();
    void getAge();
    void getArea();

    /* instead of putting all methods in same interface and forcing all classes to implement them
    even if they don't use it, just segregate the methods across multiple interfaces */
}
