package datastructures.sort.insert;

import java.util.Arrays;

/**
 * 插入排序
 * 外层循环向前走
 * 内层循环向后比较和交换
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 6, 1, 5, 3};
          for(int i=0;i<arr.length;i++){
              for(int j=i;j>0;j--){
                  if(arr[j] < arr[j-1] ){
                      int temp = arr[j];
                      arr[j] = arr[j-1];
                      arr[j-1] = temp;
                  }
              }
          }
        System.out.println(Arrays.toString(arr));
    }
}
