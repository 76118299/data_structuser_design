package design.iterator;

public class MyLinkList implements MyCollection {
    Node head = null;
    Node tail = null;
    private int size = 0;
    public void add(Object o){
        Node n = new Node(o);
        n.next = null;
        if(head == null){
            head = n;
            tail = n;
        }
            tail.next = n;
            tail = n;
            size++;

    }

    public int size() {
        return size;
    }

    public Iterator iterator() {
        return null;
    }

    private  class Node{
        private Object o;
        Node next;
        public Node(Object o){
            this.o = o;
        }
    }
}
