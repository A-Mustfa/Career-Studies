package LinkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
    }

    public void addFirst(int val){
        Node newNode = new Node(val);
        if(head == null){
            head=newNode;
            tail=head;
        }else{
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
    }
    public void addLast(int val){
        Node newNode = new Node(val);
        if(tail == null){
            head=newNode;
            tail=head;
        }else{
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void get(int index){
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next ;
        }
        System.out.println("value is : " +  temp.val);
    }
    public void printForward(){
        Node tmp = head;
        while (tmp!=null){
            System.out.print("-->[ "+tmp.val+" ] ");
            tmp = tmp.next;
        }
        System.out.println();
    }
    public void printBackward(){
        Node tmp = tail;
        while (tmp!=null){
            System.out.print("[ "+tmp.val+" ] --> ");
            tmp = tmp.previous;
        }
        System.out.println();
    }

    public int removeLast(){
        if(tail == null){
            return 404;
        }
        int val = tail.val;
        if (tail.previous == null){
            head = null;
            tail = null;
        }else {
            tail = tail.previous;
            tail.next = null;
        }
        return val;
    }
    public int removeFirst(){
        if(head == null){
            return -1;
        }
        int removed = head.val;
        if (head.next == null) {
            tail = null;
            head = null;
        } else {
            head = head.next;
            head.previous=null;
        }
        return removed;
    }
    public int remove(int index){
        Node tmp = head;
        for (int i = 0; i < index; i++) {
            tmp=tmp.next;
        }
        int val = tmp.val;
        tmp.previous.next = tmp.next;
        tmp.next.previous = tmp.previous;
        return val;
    }


    private class Node{
        private int val;
        private Node next,previous;

        public Node(int val) {
            this.val = val;
        }
    }
}
