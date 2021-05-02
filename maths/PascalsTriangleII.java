import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public static void main(String[] args) {
        int rowIndex = 1;
        List<Integer> res = generate(rowIndex);
        System.out.println(res);
    }

    private static List<Integer> generate(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<>();

        List<Integer> first_row = new ArrayList<>();
        first_row.add(1);
        if (rowIndex == 0)
            return first_row;

        triangle.add(first_row);

        for (int i=1;i<=rowIndex;i++){
            List<Integer> prev = triangle.get(i-1);
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j=1;j<i;j++){
                curr.add(prev.get(j-1) + prev.get(j));
            }
            curr.add(1);
            triangle.add(curr);
        }
        return triangle.get(rowIndex);
    }
}
