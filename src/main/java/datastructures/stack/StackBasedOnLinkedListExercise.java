package datastructures.stack;

/**
 * 基于链表实现的栈
 * 栈是操作对头
 * 队列是操作队尾
 */
public class StackBasedOnLinkedListExercise {

private Node top = null;
public void push(int value){
    Node newNode = new Node(value,null);
    if(top == null){
        top = newNode;
    }else {
        //按照先进后出原则就是头节点哈日
        newNode.next = top;
        top = newNode;
    }
}
public int pop(){
    if(top == null){
        return -1;
    }else {
        int value = top.getData();
        top = top.next;
        return value;
    }
}


    private class Node{
        private int data;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        private Node next;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
