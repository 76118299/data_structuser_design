package datastructures.sort.bubble;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 6, 3, 1, 5};
//        for (int i = arr.length; i > 0; i--) {
//            for (int j = 0; j < i - 1; j++) {//内层循环一周 找到第一个大的，第二周找到第二个大的
//                if (arr[j] > arr[j + 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
        //复习
        for(int i=arr.length; i>0;i--) {
            for (int j = 0; j < i-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }


}
