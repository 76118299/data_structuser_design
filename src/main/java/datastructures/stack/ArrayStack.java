package datastructures.stack;

public class ArrayStack {
    private int[] arr;
    private int top = 0;


    public ArrayStack(int capacity) {
        this.arr = new int[capacity];

    }
    public void  push(int data){
        if(top==arr.length ){
            return;
        }else {
            arr[top++] = data;
        }
    }
    public int pop(){
        if(top == 0){
            return -1;
        }else {
            return arr[top--];
        }
    }
}
