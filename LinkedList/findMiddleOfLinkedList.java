package LinkedList;

public class findMiddleOfLinkedList {
    public static void main(String[] args) {
        DemoLinkedList list = new DemoLinkedList();
        list.push(9);
        list.push(8);
        list.push(3);
        list.push(5);
        list.push(2);
        //list.push(1);

        list.display(list.head);
        System.out.println();
        int res = findMiddle(list.head);
        System.out.println(res);
    }

    private static int findMiddle(DemoLinkedList.Node head) {
        DemoLinkedList.Node slow = head;
        DemoLinkedList.Node fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
    }

}

/* Iterative solution is using slow and fast pointers. when it comes out of loop, slow will point to
   middle element.
*/
