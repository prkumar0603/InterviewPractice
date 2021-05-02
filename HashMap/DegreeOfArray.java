import java.util.HashMap;
/*
Given a non-empty array of non-negative integers nums, the degree of this array is defined as the
maximum frequency of any one of its elements.
Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the
same degree as nums.
Example 1:
Input: nums = [1,2,2,3,1]
Output: 2
Explanation:
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.

Example 2:
Input: nums = [1,2,2,3,1,4,2]
Output: 6
Explanation:
The degree is 3 because the element 2 is repeated 3 times.
So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
Constraints:
nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.
*/
public class DegreeOfArray {
    public static void main(String[] args) {
        int arr[] = {1,2,2,3,1,4,2};
        int res = findShortestSubArray(arr);
        System.out.println(res);
    }

    private static int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int degree = 0;

        HashMap<Integer, Integer> first_seen = new HashMap<>();
        int min_length = 0;

        for (int i=0;i<nums.length;i++){
            first_seen.putIfAbsent(nums[i], i);  //storing when an element occur first to get length

            map.put(nums[i], map.getOrDefault(nums[i], 0)+1); //storing the frequency

            if (map.get(nums[i]) > degree) {
                degree = map.get(nums[i]);
                min_length = i - first_seen.get(nums[i]) + 1; // +1 coz length is 1 + index
            }
            else if (map.get(nums[i]) == degree){
                min_length = Math.min(min_length, i - first_seen.get(nums[i]) + 1);
            }
        }

        return min_length;
    }
}
