package datastructures.queue;

public class ArrayQueueExercie {
    private int[] items;
    private int head=0;
    private int tail=0;
    private int n=0;

    public ArrayQueueExercie(int capacity) {
        this.items = new int[capacity];
        this.n = capacity;
    }

    public void enqueue(int item){
        if(tail == n){
            return;
        }
        items[tail++] = item;
    }
    public void enqueue1(int item){
        if(tail==n){
            if(head == 0){
                return;
            }
            //
            for(int i=head;i<tail ;++i){
                items[i-head] = items[i];
            }
            tail -=head;
            head = 0;
        }
        items[tail] = item;
    }
    public int dequeue(){
        if(head == tail){
            return -1;
        }
        return items[head++];
    }
}
