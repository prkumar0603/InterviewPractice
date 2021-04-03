package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* Given a binary tree, delete a node from it by making sure that tree shrinks from the bottom
(i.e. the deleted node is replaced by bottom most and rightmost node). This different
from BST Deletion. Here we do not have any order among elements, so we replace with last element.
Examples :
Delete 10 in below tree
       10
     /    \
    20     30
Output :
       30
     /
    20

Delete 20 in below tree
       10
     /    \
    20     30
            \
            40
Output :
       10
     /   \
    40    30
*/
public class DeleteInBinaryTree {
    public static void main(String[] args) {
        demoNode root = new demoNode(10);
        root.left = new demoNode(20);
        root.right = new demoNode(30);

        root.right.right = new demoNode(40);

        System.out.print("Before -> ");
        printLevelOrder(root);
        int val = 20;
        // deleteNodeInTwoTraversal(root, val);    // first update node to delete, then deletes node
        deleteNodeInOneTraversal(root, val);
        System.out.print("After -> ");
        printLevelOrder(root);
    }

    private static void deleteNodeInOneTraversal(demoNode root, int k) {
        if (root == null)
            return;

        demoNode delNode = null;
        demoNode lastNode = null;
        demoNode leftNode = null;
        demoNode rightNode = null;

        Queue<demoNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            lastNode = q.poll();

            if (lastNode.val == k){
                delNode = lastNode;
            }

            if (lastNode.left != null){
                q.add(lastNode.left);
                leftNode = lastNode;    // left side of this has value
                rightNode = null;       // making right null
            }
            if (lastNode.right != null){
                q.add(lastNode.right);
                rightNode = lastNode;   // right side of this has value
                leftNode = null;        // making left null
            }
        }

        if (delNode!= null){
            delNode.val = lastNode.val;
            if (leftNode!= null){
                leftNode.left = null;
            }
            if (rightNode != null){
                rightNode.right = null;
            }
        }
    }

    private static void deleteNodeInTwoTraversal(demoNode root, int k) {
        if (root == null){
            return ;
        }

        demoNode delNode = null;
        demoNode lastNode = null;

        Queue<demoNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            lastNode = q.poll();

            if (lastNode.val == k){
                delNode = lastNode;
            }

            if (lastNode.left != null)
                q.add(lastNode.left);

            if (lastNode.right != null)
                q.add(lastNode.right);
        }

        if (delNode!=null){
            delNode.val = lastNode.val;
        }

        // --- deleting last node ->
        deleteLastNode(root, lastNode);
    }

    private static void deleteLastNode(demoNode root, demoNode lastNode) {
        Queue<demoNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            demoNode current = q.poll();

            if (current.left == lastNode){
                current.left = null;
                return;
            }
            else
                q.add(current.left);

            if (current.right == lastNode) {
                current.right = null;
                return;
            }
            else
                q.add(current.right);
        }
    }

    private static void printLevelOrder(demoNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<demoNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> currentList = new ArrayList<>();
            for (int i=0;i<size;i++){
                demoNode temp = q.poll();
                currentList.add(temp.val);

                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            result.add(currentList);
        }
        System.out.println(result);
    }
}
