package Searching;

/* Given an array of integers and another number. Find all the unique quadruple from the given
array that sums up to the given number.
Example 1:
Input:
N = 5, K = 3
A[] = {0,0,2,1,1}
Output: 0 0 1 2 $
Explanation: Sum of 0, 0, 1, 2 is equal
to K.

Example 2:
Input:
N = 7, K = 23
A[] = {10,2,3,4,5,7,8}
Output: 2 3 8 10 $2 4 7 10 $3 5 7 8 $
Explanation: Sum of 2, 3, 8, 10 = 23,
sum of 2, 4, 7, 10 = 23 and sum of 3,
5, 7, 8 = 23.
Your Task:
You don't need to read input or print anything. Your task is to complete the function fourSum()
which takes the array arr[] and the integer k as its input and returns an array containing all the
quadruples in a lexicographical manner. Also note that all the quadruples should be internally sorted,
ie for any quadruple [q1, q2, q3, q4] the following should follow: q1 <= q2 <= q3 <= q4.
(In the output each quadruple is separate by $. The printing is done by the driver's code)

Expected Time Complexity: O(N3).
Expected Auxiliary Space: O(N2).
*/

import java.util.ArrayList;
import java.util.HashMap;

public class FindFourSumNumbers {
    public static void main(String[] args) {
        int[] nums = {10,20,30,40,1,2};//{0,0,2,1,1};
        int k = 91; //3
        int n = 5;      // length of array
        //fourSum(nums, k, n);

        // solve(nums, k, n);

        solveUsingHashMap(nums, k, n);
    }

    /* Store sum of all pairs in hash table.
    * traverse all pairs and search for (X - (current pair sum)) in hash table
    * if pair is found with required sum, make sure all elements are distinct and array
    * element is not considered more than once. */
    private static void solveUsingHashMap(int[] nums, int X, int n) {
        HashMap<Integer, pair> map = new HashMap<>();
        for (int i=0;i<n-1;i++)
            for (int j=i+1;j<n;j++)
                map.put(nums[i] + nums[j], new pair(i, j));


        for (int i=0;i<n-1;i++){
            for (int j=i+1;j<n;j++){
                int sum = nums[i] + nums[j];

                if (map.containsKey(X - sum)){
                    pair p = map.get(X - sum);
                    if (p.first != i && p.first != j &&
                        p.second != i && p.second != j){
                        System.out.println(nums[i]+ " " +nums[j] +" "
                                +nums[p.first] + " "+nums[p.second]);
                        return;
                    }
                }

            }
        }

    }

    static class pair{
        int first;
        int second;
        pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    // fix first two elements and search the rest two elements. Order (n3)
    private static void solve(int[] arr, int k, int n) {
        for (int i=0;i<n-3;i++){
            for (int j=i+1;j<n-2;j++){

                // after fixing first two elements, search rest two
                int low = j+1;
                int high = n-1;
                while(low<high) {
                    if (arr[i] + arr[j] + arr[low] + arr[high] == k){
                        System.out.println(arr[i]+ " " +arr[j] +" " +arr[low] + " "+arr[high]);
                        low++;
                        high--;
                    }
                    else if(arr[i] + arr[j] + arr[low] + arr[high] < k){
                        low++;
                    }
                    else
                        high--;
                }
            }
        }
    }


    // solved using 4 loops (n4)
    private static void fourSum(int[] arr, int X, int n) {

        for (int i=0;i<n-3;i++){
            for (int j=i+1;j<n-2;j++){
                for (int k=j+1;k<n-1;k++){
                    for (int l=k+1;l<n;l++){
                        if (arr[i]+ arr[j] + arr[k] + arr[l] == X){
                            System.out.println(arr[i]+ " " +arr[j] +" " +arr[k] + " "+arr[l]);
                            break;  // since it was printing twice, so used break
                        }
                    }
                }
            }
        }
    }


}