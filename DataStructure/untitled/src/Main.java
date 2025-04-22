import LinkedList.DoublyLinkedList;

public class Main {
    public static void main(String[] args) {

        /* ArrayList
        ArrayListDemo<Integer> arr = new ArrayListDemo<Integer>();
        arr.add(10);
        arr.add(10);
        arr.add(10);
        arr.add(10);
        arr.add(10);
        arr.add(10);
        arr.add(10);
        arr.add(10);
        arr.add(10);
        arr.add(9);
        arr.add(8);
        arr.print();
        arr.remove(2);
        arr.print();
        arr.remove(2);
        arr.print();
        arr.remove(2);
        arr.print();
        arr.remove(2);
        arr.print();
        arr.remove(2);
        arr.print();
        arr.remove(2);
        arr.print();
        arr.remove(2);
        arr.print();
        arr.remove(2);
        arr.print();
        arr.remove(2);
        arr.print();
        arr.remove(2);
        arr.print();
         */
        /* Linked List
        LinkedListDemo ll = new LinkedListDemo();
        ll.addFirst(10);
        ll.addFirst(12);
        ll.addFirst(14);
        ll.addFirst(13);
        ll.addLast(60);
        ll.addLast(70);
        ll.print();

        ll.getLastElement();
        ll.getFirstElement();
       */
        /*
        StackDemo st = new StackDemo();
        st.push(1);
        st.push(80);
        st.push(60);
        st.push(5);
        st.push(1);
        st.push(80);
        st.push(60);
        st.push(5);
        st.push(60);
        st.push(5);
        st.print();
        st.pop();
st.peek();
        st.peek();
        st.peek();
        st.peek();
        st.peek();
        st.peek();
        st.peek();
        st.peek();
        st.peek();
        st.peek();
st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();

         */
        /*
        stack using linkedlist
        StackLinkedList st = new StackLinkedList();
        st.push(2);
        st.push(3);
        st.push(5);
        st.push(9);
        st.peek();
        st.print();
        st.pop();
        st.print();
        */
        /*
        DynamicQueueArray qq = new DynamicQueueArray();
        qq.offer(13);
        qq.offer(18);
        qq.offer(17);
        qq.offer(16);
        qq.offer(19);
        qq.offer(13);
        qq.offer(18);
        qq.offer(17);
        qq.offer(16);
        qq.offer(19);
        qq.print();
        qq.offer(50);
        System.out.println(qq.poll());
        System.out.println(qq.poll());
        System.out.println(qq.poll());
        System.out.println(qq.poll());
        System.out.println(qq.poll());
        System.out.println(qq.poll());
        System.out.println(qq.poll());
        System.out.println(qq.poll());
        System.out.println(qq.poll());
        System.out.println(qq.poll());
        System.out.println(qq.poll());
        qq.peek();
        qq.print();
        */
        /* queue via linked list
        QueueLinkedList ql = new QueueLinkedList();
        ql.offer(5);
        ql.offer(3);
        ql.offer(4);
        ql.offer(2);
        ql.offer(0);
        ql.offer(1);

        ql.print();
        ql.poll();

        ql.peekLasst();
        ql.peekFirst();
         */
        /*
        HashTableDemo<Integer,String> hash = new HashTableDemo();
        hash.put(5,"ahmed");
        hash.put(6,"asdd");
        hash.put(2,"qweee");
        hash.put(9,"ahmed");
        hash.put(9,"ahmed");
        hash.put(9,"ahmed");
        hash.print();
        System.out.println(hash.contains(5));
        System.out.println(hash.remove(6));
        hash.print();


        HashTableLinked<Integer,String> ht = new HashTableLinked<>();
        ht.put(1,"ahmed");
        ht.put(1,"mohamed");
        ht.put(3,"basma");
        ht.put(4,"naglaa");
        ht.print();
        System.out.println(ht.get(0));
        System.out.println(ht.contains(2));
        System.out.println(ht.remove(2));
        ht.print();
        */

        DoublyLinkedList dl = new DoublyLinkedList();
        dl.addFirst(10);
        dl.addFirst(20);
        dl.addFirst(70);
        dl.addFirst(90);
        dl.addFirst(80);
        dl.addFirst(25);
        dl.printBackward();
        dl.printForward();
        dl.get(3);
        System.out.println(dl.remove(3));
        dl.printForward();




    }
}