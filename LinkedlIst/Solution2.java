/*Problem Statement: Find Nth last element of a linked list. For  example, in list 1->2->5->4->null 3rd last element is 2
Follow-Up Question   : Do the same in a single iteration.
Follow-Up Question 2: Present Linked list as other data structures (stack, queue, tree, graph)
*/
import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
    
        DemoLinkedList list = new DemoLinkedList();
        list.insertNode(1);
        list.insertNode(5);
        list.insertNode(12);
        list.insertNode(19);
        list.insertNode(25);
        list.printNode();

        System.out.println();
        list.printNthNodeUsingFormula(3);
        
        list.printNthNodeUsingTwoPointer(3);
    }

}

class DemoLinkedList{

    Node head;

    // nth node from last = Total - n +1 node from beginning
    public void printNthNodeUsingFormula(int num) {
        int len = 0;
        Node temp = head;

        while(temp!=null){
            len++;
            temp = temp.next;
        }

        if (len < num)
            return;

        temp = head;
        for (int i=1;i<len-num+1;i++)   //note here start from 1
            temp = temp.next;

        System.out.println("Nth value by formula = "+temp.data);
    }

    // move ref_ptr n positions, then move both the pointers until ref_ptr reaches null
    public void printNthNodeUsingTwoPointer(int num) {
        Node ref_ptr = head;
        Node main_ptr = head;

        for (int i = 0; i < num; i++) {
            if (ref_ptr == null) {
                    System.out.println("N is greater than number of nodes");
                    return;
            }

            ref_ptr = ref_ptr.next;
        }

        while(ref_ptr!=null){
            ref_ptr = ref_ptr.next;
            main_ptr = main_ptr.next;
        }
        System.out.println("Nth value by two pointer = "+main_ptr.data);

    }

    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }

    public void insertNode(int v){
        Node node = new Node(v);

        if (head == null){
            head = node;
        }
        else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void printNode(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }

}
