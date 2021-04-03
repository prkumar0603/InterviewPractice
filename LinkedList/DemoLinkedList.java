package LinkedList;

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
