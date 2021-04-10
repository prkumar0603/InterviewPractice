package tree;

import java.util.*;

/* Mirror of a Binary Tree T is another Binary Tree M(T) with left and right children
of all non-leaf nodes interchanged.
*/
public class mirrorOfTree {
    public static void main(String[] args) {
        demoNode root = new demoNode(1);
        root.left = new demoNode(3);
        root.right = new demoNode(2);
        root.right.left = new demoNode(5);
        root.right.right = new demoNode(4);

        System.out.print("before -> ");
        inorder(root);
        mirrorIter(root);
        System.out.println();
        System.out.print("After -> ");
        inorder(root);
    }

    // using recursion
    private static demoNode mirrorRec(demoNode root) {
        if (root == null)
            return root;

        // calculate subtrees
        demoNode left = mirrorRec(root.left);
        demoNode right = mirrorRec(root.right);

        // swap left and right parameter
        root.left = right;
        root.right = left;

        return root;
    }

    // using level order traversal
    private static void mirrorIter(demoNode root) {
        if (root == null)
            return;

        Queue<demoNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            demoNode current = q.poll();

            demoNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left!=null)
                q.add(current.left);
            if (current.right!=null)
                q.add(current.right);
        }
    }

    // printing the tree
    private static void inorder(demoNode root) {
        if (root==null)
            return;

        Stack<demoNode> stack = new Stack<>();
        while (root !=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.val+" ");
            root = root.right;
        }
    }
}
