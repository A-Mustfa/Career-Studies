package Stack;

public class StackLinkedList {

    private Node head;
    public StackLinkedList(){

    }
    public void push(int value){
        if(head == null){
            head = new Node(value);
        }else {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        }
    }
    public void pop(){
        if(head == null){
            System.out.println("Stack is Empty");
        }else {
            int value = head.value;
            head = head.next;
            System.out.println("poped element is: " + value);
        }
    }
    public void peek(){
        if(head == null){
            System.out.println("Stack is Empty");
        }else {
            System.out.println("top element is: " + head.value);
        }
    }
    public void print(){
        if(head == null){
            System.out.println("Stack is Empty");
        }else {
            Node temp = head;

            while(temp != null){
                System.out.print("-->" + temp.value );
                temp=temp.next;
            }
            System.out.println();
        }
    }




    private class Node{
        private int value;
        private Node next;
        public Node(int value){
            this.value = value;
        }
        public Node(){

        }
    }
}
