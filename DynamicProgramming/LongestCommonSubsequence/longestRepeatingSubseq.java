package DynamicProgramming.LongestCommonSubsequence;

public class longestRepeatingSubseq {
    public static void main(String[] args) {
        String s = "AABEBCDD";
        // find the length of longest subsequence that is repeating itself
        // Eg. - ABD is repeating

        int res = getLRS(s);
        System.out.println("Longest repeating subseq = "+res);
    }

    private static int getLRS(String s) {
        int lcsLen = getLCS(s.toCharArray(), s.toCharArray(), s.length(),s.length());
        return lcsLen;
    }

    private static int getLCS(char[] X, char[] Y, int m, int n) {
        int[][] t = new int[m+1][n+1];

        for (int i=0;i<m+1;i++){
            for (int j=0;j<n+1;j++){
                if (i==0 || j==0)
                    t[i][j] = 0;
            }
        }

        for (int i=1;i<m+1;i++){
            for (int j=1;j<n+1;j++){
                if (X[i-1] == Y[j-1] && i!=j){  //slight change in code
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[m][n];
    }
}
/*Approch - AABEBCDD and AABEBCDD
            01234567     01234567
  one susequence is ABD and other subsequence is ABD
                    026                          147
  their indexes are different. so in this case we will find lcs
   with condition (i!=j)
*/