/*Suppose, you are provided with an unending stream of sorted integers like 1,1,1,1,2,2,2,3,4,5,11,12,12,12,12,12,12,12,12,12,12... You don't know the length of this stream. Your task is to find an integer in this stream and print its position(any one of the position). There can be unending number of duplicates.
Follow-up Question 1: Better complexity than O(n)
Follow-up Question 2: What will change in your code if negative numbers are present.
Follow-up Question 3: Return the number of duplicates of the given number. Ex- in above stream, if number is 2, you have to return 3.
*/
import java.util.*;
public class Solution5 {
    // since the array is sorted, first thing clicks is binary search.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[] = {1,1,1,1,2,2,2,3,4,5,11,12,12,12,12,12,12,12,12,12,12};
        int k = 7;

        int result = findpos(arr,k);
        if(result == -1)
            System.out.println("Element not found");
        else
            System.out.println("answer = "+ result);

        sc.close();
    }

    public static int findpos(int arr[],int k){
        int low=0,high=1;
        int val = arr[0];

        // setting the value of lower and upper bound
        while(val < k){
            low = high;                   // store previous value

            if(2*high < arr.length)        //check if 2*high < value to find
                high = high*2;                // increase high value by double
            else
                high = arr.length-1;

            val = arr[high];            // update new value
        }

        return BinSearch(arr, low, high, k);
    }

    // binary search time : 0(log n)
    public static int BinSearch(int arr[],int low,int high,int n){
        if(high >= low){
            int mid = low + (high - low)/2;

            if(arr[mid] == n)
                return mid;
            else if (arr[mid] > n)
                return BinSearch(arr,low,mid-1,n);
            else
                return BinSearch(arr,mid+1,high,n);
        }
        return -1;
    }

}
