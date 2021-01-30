/*Find a subArray with maximum sum. */
public class kadaneAlgorithm {

    public static void main(String[] args) {
       int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

       int max_sum = Integer.MIN_VALUE;
       int curr_sum = 0;

       for (int i=0; i<arr.length;i++){
           curr_sum += arr[i];

           if (curr_sum > max_sum)
               max_sum = curr_sum;

           if (curr_sum < 0)
               curr_sum = 0;
       }
        System.out.println("Maximum sum = "+max_sum);
    }
}
