package Sorting;

import java.util.Arrays;

/* Quick Sort - QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array around the picked pivot. The key process in quickSort is partition(). Target of partitions is, given an array and an element x of array as pivot, put x at its correct position in sorted array and put all smaller elements (smaller than x) before x, and put all greater elements (greater than x) after x. 

TIME COMPLEXITY - [n(logn)] in Best Case and Average Case. [n2] is Worst Case Time Complexity.
*/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 80, 50, 90, 40, 30, 70};

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high)
            return;

        int pi = partition(arr, low, high);

        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int j = low - 1;

        for (int i = low; i < high; i++) {
            if (arr[i] < pivot) {
                j++;            // first increase value of j and then pass
                swap(arr, i, j);
            }
        }
        j++;            // first increase value of j and then pass
        swap(arr, j, high);
        return (j);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
