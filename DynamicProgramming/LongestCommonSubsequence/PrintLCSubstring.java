package DynamicProgramming.LongestCommonSubsequence;

import java.util.Arrays;

public class PrintLCSubstring {
    public static void main(String[] args) {
        String s1 = "OldSite:GeeksforGeeks.org";
        String s2 = "NewSite:GeeksQuiz.com";

        int res = getLongestCommonSubstringPrint(s1.toCharArray(), s2.toCharArray(), s1.length(),s2.length());
        System.out.println("Longest Common Substring = "+ res);
    }

    private static int getLongestCommonSubstringPrint(char[] X, char[] Y, int m, int n) {
        int[][] t = new int[m+1][n+1];
        int res = 0;
        int row = 0;
        int col = 0;

        for (int i=0;i<m+1;i++){
            for (int j=0; j<n+1;j++)
                if (i==0 || j==0)
                    t[i][j] = 0;
        }

        for (int i=1;i<m+1;i++){
            for (int j=1;j<n+1;j++){
                if (X[i-1] == Y[j-1]) {
                    t[i][j] = t[i - 1][j - 1] + 1;
                    if (res < t[i][j]){     // if result is smaller, then update with bigger one.
                        res =  t[i][j];
                        row = i;
                        col = j;
                    }

                }
                else
                    t[i][j] = 0;
            }
        }

        System.out.println(Arrays.deepToString(t));

        String result = "";
        while(t[row][col] != 0){
            result = X[row-1] + result; // y[col-1] + result;
            //--res;
            row --;
            col--;
        }
        System.out.println("String = "+ result);

        return res;
    }
}
