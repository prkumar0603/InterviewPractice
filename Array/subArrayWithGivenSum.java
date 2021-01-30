
public class subArrayWithGivenSum {

    public static void main(String[] args) {
       int[] arr = {1,4,20,3,10,5};
       int sum = 33;

       int n = arr.length;
       int curr_sum = arr[0];
       int start = 0;

       for (int i=1;i<=n;i++){      // i<=n for adding the last element also

           // if the current sum exceeds sum, subtract the start index and start++
           while(curr_sum > sum && start < i-1){
               curr_sum = curr_sum - arr[start];
               start++;
           }

           if (curr_sum == sum){
               System.out.println("sum found between "+start+" and "+ (i-1));
               break;
           }

           if (i<n)     // i<n for preventing overflow
            curr_sum = curr_sum + arr[i];
       }

    }
}
/*Approach - keep adding elements until it exceeds the sum. after that increasing the
* starting point.*/