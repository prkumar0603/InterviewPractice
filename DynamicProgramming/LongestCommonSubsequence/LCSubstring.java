package DynamicProgramming.LongestCommonSubsequence;

import java.util.Arrays;

public class LCSubstring {
    public static void main(String[] args) {
        String a = "abcde";
        String b = "ababcde";

        int res = getLCSubstring(a.toCharArray(), b.toCharArray(), a.length(), b.length());
        System.out.println("Substring length "+res);
    }

    private static int getLCSubstring(char[] X, char[] Y, int m, int n) {
        int[][] t = new int[m+1][n+1];
        int result =0;

        for (int i=0;i<m+1;i++){
            for (int j=0;j<n+1;j++)
                if (i==0 || j==0)
                    t[i][j] = 0;
        }

        for (int i=1;i<m+1;i++){
            for (int j=1;j<n+1;j++){
                if (X[i-1] == Y[j-1]) {
                    t[i][j] = t[i - 1][j - 1] + 1;
                    result = Integer.max(result, t[i][j]);  // we are taking max as substring can
                }                                            // exist anywhere between the string.
                else
                    t[i][j] = 0;
            }
        }

        return result;
    }

}
