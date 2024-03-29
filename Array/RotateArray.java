package Array;

import java.util.Arrays;

/*Given an array, rotate the array to the right by k steps, where k is non-negative.
Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
*/

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        // preprocessing
        k = k % arr.length;       // array of size n, rotated by n, comes back to same array
        if (k < 0) { // if we get -ve value, then -ve is just equals to it's -ve + array.length
            k += arr.length;
        }

        System.out.println("Original Array : " + Arrays.toString(arr) + " | k : " + k);
        rotateArrayBackToFront(arr, k, arr.length);
        System.out.println("Rotated Array back to front" + Arrays.toString(arr));

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        rotateArrayFrontToBack(arr1, k, arr1.length);
        System.out.println("Rotated Array front to back" + Arrays.toString(arr1));
    }

    // {1, 2, 3, 4, 5, 6, 7} --> {7, 1, 2, 3, 4, 5, 6}
    private static void rotateArrayBackToFront(int[] arr, int k, int size) {
        // take k from end of array
        reverse(arr, 0, size - k - 1);
        reverse(arr, size - k, size - 1);
        reverse(arr, 0, size - 1);
    }

    // {1, 2, 3, 4, 5, 6, 7} --> {2, 3, 4, 5, 6, 7, 1}
    private static void rotateArrayFrontToBack(int[] arr, int k, int size) {
        // take k from start of array
        reverse(arr, 0, k - 1);
        reverse(arr, k, size - 1);
        reverse(arr, 0, size - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}
/* Step 1 - Rotate first (k-1) elements of the array (since array starts from 0)
 * Step 2 - Rotate from k to end of array
 * Step 3 - Rotate the complete array
 * */
