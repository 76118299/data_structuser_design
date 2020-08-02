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
    public void mergeSortRecursion(int[] a,int p,int r){
        if(p>r){
            return;
        }
        int q = p + (r - p) / 2;
        mergeSortRecursion(a,p,q);
        mergeSortRecursion(a,q+1,r);
        merge(a,p,q,r);

    }

    private void merge(int[] a, int p, int q, int r) {
        int i=p;
        int j=q+1;
        int k=0;
        int [] tmp = new int[r-p+1];
        while (i<=p&&j<=r){
            if(a[i]>a[j]){
               // tmp[k++] = a[i++];
                tmp[k] = a[i];
                k++;
                i++;
            }else {
               // tmp[k++] = a[j++];
                tmp[k] = a[j];
                k++;
                j++;
            }
        }
        //判断子数组是否有剩余的
        int start = i;
        int end = q;
        if(j<=r){ //判断的是第二个数组
            start = j;
            end = r;
        }
        while (start<=end){ //判断的是第一个数组
            tmp[k++] = a[start++];
        }

    }
}
