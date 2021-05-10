package Searching;

import java.util.ArrayList;

/* Given a sorted array arr containing n elements with possibly duplicate elements,
the task is to find indexes of first and last occurrences of an element x in the given array.
Example 1:
Input:
n=9, x=5
arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 }
Output:  2 5
Explanation: First occurrence of 5 is at index 2 and last
             occurrence of 5 is at index 5.
Example 2:
Input:
n=9, x=7
arr[] = { 1, 3, 5, 5, 5, 5, 7, 123, 125 }
Output:  6 6
Your Task:
You just need to complete the function find() that takes array arr, integer n and integer x as parameters and returns the required answer.
Note: If the number x is not found in the array just return both index as -1.
Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1).
Constraints:
1 ≤ N ≤ 107
*/
public class FirstAndLastOccurence {
    public static void main(String[] args) {
        int arr[] = {1};//, 3, 5, 5, 5, 5, 7, 123, 125};
        int x = 7;
        ArrayList<Long> res = find(arr, arr.length, x);
        System.out.println(res);
    }

    private static ArrayList<Long> find(int[] arr, int n, int x) {
        ArrayList<Long> res = new ArrayList<>();

        long first=0, last=n-1;
        boolean flag = false;
        for (int i=0;i<n;i++){
            if (arr[i] == x && !flag) {
                first = i;
                flag = true;
            }

            if (arr[i] > x){        // since its sorted.
                last = i-1;
                break;
            }
        }
        if (flag){
            res.add(first);
            res.add(last);
        }
        else{
            res.add((long) -1);
            res.add((long) -1);
        }
        return res;
    }
}
// sorted array means we can use the property of element greater or less than