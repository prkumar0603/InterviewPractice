package DynamicProgramming.LongestCommonSubsequence;

public class PrintLCS {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        String res = getLCSprint(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
        System.out.println(res);
    }


    private static String getLCSprint(char[] X, char[] Y, int m, int n) {
        int[][] t = new int[m+1][n+1];

        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++)
                if (i==0 || j==0)
                    t[i][j] = 0;
        }

        for (int i=1;i<m+1;i++){
            for (int j=1;j<n+1;j++){
                if (X[i-1] == Y[j-1])
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i-1][j] , t[i][j-1]);
            }
        }

        StringBuilder res= new StringBuilder();
        int i=m;
        int j=n;
        while(i>0 && j>0){      // why use && not ||. and means if any one string is empty.
            if (X[i-1] == Y[j-1]){
                res.append(X[i-1]);
                i -=1;
                j -=1;
            }
            else if (t[i-1][j] > t[i][j-1]){
                i--;
            }
            else
                j--;
        }

        return res.reverse().toString();
    }
}
