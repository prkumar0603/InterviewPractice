package DynamicProgramming.LongestCommonSubsequence;

public class SeqPatternMatching {
    public static void main(String[] args) {
        String s1 = "AXY";
        String s2 = "ADXCPY";
        // check is s1 is a subsequence of s2.

         boolean res = isSeqPatternMatching(s1, s2);
        System.out.println(res);
    }

    private static boolean isSeqPatternMatching(String s1, String s2) {
        int lcslength = getLcsLength(s1.toCharArray(),s2.toCharArray(),s1.length(),s2.length());
        return (s1.length() == lcslength);
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
