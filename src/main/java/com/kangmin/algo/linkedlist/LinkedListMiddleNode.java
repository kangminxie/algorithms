package com.kangmin.algo.linkedlist;

public class LinkedListMiddleNode {

    public static ListNode getMiddleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode getMiddleNodeII(ListNode head) {
        // non-empty, head is not null
        if (head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // If there are two middle nodes, return the second middle node.
        if (fast.next == null) {
            return slow;
        }
        return slow.next;
    }
}
