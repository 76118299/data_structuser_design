package datastructures.queue;

/**
 * 基于链表实现得队列
 * 无界队列
 */
public class LinkedQueue {
    private Node head = null;
    private Node tail = null;

    /**
     * 入队
     * @param value
     */
    private void enqueue(String value){
        Node newNode = new Node(value,null);
        if(tail == null){
            head = newNode;
            tail = newNode;
        }else {
            tail.next = newNode;
            tail = tail.next;
        }
    }
    public String dequeue(){
        if(head == null){
            return  null;
        }
        String value = head.data;
        head = head.next;
        if(head == null){
            tail = null;
        }

        return value;
    }
    public class Node{
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
        public String getData() {
            return data;
        }

    }

}
