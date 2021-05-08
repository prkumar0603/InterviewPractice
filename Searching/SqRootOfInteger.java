package BinarySearch;

/* Given an integer x, find it’s square root. If x is not a perfect square, then return floor(√x).
Examples :
Input: x = 4
Output: 2
Explanation:  The square root of 4 is 2.
Input: x = 11
Output: 3
Explanation:  The square root of 11 lies in between
3 and 4 so floor of the square root is 3.
*/
public class SqRootOfInteger {
    public static void main(String[] args) {
        int x = 81;
        /*int res = solve(x);
        System.out.println(res);*/
        
        int res1 = solveUsingBS(x);
        System.out.println(res1);
    }

    private static int solveUsingBS(int x) {
        if (x==0 || x==1)
            return x;

        int low = 1;
        int high = x;

        int ans = 1;
        while(low<high){
            int mid = low + (high-low)/2;

            if (mid * mid == x)
                return mid;
            else if (mid* mid < x) {
                low = mid + 1;
                ans = mid;
            }
            else
                high = mid -1;
        }
        return ans;
    }

    /*result will be used to check with square value
     and i will store the square root of number. */
    private static int solve(int x) {
        if (x == 0 || x==1)
            return x;

        int res = 1; int i=1;
        while(res <= x){
            i++;
            res = i*i;
        }
        return i-1;
    }
}
