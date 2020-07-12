package datastructures.array;

import org.omg.CORBA.Object;

public class GenericArray<T> {
    private T[] data;
    private int size;

    public GenericArray(int size) {
        this.data = (T[]) new Object[size];
        this.size = 0;
    }

    public GenericArray() {
        this(10);
    }

    public int getCapacty() {
        return this.data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void set(int index, T value) {
        if (index < 0 || index > size) {
            System.out.printf("非法下标");
            return;
        }
        data[index] = value;
    }

    public T get(int index) {
        if (index < 0 || index > size) {
            System.out.printf("非法下标");
            return null;
        }
        return data[index];
    }

    public boolean contains(T e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    public int find(T e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public void add(int index, T value) {
        if (index < 0 || index > size) {
            System.out.printf("非法下标");
            return;
        }
        //扩容
        if (size == data.length) {
            T[] newData = (T[]) new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        /**
         * 移动一个下标的元素
         */
          for(int i=size-1;i>=index;i--){
              data[i+1] =data[i];
          }
        data[index] = value;
        size++;

    }
    public void  addFirst(T e){
        add(0,e);
    }
    public void addLast(T e){
        add(size,e);
    }
    public  T remove(int index){
        if (index < 0 || index > size) {
            System.out.printf("非法下标");
            return null;
        }
        T ret = data[index];
        for(int i=index;i<size;i++){
            data[i-1] =data[i];
        }
        size --;
        data[size] = null;
        return ret;
    }
    public T removeFirst(){
        return remove(0);
    }
    public T removeLast(){
        return remove(size-1);
    }
    public void revmoeElement(T e){
      remove(find(e))  ;
    }


}
