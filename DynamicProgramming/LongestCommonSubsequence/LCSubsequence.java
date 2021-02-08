package DynamicProgramming.LongestCommonSubsequence;

import java.util.Arrays;

public class LCSubsequence {
    static String x = "abcdgh";
    static String y = "abedfhr";

    static int[][] t = new int[x.length()+1][y.length()+1];
    public static void main(String[] args) {
        // find the length of longest common subsequence.
        // in same sequence not mandatory continuous.

//        int res = getLCSRec(x, y, x.length(), y.length());
//        System.out.println("Length of Longest common subsequence = "+res);

        //-------------------------------

        //initialize each row with -1
        // Arrays.stream(t).forEach(a -> Arrays.fill(a,-1));
        for (int[] row: t)
            Arrays.fill(row, -1);

//        System.out.println(Arrays.deepToString(t));
//        int res1 = getLCSMemoization(x, y, x.length(), y.length());
//        System.out.println(res1);

        //------------------------------------

        char[] s1 = x.toCharArray();
        char[] s2 = y.toCharArray();
        int res2 = getLCSDP(s1, s2, s1.length, s2.length);
        System.out.println("LCS Dp = "+res2);

    }


    private static int getLCSDP(char[] X, char[] Y, int m, int n) {
        int[][] t = new int[m+1][n+1];

        for (int i=0;i<m+1;i++){
            for (int j=0;j<n+1;j++)
                if (i==0 || j==0)
                    t[i][j] = 0;
        }

        for (int i=1;i<m+1;i++){
            for (int j=1;j<n+1;j++){
                if (X[i-1] == Y[j-1])
                    t[i][j] = 1+ t[i-1][j-1];

                else
                {
                    t[i][j] = Math.max(t[i-1][j] , t[i][j-1]);
                }
            }
        }
        return t[m][n];
    }


//    private static int getLCSMemoization(String x, String y, int m, int n) {
//        if(m==0 || n==0)
//            return 0;
//
//        if (t[m][n] != -1)
//            return t[m][n];
//
//        if (x.charAt(m-1) == y.charAt(n-1))
//            return t[m][n] = 1+ getLCSMemoization(x, y, m-1, n-1);
//        else
//            return t[m][n] = Math.max(getLCSMemoization(x,y,m-1,n), getLCSMemoization(x,y,m,n-1));
//
//    }

    
//    private static int getLCSRec(String x, String y, int n, int m) {
//        if (n==0 || m==0)
//        return 0;
//
//        if (x.charAt(n-1) == y.charAt(m-1))
//            return (1+ getLCSRec(x,y,n-1,m-1));
//        else
//            return Math.max(getLCSRec(x,y,n-1,m),getLCSRec(x,y,n,m-1));
//
//    }
}

/*In LCS, continuity is not important but sequence/ordering is important*/
