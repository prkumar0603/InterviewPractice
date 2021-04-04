package tree;

public class recTreeTraversal {
    public static void main(String[] args) {
        demoNode root = new demoNode(5);
        root.left = new demoNode(3);
        root.right = new demoNode(2);
        root.left.left = new demoNode(7);
        root.left.right = new demoNode(6);
        root.right.left = new demoNode(4);
        root.right.right = new demoNode(8);

        System.out.print("Pre Order -> ");
        recPreOrder(root);
        System.out.println();
        System.out.print("In Order ->");
        recInOrder(root);
        System.out.println();
        System.out.print("Post Order ->");
        recPostorder(root);
    }

    private static void recPreOrder(demoNode root) {
        if (root == null)
            return;

        System.out.print(root.val+" ");
        recPreOrder(root.left);
        recPreOrder(root.right);
    }

    private static void recInOrder(demoNode root) {
        if (root== null)
            return;

        recInOrder(root.left);
        System.out.print(root.val+" ");
        recInOrder(root.right);
    }

    private static void recPostorder(demoNode root) {
        if (root == null)
            return;

        recPostorder(root.left);
        recPostorder(root.right);
        System.out.print(root.val+" ");
    }
}
