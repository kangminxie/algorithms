package com.kangmin.algo.csce.linkedlist;

public class GenLinkedList<T> {

    private class ListNode {

        private T data;
        private ListNode link;

        public ListNode(T data, ListNode link) {
            this.data = data;
            this.link = link;
        }
    }

    private ListNode head;
    private ListNode current;
    private ListNode previous;

    public GenLinkedList() {
        head = current = previous = null;
    }

    public void goToNext() {
        if (current != null && current.link != null) {
            previous = current;
            current = current.link;
        }
    }

    public void goToPrev() {
        if (current != head && current != null) {
            current = previous;
            previous = head;
            while (previous.link != current) {
                previous = previous.link;
            }
        } else if (current == head) {
            System.out.println("Can't go to previous, current is head!");
        } else {
            System.out.println("Out of bound!");
        }
    }

    public T getDataAtCurrent() {
        if (current.link != null)
            return current.data;
        else
            return null;
    }

    public void setDataAtCurrent(T newData) {
        if (current != null)
            current.data = newData;
    }

    public void insert(T newData) {
        ListNode newNode = new ListNode(newData, null);
        if (head == null) {
            head = newNode;
            current = head;
            return;
        }
        ListNode temp = head;
        while (temp.link != null) {
            temp = temp.link;
        }
        temp.link = newNode;
    }

    public void insertAfterCurrent(T newData) {
        ListNode newNode = new ListNode(newData, null);
        if (current != null) {
            newNode.link = current.link;
            current.link = newNode;
        } else if (head != null) {
            System.out.println("Current iterated too far.");
        } else {
            System.out.println("Trying to insert in an empty List.");
        }
    }

    public void deleteCurrentNode() {
        if ((current != null) && (previous != null)) {
            previous.link = current.link;
            current = current.link;
        } else if (current != null) {
            head = current.link;
            current = head;
        } else {
            System.out.println("Can't delete from an empty List.");
        }
    }

    public void showList() {
        ListNode temp = head;
        System.out.println("\nPrinting List!");
        int i = 1; // start the task label from 1.
        while (temp != null) {
            System.out.println(i + "." + "\t" + temp.data);
            i++;
            temp = temp.link;// point to next item
        }
        System.out.println("Done printing List!\n");
    }

    public boolean moreToIterate() {
        return current != null;
    }

    public void resetIterate() {
        current = head;
    }

    public static void main(String[] args) {

        GenLinkedList<Integer> list = new GenLinkedList<>();
        System.out.println("Now populating our initial linked-list");

        list.goToNext();    // head -> null
        System.out.println(list.moreToIterate());
        System.out.println("Current data is: " + list.getDataAtCurrent());  // -1

        list.insert(1);    // head -> 1, current is head
        list.insert(2);
        list.insert(5);
        list.insert(15);
        list.insert(88);
        list.insert(3);
        list.insert(8);
        list.insert(99);
        list.insert(4);
        list.showList();     // head -> 1 -> 2 -> .... 4, current is head

        list.setDataAtCurrent(666);  //  head -> 666 -> 2 -> .... 4, current is head
        list.goToPrev();    // Can't go to previous, current is head!
        list.deleteCurrentNode();   //  666 deleted, head -> 2 -> .... 4, current is head (2)
        list.insertAfterCurrent(777);
        list.showList(); //  head -> 2 -> 777 -> .... 4, current is head
        list.resetIterate();
    }
}
