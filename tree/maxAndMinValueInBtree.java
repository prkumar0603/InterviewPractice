package tree;

import java.util.LinkedList;
import java.util.Queue;

public class maxAndMinValueInBtree {
    public static void main(String[] args) {
        demoNode root = new demoNode(8);
        root.left = new demoNode(2);
        root.right = new demoNode(28);
        root.right.left = new demoNode(3);
        root.right.right = new demoNode(9);

        int res = calcMax(root);
        System.out.println("max = "+res);
        calcMin(root);
    }

    private static int calcMax(demoNode root) {
        if (root == null)
            return Integer.MIN_VALUE;

        int max = root.val; // store current value as max
        int left = calcMax(root.left);
        int right = calcMax(root.right);

        // check max after recursion
        if(left > max)
            max = left;
        if (right > max)
            max = right;

        return max;
    }

    //using level order
    private static void calcMin(demoNode root) {
        if (root == null)
            return;

        Queue<demoNode> q = new LinkedList<>();
        q.add(root);
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()){
            int size = q.size();

            for (int i=0;i<size;i++){
                demoNode temp = q.poll();
                min = Math.min(temp.val, min);

                if (temp.left!=null)
                    q.add(temp.left);

                if (temp.right!=null)
                    q.add(temp.right);
            }
        }
        System.out.println("min = "+ min);
    }

}
