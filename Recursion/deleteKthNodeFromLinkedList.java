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
    private static DemoLinkedList.Node solve(DemoLinkedList.Node start, int k) {
        if (k < 1)
            return start;

        if (start == null) {
            System.out.println("List is Empty or limit crossed");
            return null;
        }

        if (k==1){
            DemoLinkedList.Node res = start.next;
            return res;
        }

        start.next = solve(start.next, k-1);
        return start;
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
