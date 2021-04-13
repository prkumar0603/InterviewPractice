package tree.BST;

import java.util.Stack;

public class deleteNodeInBST {
    public static void main(String[] args) {
        demoNode root = new demoNode(15);
        root.left = new demoNode(10);
        root.right = new demoNode(20);
        root.left.left = new demoNode(5);
        root.left.right = new demoNode(12);
        root.right.left = new demoNode(18);

        preorder(root);
        System.out.println();
        int key = 15;
        deleteNode(root, key);
        preorder(root);
    }

    private static demoNode deleteNode(demoNode root, int key) {
        if (root == null)
            return null;

        if (key < root.val){
            root.left = deleteNode(root.left, key);
        }
        else if (key > root.val){
            root.right = deleteNode(root.right, key);
        }
        else{
            if (root.left!=null && root.right!=null){
                int rmin = minFromRightSubtree(root.right); // also use max from left subtree
                root.val = rmin;
                root.right = deleteNode(root.right, rmin);
                return root;
            }
            else if (root.left!=null){
                return root.left;
            }
            else if (root.right!=null){
                return root.right;
            }
            else{
                return null;
            }

        }
        return root;
    }

    private static int minFromRightSubtree(demoNode root) {
        while (root.left!=null){
            root = root.left;
        }
        return root.val;
    }

    private static void preorder(demoNode root) {
        if (root == null)
            return;

        Stack<demoNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            System.out.print(root.val+" ");

            if (root.right!=null)
                stack.push(root.right);
            if (root.left!=null)
                stack.push(root.left);
        }
    }
}
/* Approach - traverse and find the node to delete. if key value is bigger, go to right subtree and if
   smaller, go to left subtree.
   if value matches - three posibility - leaf node, with one child node or with two child node.
   leaf node - return null
   one child node - return that child subtree.
   with two child node - find the minimum from right subtree. and call to delete that node from right
   subtree.
*/