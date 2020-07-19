package datastructures.array;

/**
 * 数组操作联系
 */
public class ArrayExercise {
    private int [] data;
    private int n; //数组得长度
    private int count;//元素得数量

    public ArrayExercise(int capacity) {
        data = new int[capacity];
        n = capacity;
        count = 0;
    }

    public int find(int index){
        if(index<=count || index<0){
            return  -1;
        }
        return  data[index];
    }
    public boolean add(int index ,int value){
        if(index<=count || index<0){
            return  false;
        }
        if(count == n){
            return  false;
        }
        if(index>count || index<0){
            return false;
        }
        //数据搬移找到index得下标位置
        for(int i = count ;i>index;i--){
            //将第五个元素 移动到第6个位置 指定i 不符合index得条件
           data[i] = data[i-1];//元素向后移动到index为止
        }
        data[index] = value;
        ++count;
        return true;
    }
    public boolean delete(int index){
        if(index<=count || index<0){
            return  false;
        }
        //删除我们只要移动元素即可
        for(int i = index+1 ;i<count;i++){
            data[i-1] = data[i];
        }
        return true;
    }
}
