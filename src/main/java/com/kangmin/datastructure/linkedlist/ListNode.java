package main.java.com.kangmin.datastructure.linkedlist;

public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
        this.next = null;
    }

    /*
        Prove a copy of reference will be created and the raw one does not change
     */
    static void printList(ListNode aNode) {
        System.out.println(">>> aNode's address is: " + aNode);
        System.out.print(">>> Print List: ");
        while (aNode != null) {
            System.out.print(aNode.val + " -> ");
            aNode = aNode.next;
        }
        System.out.print("null\n");
        System.out.println(">>> aNode's address is: " + aNode + "\n");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);

        System.out.println("head's address is: " + head);
        System.out.println("head's value is: " + head.val);
        System.out.println("============= Section 1 ===================\n");

        head.next = n1;
        n1.next = n2;

        printList(head);

        System.out.println("head's address is: " + head);
        System.out.println("head's value is: " + head.val);
        System.out.println("============= Section 2 ===================\n");

        printList(head);

        System.out.println("head's address is: " + head);
        System.out.println("head's value is: " + head.val);
        System.out.println("============= Section 3 ===================\n");
    }
}
