package Searching;

import java.util.Arrays;

/* Given an unsorted array Arr of size N of positive integers. One number 'A' from set {1, 2, …N} is missing and one number 'B'
occurs twice in array. Find these two numbers.
Example 1:
Input:
N = 2
Arr[] = {2, 2}
Output: 2 1
Explanation: Repeating number is 2 and
smallest positive missing number is 1.
Example 2:
Input:
N = 3
Arr[] = {1, 3, 3}
Output: 3 2
Explanation: Repeating number is 3 and
smallest positive missing number is 2.
Your Task:
Your task is to complete the function findTwoElement() which takes the array of
integers arr and n as parameters and returns an array of integers of size 2 denoting the answer ( The first index contains B and
second index contains A.)
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105
1 ≤ Arr[i] ≤ N
*/
public class FindMissingAndRepeating {
    public static void main(String[] args) {
        int[] arr= {1,3,3};
        int n = 3;
        int[] res = solve(arr, n);
        System.out.println(Arrays.toString(res));

        // repeating(arr, n);
    }

    /*While traversing, use the absolute value of every element as an index and make the value at this index as negative
    to mark it visited. If something is already marked negative then this is the repeating element. To find missing,
    traverse the array again and look for a positive value.*/
    private static int[] solve(int[] arr, int N) {
        if (arr.length == 0)
            return new int[]{};

        int repeating = 0, missing = 0;
        for (int i=0;i<N;i++){
            int abs_val = Math.abs(arr[i]);
            if (arr[abs_val - 1] > 0)
                arr[abs_val - 1] = -arr[abs_val - 1];       // mark as visited by making negative
            else
                repeating = abs_val;   // repeating element
        }

        for (int i=0;i<N;i++){
            if (arr[i] > 0)         // if positive then missing element
                missing = i+1;       // missing element
        }

        return new int[]{missing, repeating};
    }

    // same as before. change in finding missing
    private static void repeating(int[] arr, int n) {
        int missing = 0, repeating=0;

        for (int i=0;i<n;i++){
            int abs_value = Math.abs(arr[i]);
            // missing = missing ^ i+1 ^ abs_value;

            if (arr[abs_value - 1] > 0)
                arr[abs_value - 1] = -arr[abs_value - 1];
            else
                repeating = abs_value;
        }
        missing = missing ^ repeating;

        System.out.println("missing ="+ missing + " repeating = "+ repeating);
    }
}
/* XOR of a number with itself gives 0. do xor from 1 to n and do xor of all the array elements.
put in set, if set already contains an element, then repeated.
*/