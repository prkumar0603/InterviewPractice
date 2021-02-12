package DynamicProgramming.LongestCommonSubsequence;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "agbcba";
        // get the longest palindromic subsequence of the string.
        // get all the subsequences, make a subet with palindromic subsequences thne get the longest.

        int res = getLPS(s);
        System.out.println("Longest palindromic Subsequence = "+res);
    }

    private static int getLPS(String s) {
        char[] rev = reverse(s.toCharArray());
        //System.out.println("reverse = "+ Arrays.toString(rev));
        int lcsLen = getLCSLen(s.toCharArray(), rev, s.length(), rev.length);
        return lcsLen;
    }

    private static int getLCSLen(char[] X, char[] Y, int m, int n) {
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
                }
                else{
                    t[i][j] = Math.max(t[i-1][j] , t[i][j-1]);
                }
            }
        }

        return t[m][n];
    }

    private static char[] reverse(char[] ch) {
        int i=0;
        int j=ch.length-1;
        while(i<j){
            char x = ch[i];
            ch[i++] = ch[j];
            ch[j--] = x;
        }
        return ch;
    }
}
