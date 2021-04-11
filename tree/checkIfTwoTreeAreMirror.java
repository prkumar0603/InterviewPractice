package tree;

import java.util.Stack;
public class checkIfTwoTreeAreMirror {
    public static void main(String[] args) {
        demoNode root = new demoNode(1);
        root.left = new demoNode(3);
        root.right = new demoNode(2);
        root.right.left = new demoNode(5);
        root.right.right = new demoNode(4);

        demoNode root1 = new demoNode(1);
        root1.left = new demoNode(2);
        root1.right = new demoNode(3);
        root1.left.left = new demoNode(4);
        root1.left.right = new demoNode(5);

//        boolean res =checkRec(root, root1);
//        System.out.println(res);

        String res1 = findByInorder(root,"");
        int i=0; int j=res1.length()-1;
        char[] ch = res1.toCharArray();
        while(i<j){
            char x = ch[i];
            ch[i++] = ch[j];
            ch[j--] = x;
        }
        res1 = String.valueOf(ch);
        String res2 = findByInorder(root1,"");

        System.out.println(res1.equals(res2));
    }

    private static String findByInorder(demoNode root, String out) {
        if (root == null)
            return "";

        Stack<demoNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            out += root.val;
            root = root.right;
        }
        return out;
    }

    private static boolean checkRec(demoNode root, demoNode root1) {
        // if both are null
        if (root==null && root1==null)
            return true;

        // if only one is null
        if (root==null || root1==null)
            return false;

        return (root.val == root1.val) &&
                checkRec(root.left, root1.right) &&
                checkRec(root.right, root1.left);
    }
}
/* find preorder of 1st tree and its reverse should be equal to postorder of 2nd tree.
   find inorder of 1st tree and its reverse should be equal to inorder of 2nd tree.
*/