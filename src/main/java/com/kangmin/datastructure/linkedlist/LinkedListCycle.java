package main.java.com.kangmin.datastructure.linkedlist;

public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        // deal with one element case
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast, slow;
        fast = head;
        slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                System.out.println("slow and fast meet at: " + slow.val);
                break;
            }
        }
        if (fast.next == null || fast.next.next == null) {
            return null;
        }

        // slow and fast meet
        // fast finished the ring pace, 2*S = D + T + Cycle and S = D + T, (Cycle = D+T)
        // 0 + D - > meet @ (Cylec - D + D)
        // head --------==========
        // = =
        // ==========
        ListNode rtNode = head;
        while (rtNode != slow) {
            rtNode = rtNode.next;
            slow = slow.next;
        }
        return rtNode;
    }

    public static void main(String[] args) {
        ListNode generated = ListUtility.generateLinkedListFromArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        ListNode tail = ListUtility.getTailNode(generated);
        ListUtility.printLinkedList(generated);

        tail.next = generated.next.next;
        System.out.println("tail val:" + tail.val);
        System.out.println("tail next:" + tail.next.val);

        ListNode joint = detectCycle(generated);
        System.out.println(joint.val);
    }
}
