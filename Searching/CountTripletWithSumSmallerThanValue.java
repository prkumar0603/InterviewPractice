package Searching;

import java.util.Arrays;
/*
Given an array arr[] of distinct integers of size N and a sum value X, the task is to find count of triplets with the sum
smaller than the given sum value X.
Example 1:
Input: N = 6, X = 2
arr[] = {-2, 0, 1, 3}
Output:  2
Explanation: Below are triplets with
sum less than 2 (-2, 0, 1) and (-2, 0, 3).
Example 2:
Input: N = 5, X = 12
arr[] = {5, 1, 3, 4, 7}
Output: 4
Explanation: Below are triplets with
sum less than 12 (1, 3, 4), (1, 3, 5),
(1, 3, 7) and (1, 4, 5).
*/
public class CountTripletWithSumSmallerThanValue {
    public static void main(String[] args) {
        int n = 4; //5;
        int x = 2; //12;
        int arr[] = {-2,0,1,3}; //{5,1,3,4,7};
        // solve(n, arr, x);

        solve1(arr, n, x);

    }

    private static void solve1(int[] arr, int n, int x) {
        Arrays.sort(arr);
        int ans = 0;

        for (int i=0;i<n-2;i++){
            int low = i+1;
            int high = n-1;

            while(low < high){
                int sum = arr[i] + arr[low] + arr[high];
                if ( sum >= x) {
                    high--;
                }
                else {
                    ans += (high - low);
                    low ++;
                }
            }
        }
        System.out.println(ans);
    }

    private static void solve(int n, int[] arr, int x) {
        for (int i=0;i<n-2;i++){
            for (int j=i+1;j<n-1;j++){
                for (int k=j+1;k<n;k++){
                    if (arr[i] + arr[j] + arr[k] < x)
                        System.out.println(arr[i] +" "+ arr[j] + " "+arr[k]);
                }
            }
        }

    }
}
