package datastructures.quick;

import java.util.Arrays;

/**
 * 快速排序
 * 其中的一个元素为 “轴”
 * 从两边一起比较  左边启找到比轴大的 ，右边比 轴小的 两者进行交换
 *
 * 双轴快排
 * 两个轴 比第一个轴小的放左边，比第一个轴大的放右边。
 * 第二个轴类似
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 6, 3, 1, 5};
        int pivot  =arr[arr.length-1];
        int left = 0;
        int right=arr.length-2;


    }

    public static void sort(int[] arr, int leftBound,int rightBound){
        if(leftBound>=rightBound){
            return;
        }
        partition(arr,leftBound,rightBound);
    }

    private static void partition(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound];
        int left = leftBound;
        int rgiht= rightBound;
        while (left < rgiht){
            while (arr[left]<=pivot) left++;
            while (arr[rgiht]>=pivot) rgiht--;
            int temp = arr[left];
            arr[left] = arr[rgiht];
            arr[rgiht] = temp;
        }
        //将轴的位置和
        int temp = arr[left];
        arr[left] = arr[rgiht];
        arr[rgiht] = temp;
    }


}
