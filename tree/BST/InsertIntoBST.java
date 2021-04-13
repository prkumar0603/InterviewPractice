package tree.BST;

import java.util.Stack;

public class InsertIntoBST {
    public static void main(String[] args) { 
        demoNode root = new demoNode(15);
        root.left = new demoNode(10);
        root.right = new demoNode(20);
        root.left.left = new demoNode(5);
        root.left.right = new demoNode(12);
        root.right.left = new demoNode(18);
        
        inorder(root);
        int key = 19;
        insertNode(root, key);
        System.out.println();
        inorder(root);
    }

    private static demoNode insertNode(demoNode root, int key) {
        if(root ==null){
            root = new demoNode(key);
            return root;
        }

        if (key < root.val){
            root.left = insertNode(root.left, key); // imp to receive
        }else{
            root.right = insertNode(root.right, key);   // imp to receive
        }
        return root;
    }

    private static void inorder(demoNode root) {
        if (root==null)
            return;

        Stack<demoNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.val+" ");
            root = root.right;
        }
    }
}
/*Approach - traverse the tree to find the position for the node. when found
    create a new node and attch it there.
    it is important to receive the value since in last step when we return null
    so until we dont receive, it will not be attached.
*/