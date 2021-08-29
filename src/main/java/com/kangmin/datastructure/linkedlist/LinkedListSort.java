package main.java.com.kangmin.datastructure.linkedlist;

public class LinkedListSort {

    public static ListNode sortList(ListNode head) {
        // deal with the case, size = 0 or size = 1;
        if (head == null || head.next == null) {
            return head;
        }

        // now size is more than two
        // middleNode.next will exist
        ListNode middleNode = getMiddleNode(head);

        // break list and do sort individual
        ListNode rightSideList = middleNode.next;
        middleNode.next = null;
        ListNode newLeftHead = sortList(head);
        ListNode newRightHead = sortList(rightSideList);

        // we already now how to merge to List
        ListNode newHead = mergeTwoLists(newLeftHead, newRightHead);
        return newHead;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode tempHead = new ListNode(0);
        ListNode curr = tempHead;
        // if do not break l1 and l2, create new
        ListNode a = l1;
        ListNode b = l2;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                curr.next = new ListNode(a.val);
                a = a.next;
            } else { // a.val > b.val
                curr.next = new ListNode(b.val);
                b = b.next;
            }
            curr = curr.next;
        }

        if (a == null) {
            curr.next = b;
        } else {
            curr.next = a;
        }
        return tempHead.next;
    }

    public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    private static ListNode getMiddleNode(ListNode head) {
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
}
