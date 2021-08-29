package main.java.com.kangmin.datastructure.linkedlist;

public class ReverseLinkedListPartial {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode tempBreak = ListUtility.getKthNode(dummyHead, m - 1);
        ListNode positionM = tempBreak.next;
        ListNode positionN = ListUtility.getKthNode(positionM, n - m);
        ListNode tempBreak2 = positionN.next;

        tempBreak.next = null;
        positionN.next = null;

        tempBreak.next = reverseList(positionM);
        ListNode temp = tempBreak;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = tempBreak2;
        return dummyHead.next;
    }

	public static ListNode reverseBetweenII(ListNode head, int m, int n) {
		// m,n index from 1
		// Input: 1->2->3->4->5->NULL, m = 2, n = 4
		// Output: 1->4->3->2->5->NULL

		if (head == null || head.next == null) {
			return head;
		}

	    ListNode dummyHead = new ListNode(0);
	    dummyHead.next = head;

	    // prev is the (m-1)th node
	    // curr will point to the starting
	    ListNode prev = dummyHead;
	    ListNode curr = head;
	    int index = 1;
	    while (index < m) {
	        curr = curr.next;
	        prev = prev.next;
	        index++;
	    } // until index == m

	    // end is the nth node
	    ListNode post = curr.next;

	    index = m + 1;
	    while (index <= n) {
	        curr.next = post.next;  //   prev -> curr -> post
	        post.next = prev.next;
	        prev.next = post;
	        post = curr.next;
	        index++;
	    }

	    return dummyHead.next;
	}


	public static ListNode reverseBetweenIII(ListNode head, int m, int n) {
		// m,n index from 1
		// Input: 1->2->3->4->5->NULL, m = 2, n = 4
		// Output: 1->4->3->2->5->NULL

		if (head == null || head.next == null) {
			return head;
		}

	    ListNode dummyHead = new ListNode(0);
	    dummyHead.next = head;

	    // prev is the (m-1)th node
	    // curr will point to the starting
	    ListNode prev = dummyHead;
	    ListNode curr = head;
	    for (int i = 1; i < m; i++) {
	        curr = curr.next;
	        prev = prev.next;
	    }

	    // end is the nth node
	    ListNode post = curr.next;
	    for (int j = m ; j < n; j++) { // gap is okay after m, (n - m) need reverse
	        curr.next = post.next;  //   prev -> curr -> post
	        post.next = prev.next;
	        prev.next = post;
	        post = curr.next;
	    }
	    return dummyHead.next;
	}

	public static void main(String[] args) {
		ListNode generated = ListUtility.generateLinkedListFromArray(new int[] {1,2,3,4,5,6,7,8});
		ListUtility.printLinkedList(generated);
		//ListUtility.printList(reverseBetween(generated, 2, 4));
		ListUtility.printLinkedList(reverseBetweenIII(generated, 3, 6));
	}


	private static ListNode reverseList(ListNode head) {
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

}
