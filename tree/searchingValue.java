package tree;

public class searchingValue {
    public static void main(String[] args) {
        demoNode root = new demoNode(3);
        root.left = new demoNode(9);
        root.right = new demoNode(20);
        root.left.left = new demoNode(32);
        root.left.right = new demoNode(3);
        root.right.left = new demoNode(15);
        root.right.right = new demoNode(7);

        int k = 15;
        boolean res = findNodePreOrder(root, k);
        System.out.println(res);
    }

    // preorder
    private static boolean findNodePreOrder(demoNode root, int k) {
        if (root == null)
            return false;

        if (root.val == k)      //since preorder, so first checking
            return true;

        boolean res1 = findNodePreOrder(root.left, k);
        if (res1)       // here conditional return coz we need to check right side also
            return res1;

        boolean res2 = findNodePreOrder(root.right,k);
        return res2;
    }
}
/* we can also use inorder and postorder and levelorder for searching.
*/