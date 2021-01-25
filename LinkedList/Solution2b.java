import java.util.HashSet;
/*Write a program that checks whether a given Linked List contains loop .
 Follow up :  if loop is present then removes the loop. 
 */
public class Solution2b {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        DemoLinkedList list = new DemoLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.insert(60);


        list.display(list.head);
        //System.out.println(list.head.next.next.next.next.data);
        //create loop
        list.head.next.next.next.next.next.next = list.head.next.next;

        //System.out.println(list.head.next.next.next.next.next.data);

        //detect loop
		/*if(list.detect_loop_using_HashSet(list.head))
			System.out.println("loop present");
		else
			System.out.println("no loop present");*/

        list.detect_loop(list.head);
        list.display(list.head);
        list.detect_loop(list.head);
    }

}
class DemoLinkedList{
    //creating node
    Node head;
    class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    //inserting nodes
    public void insert(int d){
        Node node = new Node(d);
        if(head== null){
            head = node;
        }
        else{
            Node temp = head;
            while(temp.next !=null){
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void detect_loop(Node node) {
        int count = 0;
        //tortoise and rabbit method
        Node slow = node;
        Node fast = node;

        while(fast!= null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                count = 1;
                System.out.println("loop present");
                removeloop(slow);
                break;
            }
        }
        if(count == 0)
            System.out.println("no loop present");

    }

    private void removeloop(Node node) {
        //move equal distance from head and the node at which slow=fast.
        Node temp = head;
        while(temp.next != node.next){
            temp = temp.next;
            node = node.next;
        }
        node.next = null;
    }

    public boolean detect_loop_using_HashSet(Node head) {
        //HashMap is used for mapping of two things. HashSet is used for only one thing.
        HashSet<Node> hs = new HashSet<>();
        while(head != null){
            if(hs.contains(head))
                return true;

            hs.add(head);

            head = head.next;
        }
        return false;
    }

    public void display(Node node){
        System.out.println("Current list");
        Node temp = node;
        while(temp != null){
            System.out.print(temp.data+"\t");
            temp = temp.next;
        }
        System.out.println();
    }
}