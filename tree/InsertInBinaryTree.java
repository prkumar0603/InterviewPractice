package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a binary tree and a key, insert the key into the binary tree at the first position available 
in level order traversal.
*/
public class InsertInBinaryTree {

    public static void main(String[] args) {
        demoNode root = new demoNode(10);
        root.left = new demoNode(11);
        root.right = new demoNode(9);

        root.left.left = new demoNode(7);
        root.right.left = new demoNode(15);
        root.right.right = new demoNode(8);

        List<List<Integer>> listBefore = printLevelOrder(root);
        System.out.println(listBefore);
        
        // insert 12 at the correct position
        int val = 12;
        insertNode(root, val);
        List<List<Integer>> listAfter = printLevelOrder(root);
        System.out.println(listAfter);

    }

    // for printing the tree
    private static List<List<Integer>> printLevelOrder(demoNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<demoNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> currentList = new ArrayList<>();
            for (int i =0;i<size;i++){
                demoNode current = q.poll();
                currentList.add(current.val);

                if (current.left!= null)
                    q.add(current.left);
                if (current.right!=null)
                    q.add(current.right);
            }
            result.add(currentList);
        }
        return result;
    }

    private static void insertNode(demoNode root, int val) {
        if (root == null){
            root = new demoNode(val);
            return;
        }

        Queue<demoNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            demoNode temp = q.poll();

            if (temp.left == null){
                temp.left = new demoNode(val);
                return;
            }
            else{
                q.add(temp.left);
            }
            if (temp.right == null){
                temp.right = new demoNode(val);
                return;
            }
            else{
                q.add(temp.right);
            }

        }
    }
}