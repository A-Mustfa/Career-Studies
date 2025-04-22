package Queue;

public class DynamicQueueArray extends QueueArray{
    public DynamicQueueArray(){
        super();
    }
    public DynamicQueueArray(int capacity){
        super(capacity);
    }
    public boolean offer(int element){
        if(this.isFull()){
            int [] newDAta = new int[data.length*2];
            for (int i = 0; i < size; i++) {
                newDAta[i] = data[i];

            }
            data = newDAta;
        }
        return super.offer(element);


    }
}
