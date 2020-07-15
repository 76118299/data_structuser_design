package datastructures.queue;

/**
 * 队列先进先出
 * 基于数组实现 (有界队列)
 */
public class ArrayQueue {
    private String[] items;

    private int n = 0; //数组容量
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }
    //入队
    public boolean enqueue(String item){
        if(tail == n){
            return  false;
        }
        items[tail] = item;
        tail++;
        return true;
    }
    //出队列
    public String dequeue(){
        if(head == tail){
            return  null;
        }
        return items[head++];
    }
}
