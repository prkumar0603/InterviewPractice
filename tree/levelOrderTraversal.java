package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
For example:
Given binary tree [1,2,3,4,null,null,5] ,
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]*/
public class levelOrderTraversal {
    public static void main(String[] args) {
        demoNode root = new demoNode(3);
        root.left = new demoNode(9);
        root.right = new demoNode(20);
        root.left.left = new demoNode(32);
        root.left.right = new demoNode(3);
        root.right.left = new demoNode(15);
        root.right.right = new demoNode(7);

        List<List<Integer>> res = levelOrder(root);
        System.out.println(res);
    }

    private static List<List<Integer>> levelOrder(demoNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<demoNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
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
            result.add(current);
        }
        return result;
    }
}
