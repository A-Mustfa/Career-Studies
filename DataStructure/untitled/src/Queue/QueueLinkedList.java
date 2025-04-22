package Queue;

public class QueueLinkedList {
    private Node head;
    private Node tail;

    public QueueLinkedList() {
    }
    public void offer(int element){
        if(tail == null){
            tail = new Node(element);
            head = tail;
        }else {
            Node newNode = new Node(element);
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void poll(){
        if(head == null){
            System.out.println("Empty Queue");
        }else {
            int value = head.value;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            System.out.println(value);
        }
    }
    public void peekFirst(){
        if(head == null){
            System.out.println("queue is empty");
        }else{
            System.out.println(head.value);
        }
    }
    public void peekLasst(){
        if(tail == null){
            System.out.println("queue is empty");
        }else{
            System.out.println(tail.value);
        }
    }
    public void print(){
        if(head == null){
            System.out.println("Queue is Empty");
        }else {
            Node temp = head;
            while(temp != null){
                System.out.print(temp.value + "<--");
                temp = temp.next;
            }
            System.out.println();
        }
    }


    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node() {
        }
    }
}
