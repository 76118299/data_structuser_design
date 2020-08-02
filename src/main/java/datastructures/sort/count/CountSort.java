package datastructures.sort.count;

import java.util.Arrays;

/**
 * 计数排序
 * 将要排序的数组的的值作为，新数组的下标。
 * 新数组的下标值就是要排序的数组的值。
 * 如果相同的下标则进行++操作
 * 然后再将新数组的下标，作为值，赋值给结果数组。排序完成
 */
public class CountSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 6, 3, 1, 5,7,9,3,4,5,7,6,2,4,5,6,6,0,1,2,3};
        int[] result = new int[arr.length];
        int[] count = new int[10];
        //将元素添加到count数组进行计数
        for (int i=0;i<arr.length;i++){
            //下标是有序的
            count[arr[i]]++;
        }
        /**
         * 遍历count count的下标就是arr的元素已经是有序的了
         * 我们只要把count的下标，赋值新数组就排完了
         */
        for(int i=0,j=0;i<count.length ;i++){
            /**
             * 遍历多个同样数的下标，i的值就是要排序的值（下标就是要排序的值）
             */
            while (count[i]-->0){
                //下标j的值是i 就是给下标j的元素赋值i
                result[j++] = i;
            }
        }
        System.out.println(Arrays.toString(result));

        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        for(int i=0, j=0; i<count.length; i++){
            while (count[i]-->0){
                result[j++] = i;
            }
        }

    }
    public void countSort(int[] arr){
        int[] count=new int[arr.length];
        int[] ret=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        for(int m = 1;m<count.length;m++){
            count[m] = count[m]+count[m-1];
        }
        for(int i=arr.length-1;i>=0;i--){ //arr【】就是count的下标
            /**
             * 例如：arr[7] 那么对应的count[8],我们把8取出来进行-1操作
             * 然后放入ret 最终数组第7的下标位置上 把arr【i】的值
             */
            int c = count[arr[i]];
            int c1 = --c;
            ret[c1] = arr[i];
        }
    }



}
