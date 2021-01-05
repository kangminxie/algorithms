package com.kangmin.algo.tree;

public class GenerateBSTfromLinkedList {

    private static ListNode current = null;

    public static TreeNode generateBSTfromLinkeList(ListNode head) {
        if (head == null) {
            return null;
        }
        current = head;
        int len = getLength(head);
        return sortedListToBST(0, len - 1);
    }

    // get list length
    private static int getLength(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    // build tree bottom-up
    private static TreeNode sortedListToBST(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        TreeNode left = sortedListToBST(start, mid - 1);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBST(mid + 1, end);

        root.left = left;
        root.right = right;
        return root;
    }
}
