package DynamicProgramming.LongestCommonSubsequence;

public class minInsertionToMakePalindrome {
    public static void main(String[] args) {
        String s1 = "aebcbda";
        
        int res = getMinInsertion(s1);
        System.out.println("Minimum Insertion = "+res);
    }

    private static int getMinInsertion(String s1) {
        char[] StringRev = getStringReverse(s1.toCharArray());
        int lcslength = getlcslength(s1.toCharArray(), StringRev, s1.length(), StringRev.length);

        return (s1.length() - lcslength);
    }

    private static int getlcslength(char[] X, char[] Y, int m, int n) {
        int[][] t = new int[m+1][n+1];

        for (int i=0;i<m+1;i++){
            for (int j=0;j<n+1;j++){
                if (i==0 || j==0)
                    t[i][j] = 0;
            }
        }

        for (int i=1;i<m+1;i++){
            for (int j=1;j<n+1;j++){
                if (X[i-1] == Y[j-1])
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
            }
        }

        return t[m][n];
    }

    private static char[] getStringReverse(char[] X) {
        int i=0;
        int j=X.length-1;

        while(i<=j){
            char x = X[i];
            X[i++] = X[j];
            X[j--] = x;
        }
        return X;
    }
}
