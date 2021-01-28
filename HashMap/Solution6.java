/*Problem Statement: Given an array of integers and a range N, find the number of duplicates present.
Follow-up Question 1: Do in constant space
P.S. This follow up question is asked in many high tier companies.
*/
import java.util.HashMap;
public class Solution6 {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 3, 6, 6};
        int n = arr.length;

        // using hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
//            if(map.get(arr[i]) == null)
//                map.put(arr[i], 1);
//            else
//                map.put(arr[i], map.get(arr[i])+1 );

            // 2nd way
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(Integer i:map.keySet()){
            if(map.get(i) != 1)
                System.out.print(i+" ");
        }

        System.out.println();
        // in constant space -------------------------------------------------------------
        for (int i = 0; i < n; i++) {
            int j = Math.abs(arr[i]);
            if (arr[j] >= 0)
                arr[j] = -arr[j];
            else
                System.out.print(j + " ");
        }

    }
}