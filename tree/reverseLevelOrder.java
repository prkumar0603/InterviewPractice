package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* In reverse level order, the lst level is printed first.
*/
public class reverseLevelOrder {
    public static void main(String[] args) {
        demoNode root = new demoNode(1);
        root.left = new demoNode(2);
        root.right = new demoNode(3);
        root.left.left = new demoNode(4);
        root.left.right = new demoNode(5);

        List<List<Integer>> res = reverselevel(root);
        System.out.println(res);
    }

    private static List<List<Integer>> reverselevel(demoNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<demoNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> current = new ArrayList<>();
            for (int i=0;i<size;i++){
                demoNode temp = q.poll();
                current.add(temp.val);

                if (temp.left!=null)
                    q.add(temp.left);
                if (temp.right!=null)
                    q.add(temp.right);
            }
            result.add(0, current);
        }
        return result;
    }
}
