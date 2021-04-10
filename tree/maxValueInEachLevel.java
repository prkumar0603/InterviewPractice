package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Given a binary tree, return the largest value in each of its levels. Ex: Given the following tree…
    2
   / \
  10  15
        \
         20
return [2, 15, 20]
Ex: Given the following tree…
          1
         / \
        5   6
       / \   \
      5   3   7
return [1, 6, 7]

*/
public class maxValueInEachLevel {
    public static void main(String[] args) {
        demoNode root= new demoNode(1);
        root.left = new demoNode(3);
        root.right = new demoNode(2);
        root.left.left = new demoNode(5);
        root.left.right = new demoNode(3);
        root.right.right = new demoNode(9);

        List<Integer> res = eachLevelMaximum(root);
        System.out.println(res);
    }

    private static List<Integer> eachLevelMaximum(demoNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<demoNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;

            for (int i=0;i<size;i++){
                demoNode current = q.poll();
                if (current.val >max)
                    max = current.val;

                if (current.left!=null)
                    q.add(current.left);

                if (current.right!=null)
                    q.add(current.right);
            }

            result.add(max);

        }

        return result;
    }
}
