package DynamicProgramming.LongestCommonSubsequence;

public class printSCSuperSeq {
    public static void main(String[] args) {
        String s1 = "abcdaf";
        String s2 = "acbcf";
        String res = printSCS(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
        System.out.println(res);
    }

    private static String printSCS(char[] X, char[] Y, int m, int n) {
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
                    t[i][j] = 1+ t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }

        int row=m;
        int col =n;
        StringBuilder sb = new StringBuilder();
        while(row>0 && col>0){      // why we use && not ||. and means if any one string is empty.
            if (X[row-1] == Y[col-1]){
                sb.append(X[row-1]);
                row--;
                col--;
            }
            else if (t[row-1][col] > t[row][col-1]){    // i-1,j moves one block up
                sb.append(X[row-1]);
                row--;
            }else{                      // i, j-1 moves one block left
                sb.append(Y[col-1]);
                col--;
            }
        }

        // to print the rest part of string.
        while(row>0){
            sb.append(X[row-1]);
            row--;
        }
        while(col>0){
            sb.append(Y[col-1]);
            col--;
        }

        String res = sb.reverse().toString();
        return res;
    }
}
