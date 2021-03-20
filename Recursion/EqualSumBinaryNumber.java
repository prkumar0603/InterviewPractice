package recursion;
/* Given a number n, we need to print all n-digit binary numbers with equal sum in left and right halves.
If n is odd, then mid element can be either 0 or 1.
Examples:
Input  : n = 4
Output : 0000 0101 0110 1001 1010 1111
Input : n = 5
Output : 00000 00100 01001 01101 01010 01110 10001 10101 10010 10110 11011 11111
*/
public class EqualSumBinaryNumber {
    public static void main(String[] args) {
        int n = 4;
        equal(n, "", "", 0);
    }

    // n is number of bits remaining to be filled
    // di is current difference between sums of left an right half
    // left and right are current half sunatring
    private static void equal(int n, String left, String right, int di) {
        // 2 base cases
        // if there are no more characters to add (n is 0)
        if (n==0){
            // difference is 0
            if (di == 0){
                System.out.print(left+ right + " ");
            }
        }
        // if string length is odd
        if (n==1){
            // difference is 0. adding the middle digit and printing
            if (di == 0){
                System.out.print(left+"0"+right+" ");
                System.out.print(left+"1"+right+" ");
            }
        }
        // adding digits one by one
        if (2 * Math.abs(di) <= n){
            equal(n-2, left+"0", right+"0", di);
            equal(n-2, left+"0", right+"1",di-1);
            equal(n-2, left+"1", right+"0",di+1);
            equal(n-2, left+"1", right+"1", di);
        }
    }
}
