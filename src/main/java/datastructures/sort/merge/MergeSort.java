package datastructures.sort.merge;

import java.util.ArrayList;
import java.util.List;

/**
 * 两个有序数组进行 合并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr =new int[]{1,4,7,8,3,6,9};
        int[] temp = new int[arr.length];
        int mid = arr.length/2;
        int i = 0;
        int j = mid+1;
        int k = 0;

        while (i<mid && j<arr.length){
            if(arr[i]<arr[j]){
                temp[k] = arr[i];
                i++;
                k++;
            }else if(arr[i] > arr[j]) {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }

    }
}
