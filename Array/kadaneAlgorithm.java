/*Find a subArray with maximum sum. */
public class kadaneAlgorithm {

    public static void main(String[] args) {
       int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
       //int arr[] = {-2, -3, 8, 1,-9, 1, 5, -3};

       int start = 0;   // for the start index of subarray
       int end = 0;     // for the end index of subarray
       int s =0;

       int prev_sum = Integer.MIN_VALUE;
       int curr_sum = 0;

       for (int i=0; i<arr.length;i++){
           curr_sum += arr[i];

           // check if new sum formed is greater than previous sum
           if (curr_sum > prev_sum){
                prev_sum = curr_sum;
                start =s;
                end = i;
            }
           // if new sum formed is < 0, make it zer0. and start will be from next of that element
            if (curr_sum < 0){
                curr_sum = 0;
                s = i+1;
            }
       }
        System.out.println("start = "+ start+" end = "+end);
        System.out.println("Maximum sum = "+prev_sum);
    }
}
