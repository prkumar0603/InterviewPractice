package recursion;
/* Given an array, write functions to find the minimum and maximum elements in it.
*/
public class MinOrMaxOfAnArray {
    public static void main(String[] args) {
        int[] arr = {12, 1234, 45, 67, 1};
        int ans = arr[0];
        //int res = solve(arr, arr.length, ans);
        int max = getMax(arr, 0, arr.length);
        int min = getMin(arr, 0, arr.length);
        System.out.println(max+" "+min);
    }

    private static int getMax(int[] arr, int i, int n) {
        if (n==1)
            return arr[i];

        return Math.max(arr[i], getMax(arr, i+1, n-1));
    }
    private static int getMin(int[] arr, int i, int n) {
        // return Arrays.stream(arr).min().getAsInt();

        return (n==1) ? arr[i] : Math.min(arr[i], getMin(arr, i+1, n-1));
    }

//    private static int solve(int[] arr, int n, int ans) {
//        if (n==1)
//            return arr[0];
//
//        ans = solve(arr, n-1, ans);
//        if (arr[n-1] > ans){
//            ans = arr[n-1];
//        }
//        return ans;
//    }
}
/* library function to get max and min - 
    Arrays.stream(arr).max().getAsInt();
    Arrays.stream(arr).min().getAsInt();
*/
