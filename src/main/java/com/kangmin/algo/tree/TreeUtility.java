package com.kangmin.algo.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utility.ListNode;

class TreeUtility {

	/**
	 * method to populate a binary search tree from an array
	 * @param a an int array
	 * @return root node of the tree
	 */
	private static TreeNode generateBSTfromArray(int[] a) {
		if (a == null || a.length == 0) {
			return null;
		}
		Arrays.sort(a);
		int[] currentIndex = new int[1]; // {0}, so that it is cited by reference
		return sortedArrayToBST(a, 0, a.length - 1, currentIndex);
	}

	/**
	 * enhanced method to populate a binary search tree from an sub-array
	 * @param a an int array
	 * @return root node of the tree
	 */
    private static TreeNode sortedArrayToBST(int[] a, int start, int end, int[] currentIndex) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode left = sortedArrayToBST(a, start, mid - 1, currentIndex);
        TreeNode root = new TreeNode(a[currentIndex[0]]);
        //System.out.println("Created a TreeNode with value: " + a[current[0]]);
        currentIndex[0]++;
        TreeNode right = sortedArrayToBST(a, mid + 1, end, currentIndex);

        root.left = left;
        root.right = right;
        return root;
    }


    private static ListNode current = null;

    private static TreeNode generateBSTfromLinkedList(ListNode head) {
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


    private static List<List<Integer>> levelOrderTraversal(TreeNode root) {

        List<List<Integer>> rtLL = new ArrayList<>();
        if (root == null) return rtLL;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = queue.poll();		//queue.remove, dequeue
                assert tempNode != null;
                currLevel.add(tempNode.val);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null)	queue.offer(tempNode.right);
            }
            rtLL.add(currLevel);
        }
        return rtLL;
    }

	private static ListNode generateLinkedListFromArray(int[] a) {
		if (a == null || a.length == 0) {
			return null;
		}
		ListNode dummyHead = new ListNode(0);
		ListNode curr = dummyHead;
        for (int value : a) {
            curr.next = new ListNode(value);
            curr = curr.next;
        }
		return dummyHead.next;
	}

    public static void main(String[] args) {
    	int[] a = new int[] {5,6,2,1,3,7,4};
    	TreeNode root = generateBSTfromArray(a);
    	List<List<Integer>> list = levelOrderTraversal(root);
    	System.out.println("Testing tree from Array");
    	System.out.println(list);

    	//Integer[] A = new Integer[] {5,6,2,1,3,7,4};
    	//List<Integer> fixedList = new ArrayList<Integer>(Arrays.asList(A));

    	ListNode head = generateLinkedListFromArray(a);
    	TreeNode node = generateBSTfromLinkedList(head);
    	List<List<Integer>> list2 = levelOrderTraversal(node);
    	System.out.println("Testing tree from LinkedList");
    	System.out.println(list2);
    }
}
