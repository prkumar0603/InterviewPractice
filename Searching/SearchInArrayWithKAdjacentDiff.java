package Searching;

/* Searching in an array where adjacent differ by at most k
   A step array is an array of integers where each element has a difference of at most k with its
   neighbor. Given a key x, we need to find the index value of x if multiple-element exist to return
   the first occurrence of the key.
   Examples:
   Input : arr[] = {4, 5, 6, 7, 6}
        k = 1
        x = 6
        Output : 2
        The first index of 6 is 2.

        Input : arr[] = {20, 40, 50, 70, 70, 60}
        k = 20
        x = 60
        Output : 5
        The index of 60 is 5
*/

public class SearchInArrayWithKAdjacentDiff {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,6};
        int k = 1;      // difference between adjacent
        int x = 6;      // search element
        int res = solve(nums, nums.length, k, x);
        System.out.println(res);
    }

    private static int solve(int[] arr, int n, int k, int x) {
        if (arr.length == 0)
            return -1;

        int i =0;
        while(i < n){
            if (arr[i] == x)
                return i;

            i = i + Math.max(1, Math.abs(arr[i] - x) / k);
        }
        return -1;
    }

}
/*Approach - here we can use the fact that each element differs by 1. so instead of searching every element,
  jump to element abs(arr[i] - x) / k
*/