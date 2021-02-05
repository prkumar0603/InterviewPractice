package DynamicProgramming.UnBoundedKnapsack;

import java.util.Arrays;

public class CoinChangeMinimumNumberOfCoins {
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int sum = 5;
        // find the minimum number of coins to get the desired sum.

        int res = getMinNumberOfCoins(coins, sum, coins.length);
        System.out.println("Minimum Number Of coins = "+res);
    }

    private static int getMinNumberOfCoins(int[] coins, int sum, int n) {
        int[][] t = new int[n+1][sum+1];

        // initializing i==0 and j==0 row;
        // slight change in concept. (chnage first checking j==0 then i==0)
        for (int i=0;i<n+1;i++){
            for (int j=0;j<sum+1;j++){
                if (j==0)
                    t[i][j] = 0;
                if (i==0)
                    t[i][j] = Integer.MAX_VALUE - 1;
            }
        }

        // in i=0 we have fill infinity. so need to fill one other row, because
        // add/subtract to infinity result infinity.
        for (int j=1;j<sum+1;j++){
            if (j % coins[0] == 0)
                t[1][j] = j / coins[0];
            else
                t[1][j] = Integer.MAX_VALUE - 1;
        }

        for (int i=2;i<n+1;i++){
            for (int j=1;j<sum+1;j++){
                if (coins[i-1] <= j){
                    t[i][j] = Math.min(1 + t[i][j-coins[i-1]], t[i-1][j]);
                    // when selecting add 1 in place of value array as earlier
                    // we have written Max_Value -1. so to balance.
                }
                else
                    t[i][j] = t[i-1][j];
            }
        }

        return t[n][sum];
    }
}
