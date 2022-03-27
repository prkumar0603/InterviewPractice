package Array;

import java.util.Arrays;

/* Given an array of integers. Find the Inversion Count in the array.
Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the
inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum.
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
Example 1:
Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5
has three inversions (2, 1), (4, 1), (4, 3).
Example 2:
Input: N = 5
arr[] = {2, 3, 4, 5, 6}
Output: 0
Explanation: As the sequence is already
sorted so there is no inversion count.
Example 3:
Input: N = 3, arr[] = {10, 10, 10}
Output: 0
Explanation: As all the elements of array
are same, so there is no inversion count.
Your Task:
You don't need to read input or print anything. Your task is to complete the function inversionCount() which takes the array arr[] and the size of
the array as inputs and returns the inversion count of the given array.
Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(N).
Constraints:
1 ≤ N ≤ 5*105
1 ≤ arr[i] ≤ 1018
*/
public class CountInversion {
    public static void main(String[] args) {
        int[] arr = {8, 4, 2, 1};
        int n = arr.length;

        int inv_count = mergesort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println("inv_count : " + inv_count);
    }

    private static int mergesort(int[] arr, int low, int high) {
        int inv_count = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;

            inv_count += mergesort(arr, low, mid);        // adding all the inversions
            inv_count += mergesort(arr, mid + 1, high);   // adding all the inversions

            inv_count += merge(arr, low, mid, high);      // adding all the inversions
        }
        return inv_count;
    }

    private static int merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = (mid + 1);
        int k = low;
        int[] temp = new int[arr.length];
        int inv_count = 0;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];

                // this is tricky. (start of right array - i)
                inv_count += (mid + 1) - (i);
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        for (k = low; k <= high; k++)
            arr[k] = temp[k];

        return inv_count;
    }
}
