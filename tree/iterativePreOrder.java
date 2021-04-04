package tree;

import java.util.Stack;

public class iterativePreOrder {
    public static void main(String[] args) {
        demoNode root = new demoNode(5);
        root.left = new demoNode(3);
        root.right = new demoNode(2);
        root.left.left = new demoNode(7);
        root.left.right = new demoNode(6);
        root.right.left = new demoNode(4);
        root.right.right = new demoNode(8);

        System.out.println("Pre Order -> 5 3 7 6 2 4 8 ");
        itPreOrder(root);
    }

    private static void itPreOrder(demoNode root) {
        if (root == null)
            return;

        Stack<demoNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            demoNode temp = stack.pop();
            System.out.print(temp.val+" ");

            if (temp.right != null)
                stack.push(temp.right);

            if (temp.left != null)
                stack.push(temp.left);

        }
    }
}
/*ALGO -
    push root into stack.
    while stack is not empty
        pop root out of stack and print it.
        if it has a right child, put it in stack.
        if it has a left child, put it in stack.

Note - Right child is pushed before left child to make sure that
    left subtree is processed first
*/