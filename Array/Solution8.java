/*Problem Statement: Given an array A[] consisting 0, 1 and 2, write a function that sorts A[].
 * The functions should put all 0 first, then all 1 and all 2 in last.
 *  For Example: {0,1,2,0,1,2} should return {0,0,1,1,2,2}
Follow-up question 1: Do this in constant space
Follow-up question 2: Do this in a single iteration
Dutch National Flag Problem
 */
public class Solution8 {
    static int arr[] = {0,1,1,0,1,2,1,2,0,0,0,1};
    public static void main(String[] args) {

        int low = 0, high = arr.length -1, mid =0;

        while(mid <= high){
            switch(arr[mid]){
                case 0:
                    swap(low,mid);
                    mid++;low++;		// we increment mid as previous array must have been sorted
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(mid,high);
                    high--;					//in case 2 we dont increment mid as array in front is not sorted
                    break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}
