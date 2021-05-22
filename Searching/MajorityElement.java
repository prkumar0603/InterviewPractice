package Searching;

/* Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N is an
element that appears more than N/2 times in the array.
Example 1:
Input: N = 3
	A[] = {1,2,3}
	Output:
	-1
	Explanation:
	Since, each element in
	{1,2,3} appears only once so there
	is no majority element.
Example 2:
Input: N = 5
	A[] = {3,1,3,3,2}
	Output:
	3
	Explanation:
	Since, 3 is present more
	than N/2 times, so it is
	the majority element.
Your Task:
The task is to complete the function majorityElement() which returns the majority element in the array.
If no majority exists, return -1.
*/
import java.util.HashMap;
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,3,4,3,3};

        // findMajorityByHashMap(nums);

        majorityByMooreVotingAlgo(nums, nums.length);
    }

    private static void majorityByMooreVotingAlgo(int[] arr, int n) {
        int max_index = 0;      // assuming first element as max index and count 1
        int count = 1;

        // getting the majority element
        for (int i=1;i<n;i++){
            if (arr[i] != arr[max_index])   // if element is not equal to majority element, count--
                count--;
            else
                count++;

            if (count == 0){        // when count reaches 0(zero), change the majority element
                max_index = i;
                count = 1;
            }
        }

        // verifying the majority element which is arr[max_index]
        count = 0;
        for (int i=0;i<n;i++){
            if (arr[i] == arr[max_index])
                count++;
        }

        if (count > n/2)
            System.out.println(arr[max_index]);
        else
            System.out.println("No Majority Element");
    }

    private static void findMajorityByHashMap(int[] nums) {
        double len = Math.floor(nums.length/2);

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int x:nums){
            if (!map.containsKey(x))
                map.put(x,1);
            else
                map.put(x,(int)map.get(x)+1);
        }

        for (int x:map.keySet())
            if (map.get(x)>len)
                System.out.println(x);
    }

}