package Queue;

import java.util.Queue;

public class QueueArray {
    protected int [] data;
    protected int size =0;
    protected int ptr =0;
    private static final int INITIAL_CAPACITY = 10;
    public QueueArray(int size){
        data = new int[size];
    }
    public QueueArray(){
        this(INITIAL_CAPACITY);
    }
    public boolean offer(int element) {
        if (isFull()) {
            System.out.println("array is Full");
            return false;
        } else {
            data[size++] = element;
            return true;
        }
    }
    protected boolean isFull(){
        if(size == data.length){
            return true;
        }
        else
            return false;
    }

    public int poll() {
        if (isEmpty()) {
            System.out.println("array is Empty");
            return -100;
        } else {
            size--;
            return data[ptr++];
        }
    }

    protected boolean isEmpty() {
        if(size == 0){
            return true;
        }else {
            return false;
        }
    }
    public void peek(){
        if(isEmpty()){
            System.out.println("array is empty");
        }else
        {
            System.out.println("top is: " + data[ptr]);
        }
    }

    public void print(){
        if(isEmpty())
            System.out.println("array is Empty");
        else{

            for (int i = ptr; i < size; i++) {
                System.out.print(data[i] + " <-- ");
            }
            System.out.println();
        }

    }


}
