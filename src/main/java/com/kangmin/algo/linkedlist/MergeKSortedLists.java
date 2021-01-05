package com.kangmin.algo.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

    public static ListNode mergeKListsPQ(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        Queue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode a, ListNode b) {
				return a.val - b.val;
			}

        });
        // initialize the pq
        for (ListNode each : lists) {
        	pq.add(each);
        }

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        while (!pq.isEmpty()) {
        	ListNode top = pq.poll();
        	curr.next = new ListNode(top.val);
        	curr = curr.next;
        	if (top.next != null) {
        		pq.add(top.next);
        	}
        }
        return dummyHead.next;
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeHelper(lists, 0, lists.length - 1);
    }

    private ListNode mergeHelper(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return dummy.next;
    }


	public static void main(String[] args) {
		ListNode l1 = ListUtility.generateLinkedListFromArray(new int[] {2,7,8,10});
		ListNode l2 = ListUtility.generateLinkedListFromArray(new int[] {1,9,12,16});
		ListNode l3 = ListUtility.generateLinkedListFromArray(new int[] {3,4,11,14});
		ListNode l4 = ListUtility.generateLinkedListFromArray(new int[] {0,5,6,15});
		ListNode[] lists = new ListNode[4];
		lists[0] = l1;
		lists[1] = l2;
		lists[2] = l3;
		lists[3] = l4;
		ListNode merged = mergeKListsPQ(lists);
		ListUtility.printLinkedList(merged);
	}

}
