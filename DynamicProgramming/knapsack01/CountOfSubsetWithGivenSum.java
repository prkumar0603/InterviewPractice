package DynamicProgramming.Knapsack01;

public class CountOfSubsetWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {2,3,5,6,8,10};
        int sum = 10;
        // given an array and sum.
        // count the number of subsets of this array having sum equal to given value.

        int res = getSubsetSumCount(arr, sum, arr.length);
        System.out.println(res);
    }

    private static int getSubsetSumCount(int[] arr, int sum, int n) {
        int t[][] = new int[n+1][sum+1];

        for (int i=0;i<n+1;i++){
            for (int j=0;j<sum+1;j++){
                if (i==0)
                    t[i][j] = 0;
                if (j==0)
                    t[i][j] = 1;// initialize properly, otherwise wrong. in 1st row(i==0) all 0 then in 1st column(j==0) all 1.
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
