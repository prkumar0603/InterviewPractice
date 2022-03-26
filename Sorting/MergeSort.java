package Sorting;

import java.util.Arrays;

/* Merge Sort - It divides the input array into two halves, calls itself for the two halves, and then merges the two sorted halves. The merge() function is used for
merging two halves. The merge(arr, l, m, r) is a key process that assumes that arr[l..m] and arr[m+1..r] are sorted and merges the two sorted sub-arrays
into one.
If high > low
     1. Find the middle point to divide the array into two halves:
             mid = low+ (high-low)/2
     2. Call mergeSort for first half:
             Call mergeSort(arr, low, mid)
     3. Call mergeSort for second half:
             Call mergeSort(arr, mid+1, high)
     4. Merge the two halves sorted in step 2 and 3:
             Call merge(arr, low, mid, high)

TIME COMPLEXITY is [n(logn)] in all three cases.
*/
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {10, 4, 3, 30, 46, 40};

        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {

            int mid = low + (high - low) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
    }

    // this function merges two arrays. [low, mid] and [mid+1,high]
    private static void merge(int[] arr, int low, int mid, int high) {

        int[] tempArray = new int[arr.length];
        int i = low;
        int j = mid + 1;
        int k = low;

        // merge both the array in sorted order
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                tempArray[k++] = arr[i++];
            } else {
                tempArray[k++] = arr[j++];
            }
        }

        // if elements are left in first array [low, mid], add them
        while (i <= mid) {
            tempArray[k++] = arr[i++];
        }

        // if elements are left in first array [mid+1, high], add them
        while (j <= high) {
            tempArray[k++] = arr[j++];
        }

        // copy from B array to main array.
        for (k = low; k <= high; k++)
            arr[k] = tempArray[k];

    }
}
