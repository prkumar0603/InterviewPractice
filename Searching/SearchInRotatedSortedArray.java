package Searching;

import java.util.ArrayList;

/* There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the
resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7]
might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.
Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:
Input: nums = [1], target = 0
Output: -1
Constraints:
1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104
*/
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int arr[] = {5,1,3};
        int target = 3;
        /*int res = search(arr, target);
        System.out.println(res);*/

        int res = searchImproved(arr, 0, arr.length-1, target);
        System.out.println(res);
    }

    // in one iteration
    private static int searchImproved(int[] arr, int low, int high, int target) {
        if (low > high)
            return -1;

        int mid = low + (high - low)/2;
        if (arr[mid] == target)
            return mid;

        // check if first half is sorted
        if (arr[low] <= arr[mid]){

            // if the target lies in first half
            if (target >= arr[low] && target <= arr[mid])
                return searchImproved(arr, low, mid-1, target);

            // else target lies in second half
            return searchImproved(arr, mid + 1, high, target);
        }
        // else second half is sorted
        if (target >= arr[mid] && target <= arr[high])
            return searchImproved(arr, mid+1, high, target);

        return searchImproved(arr, low, mid-1, target);
    }


    // two times calling binary search.
    private static int search(int[] arr, int target) {
        int j=0;
        for (int i=0;i<arr.length-1;i++){
            if (arr[i] > arr[i+1]){
                j = i;
                break;
            }
        }
        int x = BinarySearch(arr, 0, j, target);
        int y =-1;
        if (x == -1)
            y = BinarySearch(arr, j+1, arr.length-1, target);

        if (x != -1)
            return x;
        else
            return y;
    }

    private static int BinarySearch(int[] arr, int low, int high, int target) {
        if (arr.length==0)
            return -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if (arr[mid] == target)
                return mid;

            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid -1;
        }

        return -1;
    }

}
/* one approach - find the pivot element (next value of pivot wil be less than that element) and apply
   binary search on both parts of array.

   Better approach - find mid. check if equal to target.
         check if low to mid is sorted. if yes, check is target lies in that range and call for lower ranges.
         else call mid to high.

         if low to mid is not sorted, then mid to high is sorted. check is target lies in that range and call for lower ranges.
         else call low to mid.

*/