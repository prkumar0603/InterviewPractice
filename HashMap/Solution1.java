/*Problem Statement: Given an array of numbers and a number k, return whether any 2 numbers from the array add up to K.
For example, given [10, 3, 2, 7] and K=12, return yes since 10+2=12. If K would have been 11, return no.
Follow-Up question:     Do this in one pass, ie, in O(n).
Follow-Up question 2:   Explain how the used data-structure is implemented/stored in C++/Java/python
Follow-Up question 3:   Time Complexities of various operations of the used data structures.
*/
import java.util.*;
public class Solution1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int arr[] = {1,3,5,7,-1};
		
		int k = 6;
		
	/*	Brute-force method
	  	int count = 0;
        // Consider all possible pairs and check their sums 
        for (int i = 0; i < arr.length; i++) 
            for (int j = i + 1; j < arr.length; j++) 
                if ((arr[i] + arr[j]) == k) 
                    count++; 
  
        System.out.printf(count);
    */
		
		
		HashMap<Integer,Integer> hm = new HashMap<>();
		for(int i =0;i<arr.length;i++){
			if(hm.get(arr[i]) == null)
				hm.put(arr[i],1);
			else
				hm.put(arr[i],hm.get(arr[i])+1);
		}
		
		int count = 0;
		for(int i=0;i<arr.length;i++){
			if(hm.get(k - arr[i]) != null)
				count += hm.get(k - arr[i]);
		
		//if counterpart is same. for solution like (3,3).
		if((k-arr[i]) == arr[i])
			count--;
		}
		
		System.out.println(count/2); 	// if (1,5) is solution then (5,1) is also in solution. so to remove that.
		sc.close();
	}
}
