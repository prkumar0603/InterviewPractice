package Array;

import java.util.Arrays;

/* Given heights of n towers and a value k. We need to either increase or decrease the height of every tower by k (only once) where k > 0. 
The task is to minimize the difference between the heights of the longest and the shortest tower after modifications and output this difference.
Examples : 
Input  : arr[] = {1, 15, 10}, k = 6
Output :  Maximum difference is 5.
Explanation : We change 1 to 7, 15 to 9 and 10 to 4. Maximum difference is 5 (between 4 and 9). We can't get a lower difference.
Input : arr[] = {4, 6} 
        k = 10
Output : Maximum difference is 2
arr[] = {14, 16} OR {-6, -4}

Input : arr[] = {6, 10} 
        k = 3
Output : Maximum difference is 2
arr[] = {9, 7} 

Input : arr[] = {1, 10, 14, 14, 14, 15}
        k = 6 
Output: Maximum difference is 5
arr[] = {7, 4, 8, 8, 8, 9} 

Input : arr[] = {1, 2, 3}
        k = 2 
Output: Maximum difference is 2
arr[] = {3, 4, 5} 
*/

public class MinimizeMaxDiffBetweenHeights {
    public static void main(String[] args) {
        int[] arr = {1, 5, 15, 10};
        int k = 3;
        int n = arr.length;

        /* One approach ->
        if (arr[i] - k > 0)-> arr[i] -= k else (arr[i] += k)
        and find the max and min of the modified array.
        But this approach fails for array{4,6} and k = 3.
        */

        // Q: Minimize the maximum difference between heights. First find the maximum difference between heights
        Arrays.sort(arr);
        int ans = arr[n - 1] - arr[0];

        for (int i = 0; i < n - 1; i++) {
            int a = arr[i], b = arr[i + 1];

            int low = Math.min(arr[0] + k, b - k);
            int high = Math.max(arr[n - 1] - k, a + k);

            ans = Math.min(ans, high - low);
        }
        System.out.println("Answer : " + ans);
    }
}

/*solution - https://www.youtube.com/watch?v=tSLiZAQG9NM
  Q - Minimize the maximum difference between heights
  maximum difference between heights : sort the array and max - min
  Two observations -
  1) To minimize the difference, add k to the smallest and subtract k from largest.
    [a, c, d, b]  :  a+k , b-k     => maximize the first and minimize the 2nd element
  2) The minimum can be found between consecutive pair only.
  consider : (c, d) pair from the array.
  To find difference between maximum and minimum element , make c the max of the array and d min of the array.
  Initially max is b, and we are doing (b-k). To maximize c, we will do : (c+k)
  Math.max(b-k, c+k)
  Initially min is a, and we are doing (a+k). to minimize d, we will do : (d-k)
  Math.min(a+k, d-k)
*/
