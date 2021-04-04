package tree;

import java.util.Stack;

public class iterativeInOrder {
    public static void main(String[] args) {
        demoNode root = new demoNode(5);
        root.left = new demoNode(3);
        root.right = new demoNode(2);
        root.left.left = new demoNode(7);
        root.left.right = new demoNode(6);
        root.right.left = new demoNode(4);
        root.right.right = new demoNode(8);

        System.out.println("In Order ->7 3 6 5 4 2 8 ");
        itInOrder(root);
    }

    private static void itInOrder(demoNode root) {
        if (root == null)
            return;

        Stack<demoNode> stack = new Stack<>();
        while (!stack.isEmpty() || root!=null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.val+" ");
            root = root.right;
        }
    }
}
/* ALGO -
    while root is not null
        put root in stack and root = root.left
    as soon as root is null, we pop from stack, print it and make root = root.right;
*/