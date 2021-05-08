package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*Given a set of time intervals in any order, merge all overlapping intervals into one and output the result
which should have only mutually exclusive intervals. Let the intervals be represented as pairs of integers
for simplicity.
For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8}}. The intervals {1,3} and {2,4}
overlap with each other, so they should be merged and become {1, 4}. Similarly, {5, 7} and {6, 8} should be
merged and become {5, 8}
*/
public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        int[][] arr = {{1,3}, {2,4},{5,7},{6,8}};
        // int[][] res = solveByStack(arr);
        // System.out.println(Arrays.deepToString(res));

        int[][] res1 = solveByList(arr);
        System.out.println(Arrays.deepToString(res1));
    }

    private static int[][] solveByList(int[][] intervals) {
        if (intervals.length<=1)
            return intervals;

        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        List<int[]> list = new ArrayList<>();
        int[] current_interval = intervals[0];
        list.add(current_interval);

        for (int[] interval : intervals){
            int current_begin = current_interval[0];
            int current_end = current_interval[1];
            int next_begin = interval[0];
            int next_end = interval[1];

            if (next_begin < current_end){
                current_interval[1] = Math.max(next_end, current_end);
            }
            else{
                current_interval = interval;
                list.add(current_interval);
            }
        }

        return list.toArray(new int[list.size()][]);

    }

    /*put first element in stack. If start time of next element is > end time of first element, then merge the
    interval and change the end time of the first interval.*/
    private static int[][] solveByStack(int[][] intervals) {
        if (intervals.length == 1)
            return intervals;

        // Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        Stack<int[]> stack = new Stack<>();

        for (int[] interval: intervals){
            if (stack.isEmpty()){
                stack.push(interval);
            }

            int[] top = stack.peek();
            if (interval[0] <= top[1]){
                int[] temp = stack.pop();

                temp[1] = Math.max(interval[1], temp[1]);
                stack.push(temp);

            }
            else{
                stack.push(interval);
            }
        }

        int[][] res = new int[stack.size()][2]; // need to put stack into this array for returning
        int row = 0;
        while(!stack.isEmpty()){
            int[] temp = stack.pop();
            res[row][0] = temp[0];
            res[row][1] = temp[1];
            row++;
        }
        return res;
    }

}

