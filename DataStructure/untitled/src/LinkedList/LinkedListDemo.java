package LinkedList;

public class LinkedListDemo {
    private int size = 0;
    private Node head;
    private Node tail;
     public LinkedListDemo(){

     }
     public void addFirst(int element){
         if(head == null){
             head = new Node(element);
             tail = head;
         }else{
             Node new1 = new Node(element);
             new1.next = head;
             head = new1;
         }
     }
     public void addLast(int element){
         if(tail == null){
             tail = new Node(element);
             head=tail;
         }else{
             Node addedLast = new Node(element);
             tail.next = addedLast;
             tail = addedLast;
         }
     }
     public void print(){
         Node temp = new Node();
         temp = head;
         while(temp != null){
             System.out.println(temp.value);
             temp=temp.next;
         }
     }
    public void getFirstElement(){
        if (head == null){
            System.out.println("list is empty");
        } else {
            System.out.println("First element is: " + head.value);
        }
    }
     public void getLastElement(){
         if (tail == null){
             System.out.println("list is empty");
         } else {
             System.out.println("Last element is: " + tail.value);
         }
     }
     public int removeFirst(){
         if(head == null){
             return -1;
         }
         int removed = head.value;
         if (head.next == null) {
             tail = null;
             head = null;
         } else {
             head = head.next;
         }
         return removed;
     }












    private class Node{
        private int value;
        private Node next;
        public Node(int value){
            this.value = value;
        }

        public Node() {
        }
    }
}
