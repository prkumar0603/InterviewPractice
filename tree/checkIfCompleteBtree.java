package tree;

import java.util.LinkedList;
import java.util.Queue;

/*Given a Binary Tree, write a function to check whether the given Binary Tree is Complete Binary Tree or not.
 A complete binary tree is a binary tree in which every level, except possibly the last,
 is completely filled, and all nodes are as far left as possible.
*/
public class checkIfCompleteBtree {
    public static void main(String[] args) {
        demoNode root = new demoNode(1);
        root.left = new demoNode(2);
        root.right = new demoNode(3);
        root.left.left = new demoNode(4);
        root.left.right = new demoNode(5);
        root.right.left = new demoNode(6);
        //root.right.right = new demoNode(16);

        boolean res = checkIfComplete(root);
        System.out.println(res);

    }

    private static boolean checkIfComplete(demoNode root) {
        if (root == null)
            return true;
        boolean end = false;
        Queue<demoNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            demoNode current = q.poll();
            if (current.left!=null){
                if (end)
                    return false;
                q.add(current.left);
            }else      // else if we encounter a null node
                end = true;

            if (current.right!=null){
                if (end)
                    return false;
                q.add(current.right);
            }else      // else if we encounter a null node
                end = true;
        }
        return true;
    }
}
/*idea is if we get a null value, it should be the last value we get. we should not get
  any node after that. so we create a flag. if we find any null value, make flag true, and
  if we get any value after that, it is not complete B tree.
*/