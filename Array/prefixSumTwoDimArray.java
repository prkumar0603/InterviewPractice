import java.util.Arrays;
/*Given a matrix (or 2D array) a[][] of integers, find prefix sum matrix for it.
Let prefix sum matrix be psa[][]. The value of psa[i][j] contains sum of all values which are
above it or on left of it.
The general formula:
    psa[i][j] = psa[i-1][j] + psa[i][j-1] -
                psa[i-1][j-1] + a[i][j]

    Corner Cases (First row and first column)
    If i = 0 and j = 0
       psa[i][j] = a[i][j]
    If i = 0 and j > 0
       psa[i][j] = psa[i][j-1] + a[i][j]
    If i > 0 and j = 0
       psa[i][j] = psa[i-1][j] + a[i][j]
*/
public class prefixSumTwoDimArray {

    public static void main(String[] args) {
        int[][] t = {{10,20,30},{5,10,20},{2,4,6}};
        System.out.println("Initial Array = "+Arrays.deepToString(t));

        int row = t.length;
        int col = t[0].length;

        int[][] psa = new int[row][col];

        psa[0][0] = t[0][0];
        //filling first row
        for (int i=1;i<col;i++){
            psa[0][i] = psa[0][i-1] + t[0][i];
        }
        //filling first column
        for (int i=1;i<row;i++){
            psa[i][0] = psa[i-1][0] + t[i][0];
        }

        for (int i=1;i<row;i++){
            for (int j=1;j<col;j++){
                psa[i][j] = psa[i-1][j] + psa[i][j-1] - psa[i-1][j-1] + t[i][j];
            }
        }
        System.out.println("Prefix sum array = "+Arrays.deepToString(psa));
    }
}
