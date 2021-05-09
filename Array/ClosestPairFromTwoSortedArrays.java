package Array;

import java.util.Arrays;

/*Given two sorted arrays and a number x, find the pair whose sum is closest to x and the pair has an element from each array.
We are given two arrays ar1[0…m-1] and ar2[0..n-1] and a number x, we need to find the pair ar1[i] + ar2[j] such that
absolute value of (ar1[i] + ar2[j] – x) is minimum.
Example:
Input:  ar1[] = {1, 4, 5, 7};
        ar2[] = {10, 20, 30, 40};
        x = 32
Output:  1 and 30
Input:  ar1[] = {1, 4, 5, 7};
        ar2[] = {10, 20, 30, 40};
        x = 50
Output:  7 and 40
*/
public class ClosestPairFromTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 5, 7};
        int[] arr2 = {10, 20, 30, 40};
        int x = 38;

/*        int[] res = solve(arr1, arr2, x);
        System.out.println(Arrays.toString(res));*/

        int[] res1 = findClosestPair(arr1,arr2,x);
        System.out.println(Arrays.toString(res1));
    }

    // O(n) time and O(1) space.
    // idea is two pointer. one on left of first array and other right of 2nd array.
    // absolute difference should be less than diff. then update result and diff.
    private static int[] findClosestPair(int[] arr1, int[] arr2, int x) {
        int diff = Integer.MAX_VALUE;
        int l = 0;
        int r = arr2.length-1;

        int res_l=0,res_r=0;

        while(l<arr1.length && r>0){
            if (Math.abs(arr1[l] + arr2[r] - x) < diff){
                diff = Math.abs(arr1[l] + arr2[r] - x);
                res_l = l;
                res_r = r;
            }
            else if(arr1[l]+ arr2[r] < x)   // sum is less than target
                l++;
            else                       // sum is greater than target
                r--;
        }
        return new int[]{arr1[res_l],arr2[res_r]};
    }

    // the time complexity is n2. idea is to find all possible pair and get the closest pair
    private static int[] solve(int[] arr1, int[] arr2, int x) {
        if (arr1.length==1 && arr2.length==1)
            return new int[]{arr1[0], arr2[0]};

        if (x < (arr1[0] + arr2[0]))
            return new int[]{};

        int[] arr = new int[2];
        int y = 0, z =0;
        int flag = 0;
        int rem = (x- arr1[0] + arr2[0]);
        for (int i=0;i<arr1.length;i++){

            for (int j=0;j<arr2.length;j++){
                if ((x -(arr1[i] + arr2[j])) < rem && (x -(arr1[i] + arr2[j])) >0 &&
                        (arr1[i] + arr2[j]) > (y+z)){
                    y = arr1[i];
                    z = arr2[j];
                    flag = 1;
                }
            }
        }
        //System.out.println(y+" "+z+" "+(int)(z+y));
        if (flag==0)
            return new int[]{arr1[0],arr2[0]};

        return new int[]{y,z};
    }
}
