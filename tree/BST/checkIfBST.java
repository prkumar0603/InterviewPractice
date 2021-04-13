package tree.BST;

public class checkIfBST {
    public static void main(String[] args) {
        demoNode root = new demoNode(15);
        root.left = new demoNode(10);
        root.right = new demoNode(20);
        root.left.left = new demoNode(5);
        root.left.right = new demoNode(12);
        root.right.left = new demoNode(18);
        root.right.right = new demoNode(25);

        boolean res = isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(res);
    }

    private static boolean isBST(demoNode root, int minValue, int maxValue) {
        if (root == null)
            return true;

        if (root.val <= minValue || root.val > maxValue)
            return false;

        return isBST(root.left, Integer.MIN_VALUE, root.val) &&
                isBST(root.right, root.val, Integer.MAX_VALUE);
    }
}
/* simple check - checking a node greater than its left and smaller than its right
   does ot work. [[10],[0,25],[1,21,16,32]] - here 21 should be less than 10.

   so every node value has a range limit.
*/