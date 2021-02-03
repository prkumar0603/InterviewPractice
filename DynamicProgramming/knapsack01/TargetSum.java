package DynamicProgramming.Knapsack01;

public class TargetSum {
    public static void main(String[] args) {
        int arr[] = {1,1,2,3};
        int sum = 1;
        // given array and sum value. Assign + / - sign to each value of the array such that sum of
        // array is equal to given value and return count of such combination.

        // question similar to count number of subset with given difference.
        /* eg. - {+1, -1, -2, +3} = {+1, +3} + {-1, -2} => {1+3} - {1+2}
        => s1 = (diff + sum)/2;
        */

        int res = getCountOfTarget(arr, sum, arr.length);
        System.out.println(res);
    }

    private static int getCountOfTarget(int[] arr, int sum, int n) {
        int sum1 = 0;
        for (int i:arr)
            sum1 += i;

        int subset1sum = (sum + sum1)/2;
        int count = getSubset1SumCount(arr, subset1sum, n);
        return count;
    }

    private static int getSubset1SumCount(int[] arr, int sum, int n) {
        int[][] t = new int[n+1][sum+1];

        for (int i=0;i<n+1;i++){
            for (int j=0;j<sum+1;j++){
                if (i==0)
                    t[i][j] = 0;
                if (j==0)
                    t[i][j] = 1;
            }
        }

        for (int i=1;i<n+1;i++){
            for (int j=1;j<sum+1;j++){
                if (arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][sum];
    }
}
