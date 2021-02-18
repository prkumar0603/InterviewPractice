/*
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
Constraints:
2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.*/

public class CheckIfItIsAStraightLine {
    public static void main(String[] args) {
        int[][] arr = {{-3,-2},{-1,-2},{2,-2},{-2,-2},{0,-2}};
        //System.out.println(Arrays.deepToString(arr));
        System.out.println(checkStraightLine(arr));
    }

    private static boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2)
            return true;

        int xdiff = coordinates[1][0] - coordinates[0][0];
        int ydiff = coordinates[1][1] - coordinates[0][1];

        for (int i=1;i<coordinates.length-1;i++){
            int curr_xdiff = coordinates[i][0] - coordinates[i+1][0];
            int curr_ydiff = coordinates[i][1] - coordinates[i+1][1];
            if (xdiff*curr_ydiff != ydiff*curr_xdiff)
                return false;
        }
        return true;
    }
}


/*Note -  check if slope same. (y2-y1)/(x2-x1)
* but if points same then divide by zero error. so take 3 points and cross multiply.
* (y2-y1)*(x3-x2) = (y3-y2)*(x2-x1)
*/
