package recursion;

import java.util.Vector;
/* Given an array of size n, generate and print all possible combinations of r elements in array.
For example, if input array is {1, 2, 3, 4} and r is 2, then output should be {1, 2}, {1, 3},
{1, 4}, {2, 3}, {2, 4} and {3, 4}.
*/
public class PossibleCombinationOfRElements {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int r = 2;
        solve(arr, r);
    }

    private static void solve(int[] arr, int r) {
        Vector<Integer> vector = new Vector<>();
        printAllCombination(arr, r, vector, 0);
    }

    private static void printAllCombination(int[] arr, int r, Vector<Integer> vector, int start) {
        // base case. when size is equal to limit(r)
        if (vector.size() >= r){
            System.out.print(vector + " ");
            return;
        }
        for (int i=start; i<arr.length; i++){
            vector.add(arr[i]);
            printAllCombination(arr, r, vector, i+1);
            vector.remove(vector.size() - 1);
        }
    }
}
