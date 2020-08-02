package datastructures.binaryserch;

/**
 * 二分查找
 */
public class BinarySerch {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 6, 3, 1, 5};
        bsearch(arr,arr.length,3);
    }

    /**
     * 前提是数组是有序的
     * @param arr
     * @param length
     * @param value
     * @return
     */
    private static int bsearch(int[] arr, int length, int value) {
        int low = 0;
        int high = length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if(arr[mid] == value){
                return mid;
            }else if(value>arr[mid]) {
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }
}

