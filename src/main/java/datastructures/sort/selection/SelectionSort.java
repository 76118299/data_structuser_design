package datastructures.sort.selection;

import java.util.Arrays;

/**
 * 选择排序
 * 依次循环数组找到最小的放到第一个位置
 * 找到第二个小地放到第二个位置
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 4, 2, 3, 8, 9, 1};
//        for (int i = 0; i < arr.length; i++) {
//            int minPos = i;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[minPos] > arr[j]) {
//                    minPos = j;
//                }
//            }
//            int tmmep = arr[minPos];
//            arr[minPos] = arr[i];
//            arr[i] = tmmep;
//        }
//        System.out.println(Arrays.toString(arr));

    for(int i=0;i<arr.length;i++){
        //复习
        int minIndex = i;
        for(int j = i+1 ;j<arr.length; j++){
            if(arr[minIndex]>arr[j]){
                minIndex=j;
            }
        }
        int temp1 = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp1;

    }
        System.out.println(Arrays.toString(arr));

    }
}
