package Searching;
/*Given a set of points as and a line as ax+by+c = 0. We need to find a point on given line for which sum of distances from given set of points is minimum.

Example:
    line = x - y - 3 =0
    Points - (-3-2) , (-1,0) , (-1,2) , (1,2) , (3,4)
In above figure optimum location of point of x - y - 3 = 0 line
is (2, -1), whose total distance with other points is 20.77,
which is minimum obtainable total distance.
*/

public class OptimumLocationToMinimizeDistance {
    static int N = 5;   // for 5 points given
    static int EPS = (int)(1e-6) + 1;

    public static void main(String[] args) {
        Line line = new Line(1,-1,-3);
        int[][] points = { { -3, -2 }, { -1, 0 }, { -1, 2 },
                        { 1, 2 }, { 3, 4 } };

        System.out.println(findOptimumCost(points, line));

    }

    private static double findOptimumCost(int[][] points, Line line) {
        Point[] point = new Point[N];       // array of Point class and putting values

        for (int i=0;i<N;i++)
            point[i] = new Point(points[i][0], points[i][1]);

        return findOptimumCostUtil(point, N , line);
    }

    private static double findOptimumCostUtil(Point[] point, int n, Line line) {
        double low = -1e6;      // value = -1 x 10 power 6
        double high = 1e6;

        while((high-low) > EPS){
            double mid1 = low + (high-low)/3;
            double mid2 = high - (high-low)/3;

            double dist1 = compute(point, n, line, mid1);
            double dist2 = compute(point, n, line, mid2);

            if (dist1 < dist2)
                high = mid2;
            else
                low= mid1;
        }
        return compute(point, n, line, (low+high)/2);
    }
                                                                // mid value
    private static double compute(Point[] point, int n, Line line, double X) {
        double res = 0;
        double Y = -1 * (line.c + line.a * X) / line.b; // calculating y. ax + by + c = 0
        for (int i=0;i<n;i++)
            res += dist(X, Y, point[i]);

        return res;
    }

    private static double dist(double x, double y, Point point) {
        return Math.sqrt(square(x - point.x) + square(y - point.y));  // root[(x-x1)**2 + (y-y1)**2]
    }

    static double square(double x) { return ((x) * (x)); }
}

class Point{
    int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Line{
    int a,b,c;
    Line(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
}