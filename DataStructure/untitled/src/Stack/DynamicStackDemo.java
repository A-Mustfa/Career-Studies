package Stack;

public class DynamicStackDemo extends StackDemo{
    public DynamicStackDemo(){
        super();
    }
    public void push(int element){
        if(arraysize == array.length){
            resize();
        }
        super.push(element);
    }
    private void resize(){
        int [] newArray = new int[this.array.length*2];
        for (int i = 0; i <= this.arraysize-1; i++) {
            newArray[i] = this.array[i];
        }
        array = newArray;
    }
}
