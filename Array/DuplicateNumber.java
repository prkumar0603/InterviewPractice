package Array;

/*Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive. There is only one repeated number in nums, 
return this repeated number. You must solve the problem without modifying the array nums and uses only constant extra space.
Example 1:
Input: nums = [1,3,4,2,2]
Output: 2
Example 2:
Input: nums = [3,1,3,4,2]
Output: 3
Constraints:
1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
Follow up:
How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?*/

public class DuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {2,6,4,3,3,1,5};

        int tortoise = nums[0];
        int hare = nums[0];

        // do while with tortoise 1 step and hare 2 step.
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        tortoise = nums[0];     // putting any one of them to start

        // moving both with one step until match to find the common element
        while (tortoise!=hare){
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        System.out.println("Answer : "+hare);

    }
}
/* Use Hare and tortoise method to find the duplicate number 
* same as to find loop in linked-list*/
