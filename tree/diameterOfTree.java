package tree;

public class diameterOfTree {
    public static void main(String[] args) {
        demoNode root = new demoNode(1);
        root.left = new demoNode(2);
        root.right = new demoNode(3);
        root.left.left = new demoNode(4);
        root.left.right = new demoNode(5);
        // root.right.right = new demoNode(6);

        int res = btreeDiam(root);
        System.out.println(res);
    }

    private static int btreeDiam(demoNode root) {
        // base case
        if (root == null)
            return 0;

        // hypothesis
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        int lDiam = btreeDiam(root.left);
        int rDiam = btreeDiam(root.right);
            // that node in the answer , that node not in the answer
        return Math.max(lHeight+rHeight+1, Math.max(lDiam,rDiam));
    }

    private static int height(demoNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }


}
