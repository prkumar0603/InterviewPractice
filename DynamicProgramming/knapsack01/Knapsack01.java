package DynamicProgramming.Knapsack01;

public class Knapsack01 {
    public static void main(String[] args) {
        int wt[] = {1,3,4,5};
        int val[] = {1,4,5,7};
        int w = 7;

//        int profit = getOptimalProfit(wt,val,w,wt.length);
//        System.out.println(profit);

        int profit1 = getOptimalProfitByDp(wt,val,w,wt.length);
        System.out.println(profit1);
    }

    private static int getOptimalProfitByDp(int[] wt, int[] val, int w, int n) {
        int[][] t = new int[n+1][w+1];

        for (int i=0;i<n+1;i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }

        for (int i=1;i<n+1;i++){
            for (int j=1;j<w+1;j++){
                if (wt[i-1] <= j){
                    t[i][j] = Math.max(val[i-1]+ t[i-1][j-wt[i-1]],
                            t[i-1][j]);
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        //System.out.println(Arrays.deepToString(t));
        return t[n][w];
    }

    private static int getOptimalProfit(int[] wt, int[] val, int w, int n) {
        if(n==0 || w==0)
            return 0;

        if (wt[n-1] <= w)
            return Math.max( val[n-1] + getOptimalProfit(wt,val, w-wt[n-1],n-1),
                   getOptimalProfit(wt, val, w, n-1) );

        else
            return getOptimalProfit(wt,val,w,n-1);
    }
}
