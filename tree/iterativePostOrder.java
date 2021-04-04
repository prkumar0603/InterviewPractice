package tree;

import java.util.Stack;

public class iterativePostOrder {
    public static void main(String[] args) {
        demoNode root = new demoNode(5);
        root.left = new demoNode(3);
        root.right = new demoNode(2);
        root.left.left = new demoNode(7);
        root.left.right = new demoNode(6);
        root.right.left = new demoNode(4);
        root.right.right = new demoNode(8);

        System.out.println("Post Order ->7 6 3 4 8 2 5 ");
        itPostOrder(root);
    }

    private static void itPostOrder(demoNode root) {
        if (root == null)
            return;

        Stack<demoNode> s1 = new Stack<>();
        Stack<demoNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()){
            demoNode temp = s1.pop();
            if (temp.left != null)
                s1.push(temp.left);
            if (temp.right != null)
                s1.push(temp.right);

            s2.push(temp);
        }

        while (!s2.isEmpty()){
            System.out.print(s2.pop().val+" ");
        }
    }
}
/* ALGO - two stack
    push root in stack1.
    pop it from stack1 and push into stqck2.
    if root has left, we put in stack1
    if root has right, we put in stack1.

    while stack2 is not empty
        pop every element from stack2 and print it.
*/