package datastructures.queue;

public class QueueBaseOnLinkedListExercise {
    private Node head = null;
    private Node tail = null;

    //入队操作
    private void enqueue(int data){
        Node newNode= new Node(data,null);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else {
            tail.next = newNode;
            tail = tail.next; //这个是直接从尾部开始的
        }
    }
    public int dequeue(){
        if(head == null){
            return  -1;
        }
        int ret = head.data;
        head = head.next;
        if(head == null){
            tail = null;
        }
        return ret;
    }
    private class Node{
        private int data;

        public int getData() {
            return data;
        }

        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
