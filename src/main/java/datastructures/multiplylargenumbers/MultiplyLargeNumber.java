package datastructures.multiplylargenumbers;

/**
 * 个位 十位 百位
 * 先对个位排序
 * 十位排序
 * 百位排序
 * 数位的运算 个位 （103/1）%10
 * 十位 （103/10）%10
 * 百位（103/100）%10
 */
public class MultiplyLargeNumber {
    public static void main(String[] args) {
        int[] arr=new int[8];
        arr[arr.length-1] = 2;
        arr[arr.length-2] = 1;
        arr[arr.length-3] = 5;
        int num = 34;
        for (int i = 0;i<arr.length;i++){
            arr[i] = arr[i] * num;
        }
        //进位和留位
        for(int i=arr.length-1;i>0;i--){
            //进位
            arr[i-1] += arr[i]/10;
            //留位
            arr[i]%=10;
        }

    }
}
