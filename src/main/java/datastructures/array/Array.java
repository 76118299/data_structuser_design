package datastructures.array;

public class Array {
    private int[] data;
    //数组的长度
    private int n;
    //数组的实际数量
    private int count;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    /**
     * 根据下标查找元素
     *
     * @param index
     * @return
     */
    public int find(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        return data[index];
    }

    public boolean add(int index, int value) {

            if (count == n) {
                System.out.printf("数组空间已满");
                return false;
            }
            if (index < 0 || index > count) {
                System.out.printf("非法下标");
                return false;
            }
            /**
             * 合适的位置
             */
            for (int i = count; i > index; i--) {
                data[i - 1] = data[i];
            }
            data[index] = value;
            ++count;
            return true;
    }

    /**
     * 根据下标删除元素
     * @return
     */
    public boolean delete(int index){
        if (index < 0 || index > count) {
            System.out.printf("非法下标");
            return false;
        }
        //从删除的位置，将后面的元素向前移动
        for(int i=index -1 ; i<count;i++){
            data[i-1] = data[i];
        }
        --count;
        return true;
    }


    public void printAll(){

    }



}
