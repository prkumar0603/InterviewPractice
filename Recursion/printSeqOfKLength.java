package recursion;

import java.util.Vector;
/* Given two positive integers n and k, print all increasing sequences of length k such that the
elements in every sequence are from first n natural numbers.
Examples:
Input: k = 2, n = 3
Output: 1 2
        1 3
        2 3

Input: k = 5, n = 5
Output: 1 2 3 4 5

Input: k = 3, n = 5
Output: 1 2 3
        1 2 4
        1 2 5
        1 3 4
        1 3 5
        1 4 5
        2 3 4
        2 3 5
        2 4 5
        3 4 5
*/
public class printSeqOfKLength {
    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        solve(n, k);
    }

    private static void solve(int n, int k) {
        Vector<Integer> vector = new Vector<>();
        printAllCombination(n, k, vector, 1);
    }

    private static void printAllCombination(int n, int k, Vector<Integer> vector, int start) {
        if (vector.size() == k){
            System.out.print(vector + " ");
            return;
        }
        for (int i= start; i<=n; i++){
            vector.add(i);
            printAllCombination(n, k, vector, i+1);
            vector.remove(vector.size() - 1);
        }
    }
}
