package DynamicProgramming.LongestCommonSubsequence;

public class SCSuperSeq {
    public static void main(String[] args) {
        String s1 = "geek";
        String s2 = "eke";

        int lcs = geLCSLength(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
        int total_String_length = s1.length() + s2.length() ;
        int scsuperseq = total_String_length - lcs;
        System.out.println("Shortest common super sequence length = "+scsuperseq);

    }

    private static int geLCSLength(char[] X, char[] Y, int m, int n) {
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
                    t[i][j] = Math.max(t[i-1][j] , t[i][j-1]);
                }
            }
        }

        return t[m][n];
    }
}
