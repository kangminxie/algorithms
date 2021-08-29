package main.java.com.kangmin.datastructure.stack;

public class ListNode<T> {

    T val;
    ListNode<T> next;

    ListNode(T x) {
        this.val = x;
        this.next = null;
    }

    ListNode(T x, ListNode<T> nextNode) {
        this.val = x;
        this.next = nextNode;
    }
}
