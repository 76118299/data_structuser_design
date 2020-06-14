package datastructures.sort.shell;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 6, 1, 5, 3, 11, 12, 14, 16, 4, 8, 0, 2, 6, 9};


        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //插入排序 间隔是
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {
                    if (arr[j] < arr[j - gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j - gap];
                        arr[j - gap] = temp;
                    }
                }
            }
        }
    }
}
