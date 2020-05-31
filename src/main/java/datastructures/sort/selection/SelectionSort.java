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

        //外层循环 步长++
        for (int i = 0; i < arr.length; i++) {
            int elementIndex = i;
            //内层需要找到最小的元素下标
            for (int j = i + 1; j < arr.length; j++) {
                //先找到最小元素的下标
                if (arr[elementIndex] > arr[j]) {
                    elementIndex = j;
                }
            }
            //进行元素交换 把最小的元素放到数组的第一位置 第二个小的...
            int temp = arr[elementIndex];
            arr[elementIndex] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));


    }
}
