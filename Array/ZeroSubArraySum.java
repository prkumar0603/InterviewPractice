import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*Given an array of positive and negative numbers, find if there is a subarray (of size at-least one) with 0 sum.
 Input: {4, 2, -3, 1, 6}
 Output: true
 There is a subarray with zero sum from index 1 to 3.
 HINT :
 arr[] = {1, 4, -2, -2, 5, -4, 3}
 If we consider all prefix sums, we can notice that there is a subarray with 0 sum when :
 1) Either a prefix sum repeats or
 2) Or prefix sum becomes 0.
 Prefix sums for above array are:
 1, 5, 3, 1, 6, 2, 5
 Since prefix sum 1 repeats, we have a subarray with 0 sum.
 */
public class ZeroSubArraySum {

    public static void main(String[] args) {

        int arr[] = {1, 4, -2, -2, 5, -4, 3};//{-3,2,3,1,6};
        System.out.println(Arrays.toString(arr));

        Set<Integer> set = new HashSet<>();
        int flag = 0;

        int sum=0;
        for (int i=0;i<arr.length;i++){
            sum += arr[i];

            /* Return true in following cases
            a) Current element is 0
            b) sum of elements from 0 to i is 0
            c) sum is already present in set */
            if (arr[i] == 0 || sum == 0 || set.contains(sum)) {
                System.out.println("true");
                flag =1;
            }

            set.add(sum);
        }
        if (flag == 0)
        System.out.println("False");

    }
}
