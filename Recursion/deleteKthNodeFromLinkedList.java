package recursion;
/* Given a singly linked list delete node at k-th position without using loop.
Examples:
Input : list = 9->8->3->5->2->1
          k = 4
Output : 9->8->3->2->1
Input  : list = 0->0->1->6->2->3
            k = 3
Output : 0->0->6->2->3
*/
public class deleteKthNodeFromLinkedList {
    public static void main(String[] args) {
        DemoLinkedList list = new DemoLinkedList();
        list.push(9);
        list.push(8);
        list.push(3);
        list.push(5);
        list.push(2);
        list.push(1);

        list.display(list.head);
        System.out.println();
        int k = 7;
        DemoLinkedList.Node res = solve(list.head, k);
        list.display(res);

    }

    /*Approach - recursively reduce value of k. When k reaches 1, we delete current node
    and return next of current node as new node
    */
    private static DemoLinkedList.Node solve(DemoLinkedList.Node head, int k) {
        if (k < 1)
            return head;

        if (head == null) {
            System.out.println("List is Empty or limit crossed");
            return null;
        }

        if (k==1){
            head.val = head.next.val;       // putting next node value in current node
            head.next = head.next.next;     // removing next node
            return head;
//            DemoLinkedList.Node res = head.next;
//            return res;
        }

        head.next = solve(head.next, k-1);  // if stored to head, then head will get changed.
        // thats why stored to head.next
        return head;
    }

}
class DemoLinkedList{
    Node head;
    class Node{
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            next = null;
        }
    }

    public void push(int d){
        Node node = new Node(d);
        if (head == null)
            head = node;
        else{
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }

    public void display(Node t){
        Node temp = t;
        while(temp != null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
    }
}
