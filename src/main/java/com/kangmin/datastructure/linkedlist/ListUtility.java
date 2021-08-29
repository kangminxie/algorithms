package main.java.com.kangmin.datastructure.linkedlist;

/*
    My LinkedList Utility Class
 */
public class ListUtility {

    /**
     * Take the head and print out all elements of the list
     *
     * @param head the head Note of a LinkedList
     */
    public static void printLinkedList(ListNode head) {
        if (head == null) {
            System.out.println("Empty list");
        }

        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println("null");
    }


    public static ListNode generateLinkedListFromArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        final ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        for (int value : arr) {
            curr.next = new ListNode(value);
            curr = curr.next;
        }
        return dummyHead.next;
    }

    // assume k is valid
    public static ListNode getKthNode(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        if (k == 0) {
            return head;
        }

        ListNode curr = head;
        while (curr != null && k > 0) {
            k = k - 1;
            curr = curr.next;
        }
        return curr;
    }

    public static ListNode getTailNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }

    /*
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: Nth to last node of a singly linked list.
     */
    public ListNode nthToLast(ListNode head, int n) {
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode removeElements(ListNode head, int val) {
        // if val always non-negative
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        // double pointer
        ListNode curr = head;
        ListNode prev = dummyHead;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummyHead.next;
    }

    public ListNode removeElementsII(ListNode head, int val) {
        // find the first element that not equals to val
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }

        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val != val) { // good node, keep
                prev = curr;
            } else { // bad node, pass
                prev.next = curr.next;
            }
            curr = curr.next;
        }
        return head;
    }

    public static ListNode removeElementsRecursive(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        head.next = removeElementsRecursive(head.next, val);
        return head.val == val ? head.next : head;
    }


    public static void main(final String[] args) {
        int[] myIntArr = {4, 1, 5, 3, 2};
        final ListNode head = generateLinkedListFromArray(myIntArr);
        ListUtility.printLinkedList(head);
        //4->1->5->3->2->null
    }
}
