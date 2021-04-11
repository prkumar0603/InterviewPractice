package tree;

public class heightOfTree {
    public static void main(String[] args) {
        demoNode root = new demoNode(3);
        root.left = new demoNode(9);
        root.right = new demoNode(20);
        root.left.left = new demoNode(32);
        root.left.right = new demoNode(3);
        root.right.left = new demoNode(15);
        root.right.right = new demoNode(7);

        int res = treeHeight(root);
        System.out.println(res);
    }

    private static int treeHeight(demoNode root) {
        // base
        if (root == null)
            return 0;

        // hypothesis
        int leftHeight = treeHeight(root.left);
        int rightheight = treeHeight(root.right);

        // induction
        int height = 1 + Math.max(leftHeight, rightheight);
            // 1 is added to include that node

        return height;
    }
}
/* Height and Depth of tree are equal. but height and depth of a node are different. Height is measured from 
   the bottom and depth is measured from the top.
*/
