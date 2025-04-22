package Stack;

public class StackDemo {
    protected int [] array;
    protected int arraysize = 0;
    private static final int INITIALCAPACITY = 10;
    public StackDemo(int capacity){
        array = new int[capacity];
    }
    public StackDemo(){
        this(INITIALCAPACITY);
    }
    public void push(int element){
        if(this.arraysize == array.length){
            System.out.println("sorry stack if full");
        }else {
            this.array[arraysize++] = element;
        }
    }
    public void pop(){
        if(this.arraysize == 0){
            System.out.println("sorry array is empty");
        }else {
            System.out.println("removed element is: " + this.array[--arraysize]);
        }
    }
    public void peek(){
        if(this.arraysize == 0){
            System.out.println("sorry array is empty");
        }else {
            System.out.println("last element is: " + this.array[arraysize-1]);
        }
    }
    public void print(){
        System.out.print("[ ");
        for (int i = 0; i < arraysize; i++) {
            System.out.print(this.array[i] + " ");
        }
        System.out.println("]");
    }


}
