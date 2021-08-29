package main.java.com.kangmin.datastructure.linkedlist;

public class ReverseLinkedList {

    // first version
    // need prev and post
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode post = head.next;
        while (post != null) {
            head.next = prev;
            prev = head;
            head = post;
            post = post.next;
        }

        head.next = prev;
        return head;
    }


    // second version
    // just need newHead, and temp Head in while loop
    // actually same concept as the first version, return "prev"
    public static ListNode reverseListII(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null;
        while (head != null) {
            ListNode post = head.next;
            head.next = newHead;
            newHead = head;
            head = post;
        }
        return newHead;
    }

    // recursion
    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode post = head.next;
        ListNode newHead = reverseListRecursive(head.next);
        post.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode generated = ListUtility.generateLinkedListFromArray(new int[] {1,2,3,4});
        ListUtility.printLinkedList(generated);

        ListNode reversed = reverseList(generated);
        ListUtility.printLinkedList(reversed);

        ListNode recovered = reverseListII(reversed);
        ListUtility.printLinkedList(recovered);

        ListNode reversed2 = reverseListRecursive(recovered);
        ListUtility.printLinkedList(reversed2);
    }
}
