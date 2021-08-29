package main.java.com.kangmin.datastructure.linkedlist;

public class FindMiddleNode {

    // two middles, return the first one
    // middle can be defined as length / 2
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.next.next == null) {
            return head.next;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    // two middles, return the second one
    // middle can be defined as (length + 1) / 2, treat last null as a node
    public ListNode middleNode2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.next.next == null) {
            return head.next;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast.next == null) {
            return slow;
        }
        return slow.next;
    }
}
