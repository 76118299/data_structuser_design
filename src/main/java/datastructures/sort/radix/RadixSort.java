package datastructures.sort.radix;

import java.util.Arrays;
import java.util.Map;

/**
 * 基数排序
 * 先按照个位从小到大排序
 * 再按照十位从小到大排序
 * 再按照百位从小到大排序
 */
public class RadixSort {
    public static void main(String[] args) {
        int [] arr ={421,240};
        int[] result = radinxSort(arr);
    }

    private static int[] radinxSort(int[] arr) {
        int[] reslt = new int[arr.length];
        int[] count = new int[10];
        for(int i=0;i<3;i++){
            //计算出个 十 百
            int division = (int) Math.pow(10,i);
            for(int j=0;j<arr.length;j++){
                int num = arr[j]/division%10;
                count[num]++;
            }
            System.out.println(Arrays.toString(count));
            //记录下标出现的最后的位置 【3，4】 下标1会出现在最终数组的第4个位置。
            //也就是说累加数组的元素记录的是出现在最终数组的位置。而下标才是真正排序的元素。
            for(int m=1;m<count.length;m++){
                count[m] = count[m] +count[m-1];
            }
            //进行倒序遍历
            for(int n = arr.length-1;n>=0;n--){
                int num = arr[n]/division%10;
                //取出来 num 出现的下标值
                 int ss= --count[num];
                reslt[ss] = arr[n];
            }
            System.arraycopy(reslt,0,arr,0,arr.length);
            Arrays.fill(count,0);

        }
        return reslt;

    }
}
