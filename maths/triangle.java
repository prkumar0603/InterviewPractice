import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Given a triangle array, return the minimum path sum from top to bottom.
For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the
current row, you may move to either index i or index i + 1 on the next row.
Example 1:
Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:
Input: triangle = [[-10]]
Output: -10
Constraints:
1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104
Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
*/
public class triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> a1 = new ArrayList<>();
        a1.add(2);
        triangle.add(a1);

        List<Integer> a2 = new ArrayList<>();
        a2.add(3);
        a2.add(4);
        triangle.add(a2);

        List<Integer> a3 = new ArrayList<>();
        a3.add(6);
        a3.add(5);
        a3.add(7);
        triangle.add(a3);

        List<Integer> a4 = new ArrayList<>();
        a4.add(4);
        a4.add(1);
        a4.add(8);
        a4.add(3);
        triangle.add(a4);
        // System.out.println(triangle);
        int res = minimumTotal(triangle);
        System.out.println(res);
    }

    static Integer[][] dp;
    private static int minimumTotal(List<List<Integer>> triangle) {
        //return helper(triangle, 0, 0);

        dp = new Integer[triangle.size()][triangle.size()];
        return dpTopDown(triangle, 0, 0);
    }

    private static int dpTopDown(List<List<Integer>> triangle, int r, int c) {
        if(r >= triangle.size())
            return 0;

        if (dp[r][c] == null)
            dp[r][c] = Math.min(dpTopDown(triangle, r+1, c), dpTopDown(triangle, r+1, c+1)) +
                    triangle.get(r).get(c);

        return dp[r][c];
    }

    // will fail with large input
    private static int helper(List<List<Integer>> triangle, int row, int col) {
        if (row >= triangle.size())
            return 0;

        return Math.min(helper(triangle, row+1, col),
                helper(triangle, row +1, col+1)) +
                triangle.get(row).get(col); // finding min at next and adding that point.
        /*     2        - r1
              3 4       - r2
             6 5 7      - r3
            4 1 8 3     - r4
         c1 c2 c3 c4
        when calling next level, row is increasing in any case but in one column remains same
        and in other column increases.
        so that's how we check adjacent elements.
        */
    }

}
