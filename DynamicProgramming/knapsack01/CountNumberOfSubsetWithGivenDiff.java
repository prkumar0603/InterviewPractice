package DynamicProgramming.Knapsack01;

public class CountNumberOfSubsetWithGivenDiff {
    public static void main(String[] args) {
        int arr[] = {1,1,2,3};
        int diff = 1;
        // given an array and a difference value. divide this array into
        // two subsets such that difference of both the subsets is equal to
        // given difference.
        /*  given - make two subset, subset1(s1) and subset(s2).
                s1 - s2 = difference (given = 1)
                s1 + s2 = sum of array
          => s1 = (diff + sum(array))/2;
        */
        
        int res = getCountOfSubset(arr, diff, arr.length);
        System.out.println(res);
        
    }

    private static int getCountOfSubset(int[] arr, int diff, int n) {
        
        int sum=0;
        for (int i:arr)
            sum+=i;
        
        int sum1 = (diff+sum)/2;
        int count = CountOfSubsetWithGivenSum(arr, sum1, n);
        return count;
    }

    private static int CountOfSubsetWithGivenSum(int[] arr, int sum, int n) {
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
