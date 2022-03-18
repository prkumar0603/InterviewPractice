package Array;

import java.util.Arrays;

/*Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
You can assume that you can always reach the last index.
Example 1:
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:
Input: nums = [2,3,0,1,4]
Output: 2
Constraints:
1 <= nums.length <= 104
0 <= nums[i] <= 1000
*/

public class MinStepsToReachEndOfArray {
    public static void main(String[] args) {
        // int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        // int[] arr = {2, 1, 3, 2, 3, 4, 5, 1, 2, 8};
        int[] arr = {3,3,0,2,1,2,4,2,0,0};
        int n = arr.length;

        Integer[] dp = new Integer[n];
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            int steps = arr[i];

            int min = Integer.MAX_VALUE;
            for (int j = 1; j<=steps && (i+j)<n; j++) {      // j<steps and adding the steps should not get out of array
                if (dp[i + j] != null && dp[i + j] < min)
                    min = dp[i + j];
            }

            // if we don't find any minimum, then min will be Integer.MAX_VALUE
            if (min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
            }
        }

        System.out.println("min steps : "+ dp[0]);

    }
}

/*Approach - Start from the right. Since we are at last index, so reaching last index will be 0.
    Then we check, for each element if we are able to reach the last index from that element.
*/

// Another approach - 
/*        int[] minimum_jump_array = new int[n];
        int[] jump_path_array = new int[n];
        for (int i=0;i<n;i++){
            minimum_jump_array[i] = Integer.MAX_VALUE;
            jump_path_array[i] = Integer.MAX_VALUE;
        }

        minimum_jump_array[0] = 0;
        jump_path_array[0] = 0;
        for (int i=1;i<n;i++){
            for (int j=0;j<i;j++){
                if (i <= j + arr[j]){
                    minimum_jump_array[i] = Math.min(minimum_jump_array[i], minimum_jump_array[j] + 1);
                    jump_path_array[i] = Math.min(jump_path_array[i], j);
                }
            }
        }
        System.out.println("minimum_jump_array : "+Arrays.toString(minimum_jump_array));
        System.out.println("jump_path_array : "+Arrays.toString(jump_path_array));
*/
