package DynamicProgramming.UnBoundedKnapsack;

public class RodCuttingProblem {
    public static void main(String[] args) {
        int length[] = {1,2,3,4};
        int price[] = {5,6,8,8};
        int sizeOfRod = 4;
        // divide the rod to get maximum profit.
        // since the same size can be cut twice, hence unbounded knapsack

        int res = getMaxProfit(length, price, sizeOfRod, length.length);
        System.out.println("Profit = "+ res);
    }

    private static int getMaxProfit(int[] length, int[] price, int sizeOfRod, int n) {
        //                           wt[]         val[]         w            n(size of array)
        int[][] t = new int[n+1][sizeOfRod+1];

        for (int i=0;i<n+1;i++){
            for (int j=0;j<sizeOfRod+1;j++){
                if (i==0 || j==0)
                    t[i][j] = 0;
            }
        }

        for (int i=1;i<n+1;i++){
            for (int j=1;j<sizeOfRod+1;j++){
                if (length[i-1] <= j){
                    t[i][j] = Math.max(price[i-1] + t[i][j-length[i-1]], t[i-1][j]);
                    // instead of (i-1) when selecting the element, (i) as we can select later also.
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][sizeOfRod];
    }
}
