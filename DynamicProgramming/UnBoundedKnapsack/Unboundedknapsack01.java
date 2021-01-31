package DynamicProgramming.UnBoundedKnapsack;

public class Unboundedknapsack01 {
    public static void main(String[] args) {
        int wt[] = {1,3,4,5};
        int val[] = {1,4,5,7};
        int w = 7;

        int res = getMaxProfit(wt, val, w, wt.length);
        System.out.println("Maximum Profit for Unbounded Knapsack = "+res);
    }

    private static int getMaxProfit(int[] wt, int[] val, int w, int n) {
        int[][] t = new int[n+1][w+1];

        for (int i=0;i<n+1;i++){
            for (int j=0;j<w+1;j++){
                if (i==0 || j==0)
                    t[i][j] = 0;
            }
        }

        for (int i=1;i<n+1;i++){
            for (int j=1;j<w+1;j++){
                if (wt[i-1] <= j){
                    t[i][j] = Math.max(val[i-1] + t[i][j- wt[i-1]], t[i-1][j]);
                    //                            inplace of i-1, just i for unbounded knapsack
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][w];
    }
}
