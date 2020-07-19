package datastructures.array;

public class GenericArrayExercise {
    private int[] data;
    private int n ;
    private int count;
    public GenericArrayExercise(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }
    public GenericArrayExercise() {
        this(10);
    }

    /**
     * 返回数组长度
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 判断数组是否有元素
     * @return
     */
    public boolean isEmpty(){
      return   this.count ==0;
    }
    public void  set(int index,int value){
        if(index<0 || index >n){
            return;
        }
        data[index] = value;
    }
    public int get(int index){
        if(index<0 || index >n){
            return -1;
        }
        return  data[index];
    }
    public boolean contains(int value){
        for(int i = 0;i<data.length ;i++){
            if(data[i] == value){
                return true;
            }
        }
        return  false;
    }
    public int findIndex(int value){
        for(int i=0;i<data.length;i++){
            if(data[i] == value){
                return i;
            }
        }
        return -1;
    }
    public boolean insert(int index ,int value){
        if(index<0 || index>n){
            return false;
        }
        if(count == n){
            return false;
        }
        if(data.length == n){
            int [] newData = new int[data.length*2];
            System.arraycopy(data,0,newData,0,data.length);
            data = newData;
        }
        //数据搬移
//        for(int i=count;i>index;i--){
//            //例如index 为6 的位置，会被 index 6-1 位置元素赋值 一直循环到 i>index的时候就是找到合适的 位置了
//            data[i] = data[i-1];
//        }
        for(int i=count;i>index ;i--){
            data[i] = data[i-1];
        }
        data[index] = value;
        count++;
        return true;
    }
    public boolean remove(int index){
        if(index<0 || index>n){
            return false;
        }
     for(int i=index+1;i<count;i++){
         data[i-1] = data[i];
     }
        return true;
    }



}
