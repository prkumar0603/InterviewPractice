package DynamicProgramming.LongestCommonSubsequence;

import java.util.Arrays;

public class minInsertDeleteForAToB {
    public static void main(String[] args) {
        String s1 = "heap";
        String s2 = "pea";
        /*count the minimum number of insertions and deletions to make string s1
        * equal to string s2.*/

        int[] res = getMinInsertdelete(s1, s2);
        System.out.println("#deletion ="+res[0]+" \n#addition ="+res[1]);
    }

    private static int[] getMinInsertdelete(String s1, String s2) {
        // first get the length of lcs
        int lcsLen = getLcsLength(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
        int deletions = s1.length() - lcsLen;
        int addition = s2.length() - lcsLen;
        return new int[]{deletions, addition};
    }

    private static int getLcsLength(char[] X, char[] Y, int m, int n) {
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
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }

        return t[m][n];
    }
}
/*Approach - heap -> ea -> pea
first convert s1 to lcs then convert lcs to the s2.
#deletions = length of s1 - length of lcs
#insertions = length of s2 - length of lcs
*/