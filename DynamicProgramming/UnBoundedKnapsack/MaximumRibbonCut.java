package DynamicProgramming.UnBoundedKnapsack;

import java.util.Arrays;

public class MaximumRibbonCut {
    public static void main(String[] args) {
          int n = 11;
          int arr[] = {2,3,5};

        int res = getMaximumPieceCount(arr, n);
        System.out.println("No. of pieces = "+ res);
    }

    private static int getMaximumPieceCount(int[] arr, int len) {
        int[] dp = new int[len+1];

        // initialize all with -1
        for (int i=0;i<len+1;i++)
            dp[i] = -1;

        // first cell when length =0;
        dp[0] = 0;

        /*
        l = 11, p = 2, q = 3, r = 5
        Analysing lengths from 1 to 11:
        Not possible to cut->0
        Possible cut is of lengths 2->1 (2)
        Possible cut is of lengths 3->1 (3)
        Possible cuts are of lengths max(arr[4-2],arr[4-3])+1->2 (2,2)
        Possible cuts are of lengths max(arr[5-2],arr[5-3])+1->2 (2,3)
        Possible cuts are of lengths max(arr[6-2],arr[6-3],arr[6-5])+1->3 (2,2,2)
        Possible cuts are of lengths max(arr[7-2],arr[7-3],arr[7-5])+1->3 (2,3,2) or (2,2,3)
        Possible cuts are of lengths max(arr[8-2],arr[8-3],arr[8-5])+1->4 (2,2,2,2)
        Possible cuts are of lengths max(arr[9-2],arr[9-3],arr[9-5])+1->4 (2,3,2,2) or (2,2,3,2) or (2,2,2,3)
        */
        for (int i=0;i<len+1;i++){
            if (dp[i] == -1)
                continue;

            if (i+arr[0] <= len)
                dp[i + arr[0]] = Math.max(dp[i+arr[0]] , dp[i] +1);

            if (i + arr[1] <= len)
                dp[i + arr[1]] = Math.max(dp[i+arr[1]], dp[i] +1);

            if (i + arr[2] <= len)
                dp[i + arr[2]] = Math.max(dp[i+arr[2]], dp[i] + 1);
        }

        if (dp[len] == -1)
            dp[len] = 0;

        System.out.println(Arrays.toString(dp));

        return dp[len];
    }
}

/*
Initialise an array DP[]={-1} and DP[0]=0.
Run a loop from ‘0’ to ‘l’
If DP[i]=-1 means it’s not possible to divide it using giving segments p,q,r so continue;
DP[i+p]=max(DP[i+p],DP[i]+1) => maximum of what is at that position or (i-th position+1)
DP[i+q]=max(DP[i+q],DP[i]+1)
DP[i+r]=max(DP[i+r],DP[i]+1)
print DP[l]
*/