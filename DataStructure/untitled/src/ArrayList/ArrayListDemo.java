package ArrayList;

public class ArrayListDemo<T> {
    private int size = 0;

// generic array
    private T [] basedArray;
    private int initialCapacity = 10;
// instantiated an array with size 10
    public ArrayListDemo(){
        this.basedArray = (T[]) new Object[10];
    }
//    add element to the array but check first if the array is full ? increase capacity. then add the element and increase size
    public void add(T element){
        if(size == basedArray.length){
            reSizeUp();
        }
        basedArray[size] = element;
        size++;
    }
//    to resize the array by doubling its capacity and refill it;
    private void reSizeUp(){
         T [] newOne = (T[]) new Object[basedArray.length*2];
         for (int i = 0; i < size; i++){
             newOne[i] = basedArray[i];
         }
         basedArray = newOne;
    }
    private void reSizeDown(){
        T [] newOneDown = (T[]) new Object[basedArray.length/2];
        for (int i = 0; i < size; i++){
            newOneDown[i] = basedArray[i];
        }
        basedArray = newOneDown;
    }
//    check first if index is valid then remove and decrease capacity if needed;
    public void remove(int index){
        if(!(index < size)){
            System.out.println("inValid index");
        } else {
            for (int i = index; i < size ; i++) {
                basedArray[i] = basedArray[i+1];
            }
            size--;
        }
        if (size < basedArray.length/3) {
            reSizeDown();
        }
    }
    public void print(){
        System.out.print("[");
        for (int i = 0; i < basedArray.length; i++) {
            System.out.print(basedArray[i] + " ");
        }
        System.out.println("]");
    }
}
