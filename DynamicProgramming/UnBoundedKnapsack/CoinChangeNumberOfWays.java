package DynamicProgramming.UnBoundedKnapsack;

public class CoinChangeNumberOfWays {
    public static void main(String[] args) {
        int[] coin = {1,2,3};
        int sum = 5;
        // find the maximum number of ways by which the given
        // sum can be achieved

        int res = getNumberOfWays(coin, sum, coin.length);
        System.out.println("Number of ways = "+res);
    }

    private static int getNumberOfWays(int[] coin, int sum, int n) {
        int[][] t = new int[n+1][sum+1];

        // think - for i==0, coins=0 and to make sum=0,1,2,3... , how many ways are there.
        // for j==0, coins=0,1,2.. , and to make sum 0, how many ways are there.
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
                if (coin[i-1] <= j){
                    t[i][j] = t[i][j-coin[i-1]] + t[i-1][j];
                    // j - coin[i-1] because if a coin is selected, then the sum value reduces by
                    // that much value.
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][sum];
    }
}
