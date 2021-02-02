package DynamicProgramming.Knapsack01;

import java.util.Vector;

public class MinSubsetSumDifference {
    public static void main(String[] args) {
        int arr[] = {1,6,11,5};
        // given an array. divide this array into two subsets such that
        // difference of both the subsets is minimum.

        int res = getMinSubsetSumDifference(arr, arr.length);
        System.out.println(res);
    }

    private static int getMinSubsetSumDifference(int[] arr, int n) {
        int range = 0;
        for(int i=0;i<n;i++){
            range += arr[i];
        }

        Vector<Integer> vector = getSubsetSum(arr, range, n);
        System.out.println(vector);
        //System.out.println(vector.get(0) + " " + vector.get(1) + " " + vector.get(2) );


        int min=Integer.MAX_VALUE;
        for (int i=0;i<vector.size();i++){
            if ((range-2* vector.get(i)) < min)
                min = (range - 2*(vector.get(i)));
        }

        return min;
    }

    private static Vector<Integer> getSubsetSum(int[] arr, int sum, int n) {
        boolean t[][] = new boolean[n+1][sum+1];

        for (int i=0;i<n+1;i++){
            for (int j=0;j<sum+1;j++){
                if (i==0)
                    t[i][j] = false;
                if (j==0)
                    t[i][j] = true;
            }
        }

        for (int i=1;i<n+1;i++){
            for (int j=1;j<sum+1;j++){
                if (arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        //System.out.println(Arrays.deepToString(t));

        Vector<Integer> vector = new Vector<>();
        for (int j=0;j<(sum+1)/2;j++){      //making a vector of only half size
            if (t[n][j])
                vector.add(j);
        }
        //System.out.println(vector);
        return vector;
    }

}
