package datastructures.heap;

/**
 * Heap
 * 堆是一个完全二叉树
 * 堆中的每一个节点的值必须大于等于，或者小于等于其左右子节点的值
 */
public class Heap {
    private int[] a;//数组，从小标1开始存储数据
    private int n; //堆可以存储的最大数据个数
    private int count;//堆中一级存储的数据个数

    public Heap(int capacity){
        a = new int[capacity];
        n =capacity;
        count=0;
    }

    /**
     * 插入过程
     * 新的节点和父节点进行对比大小
     * 如果不满足子节点小于等于父节点的关系，就互换两个节点
     * 直到满足关系
     * 从下向上堆化
     * 存储方式是数组
     * @param data
     */
    public void insert(int data){
        if(count>=n){
            return;
        }
        count++;
        a[count] = data;
        int i = count;
        /**
         * 从下向上和父节点进行比较和交换
         */
        while (i/2>0 && a[i] > a[i/2]){
            swap(a,i,i/2);
            i = i/2;
        }
    }

    /**
     * 删除堆顶元素
     * 把最后的一个节点放到堆顶
     * 利用同样的父子节点对比。对于不满足父子节点大小的关系，互换两个节点
     * 重复执行这个过程，直到父子节点之间满足位置
     * 从上到下的堆化方法
     */
    public void removeMax(){
        if(count == 0){
            return;
        }
        //将数组的最后一个节点放到堆顶
        a[1] = a[count];
        --count;
        /**
         * 从上到下进行堆化
         */
        heapify(a,count,1);
    }

    /**
     * 堆化从上到下
     * @param a
     * @param count
     * @param i
     */
    private void heapify(int[] a, int count, int i) {
        while (true){
            int maxPos = i;
            if(i*2<=n && a[i]<a[i*2]){
                maxPos = i*2;
            }
            if(i*2+1<=n&& a[i]<a[i*2+1]){
                maxPos = i*2+1;
            }
            if(maxPos == i){
                break;
            }
            swap(a,i,maxPos);
            i = maxPos;
        }
    }

    /**
     * 建堆
     * 1.在堆中插入一个元素的思路。从前向后处理数组数据，每个数据插入堆中
     * 都是从下到上
     * 2.第二种就是从后向前处理数组数据，每个数据插入堆中是从上到下
     */
    public void builHeap(int[] a,int n){
        //从后向前遍历节点
        for (int i = n/2;i>=1 ;--i){
            //从上向下堆化
            heapify(a,n,i);
        }
    }

    private void swap(int[] a,int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
