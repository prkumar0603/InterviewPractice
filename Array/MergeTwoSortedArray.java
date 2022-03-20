package Array;

import java.util.Arrays;

/*Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order without using any extra space.
Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.
Example 1:
Input:
n = 4, arr1[] = [1 3 5 7]
m = 5, arr2[] = [0 2 6 8 9]
Output:
arr1[] = [0 1 2 3]
arr2[] = [5 6 7 8 9]
Explanation:
After merging the two
non-decreasing arrays, we get,
0 1 2 3 5 6 7 8 9.

Example 2:
Input:
n = 2, arr1[] = [10, 12]
m = 3, arr2[] = [5 18 20]
Output:
arr1[] = [5 10]
arr2[] = [12 18 20]
Explanation:
After merging two sorted arrays
we get 5 10 12 18 20.

Expected Time Complexity:  O((n+m) log(n+m))
Expected Auxilliary Space: O(1)
*/

public class MergeTwoSortedArray {
    public static void main(String[] args) {

        int[] arr1 = {1, 4, 7, 8, 10};
        int[] arr2 = {2, 3, 9};

        for (int i = 0; i < arr1.length; i++) {
            // check all elements of 1st array with 0th element of 2nd array. if (arr1[i] > arr2[0]) then swap
            // and keep the 2nd array sorted
            if (arr1[i] > arr2[0]) {
                int temp = arr2[0];
                arr2[0] = arr1[i];
                arr1[i] = temp;

                insertionSortToKeepSecondArraySorted(arr2, arr2.length);
            }
        }

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    private static void insertionSortToKeepSecondArraySorted(int[] arr, int n) {
        int k = 1;
        int key = arr[0];

        while (k < n && arr[k] < key) {
            arr[k - 1] = arr[k];
            k++;
        }
        arr[k - 1] = key;
    }

}
