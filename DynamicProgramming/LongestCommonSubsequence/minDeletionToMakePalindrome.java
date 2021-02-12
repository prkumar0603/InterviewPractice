package DynamicProgramming.LongestCommonSubsequence;

import java.util.Arrays;

public class minDeletionToMakePalindrome {
    public static void main(String[] args) {
        String s = "geeksforgeeks";

        int res = getMinimumDeletion(s);
        System.out.println("No. of deletions = "+ res);
    }

    private static int getMinimumDeletion(String s) {
        char[] rev = getReverse(s.toCharArray());
        int lcslen = getLCSLength(s.toCharArray(), rev, s.length(), s.length());
        return (s.length() - lcslen);
    }

    private static int getLCSLength(char[] X, char[] Y, int m, int n) {
        int[][] t = new int[m+1][n+1];

        for (int i=0;i<m+1;i++){
            for (int j=0;j<n+1;j++){
                if (i==0 || j==0)
                    t[i][j] = 0;
            }
        }

        for (int i=1;i<m+1;i++){
            for (int j=1;j<n+1;j++){
                if (X[i-1] == Y[j-1]){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }

        return t[m][n];
    }

    private static char[] getReverse(char[] X) {
        int i=0;
        int j=X.length-1;
        while(i<j){
            char x = X[i];
            X[i++] = X[j];
            X[j--] = x;
        }
        return  X;
    }
}
