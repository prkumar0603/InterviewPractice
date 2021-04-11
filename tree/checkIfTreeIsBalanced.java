package tree;
/* Consider a height-balancing scheme where following conditions should be checked to determine
if a binary tree is balanced.
An empty tree is height-balanced. A non-empty binary tree T is balanced if:
1) Left subtree of T is balanced
2) Right subtree of T is balanced
3) The difference between heights of left subtree and right subtree is not more than 1.
*/
public class checkIfTreeIsBalanced {
    public static void main(String[] args) {
        demoNode root = new demoNode(1);
        root.left = new demoNode(3);
        root.right = new demoNode(2);
        root.left.left = new demoNode(5);
        //root.right.right = new demoNode(4);

        boolean res = check(root);
        System.out.println(res);
    }

    private static boolean check(demoNode root) {
        // base case is if zero then it is balanced tree.
        if (root==null)
            return true;

        int lh = height(root.left);
        int rh = height(root.right);

        if (Math.abs(lh-rh) <= 1 &&
            check(root.left) &&
            check(root.right)){
            return  true;
        }

        return false;
    }

    private static int height(demoNode root) {
        if(root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
