//Problem Statement : A linked list : 1->2->3->4->5->6->7 is given.
// rearrange the list : 1->7->2->6->3->5->4

public class Solution2a {

    public static void main(String[] args) {

        LinkedList1 list = new LinkedList1();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.insert(60);
        list.insert(70);

        list.print();
        list.rearrange();
        list.print();
    }

}
class LinkedList1{

    //creating list
    Node head;
    class Node{
        int data;
        Node next;
        Node(int d){
            this.data = d;
            next = null;
        }
    }

    //insert elements to list
    public void insert(int d){
        Node node = new Node(d);
        if(head == null)
            head = node;
        else{
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;

            temp.next = node;
            //System.out.println("node created = "+d);
        }
    }

    //print the list
    public void print() {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    //rearrange the list
    public void rearrange(){

        //finding the middle element
        Node slow = head;
        Node fast = slow.next;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        //System.out.println("slow.data gives middle element = "+slow.data);

        //break into two list
        Node node1 = head;
        Node node2 = slow.next;
        slow.next = null;

        //reverse the second linked list
        node2 = reverseiter(node2);

        //merging alternate nodes
        Node curr = new Node(0);
        while(node1 != null || node2 != null){
            if(node1!=null){
                curr.next = node1;
                node1 = node1.next;
                curr = curr.next;
                curr.next = null;
            }
            //print(curr);
            if(node2!=null){
                curr.next = node2;
                node2 = node2.next;
                curr = curr.next;
                curr.next = null;
            }
            //print(curr);
        }
    }

    //iterative reverse of linked list
    private Node reverseiter(Node head) {
        Node prev = null;
        Node next = null;
        Node curr = head;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;   // for reversing the links backward
            prev = curr;
            curr = next;
        }
        head = prev;

        return head;
    }

    //recursive reverse of linked list
    static Node newhead;;
    private Node reverserec(Node head){
        if(head.next == null)
        {
            newhead = head;
            return head;
        }
        reverserec(head.next);
        Node q = head.next;		//the next node of node2 is q
        q.next = head;
        head.next = null;

        return newhead;
    }
}

/* Approach is in 3 steps.
    step 1 - find the middle element of linked list and break list into 2 parts.
    step 2 - reverse the 2nd part of linked list.
    step 3 - merge the alternate nodes of both the list.

    reverse a linkedlist -
    3 pointer prev, current and next in which prev and next are null and current is head.
 */