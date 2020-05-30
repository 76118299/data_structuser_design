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
        for (int i = 0; i < arr.length; i++) {
            //minPos 随着每一轮的循环 i的变化进行初始化
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPos] > arr[j]) {
                    //找到最小的下标
                        minPos = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }


        System.out.println(Arrays.toString(arr));


    }
}
