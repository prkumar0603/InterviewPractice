import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class printAllSubArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3};

        List<List<Integer>> res = getAllSubArray(arr);
        System.out.println(res);
    }

    private static List<List<Integer>> getAllSubArray(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubSets(0, nums, new ArrayList<Integer>(), result);
        return result;
    }

    private static void generateSubSets(int index, int[] nums, ArrayList<Integer> curr_set, List<List<Integer>> result) {
        result.add(new ArrayList<>(curr_set));

        for (int i=index;i<nums.length;i++){
            curr_set.add(nums[i]);
            generateSubSets(i+1, nums, curr_set, result);
            curr_set.remove(curr_set.size() -1);
        }
    }
}


/*
printing all subsets of an array - by taking an element in solution and by not taking in solution recursively.
*/
