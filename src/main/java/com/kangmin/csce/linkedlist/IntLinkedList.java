package main.java.com.kangmin.csce.linkedlist;

public class IntLinkedList {

    private static class ListNode {

        private int data;
        private ListNode link;

        ListNode(int aData, ListNode aLink) {
            this.data = aData;
            this.link = aLink;
        }
    }

    private ListNode head;
    private ListNode current;
    private ListNode previous;

    IntLinkedList() {
        head = current = previous = null;
    }

    void goToNext() {
        if (current != null && current.link != null) {
            previous = current;
            current = current.link;
        } else {
            System.out.println("*** Current is null or next is null, not moved");
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
            System.out.println("*** Can't go to previous, current is head!");
        } else {
            System.out.println("*** Out of bound!");
        }
    }

    int getDataAtCurrent() {
        if (current != null) {
            return current.data;
        }
        System.out.println("*** Empty List => default value is -1");
        return -1;
    }

    public void setDataAtCurrent(int aData) {
        if (current != null) {
            current.data = aData;
        }
    }

    void addItem(int newData) {
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

    public void insertAfterCurrent(int newData) {
        ListNode newNode = new ListNode(newData, null);
        if (current != null) {
            newNode.link = current.link;
            current.link = newNode;
        } else if (head != null) {
            System.out.println("*** Current iterated too far.");
        } else {
            System.out.println("*** Trying to insert in an empty List.");
        }
    }

    public void deleteCurrent() {
        if ((current != null) && (previous != null)) {
            previous.link = current.link;
            current = current.link;
        } else if (current != null) {
            head = current.link;
            current = head;
        } else {
            System.out.println("*** Can't delete from an empty List.");
        }
    }

    void showList() {
        ListNode temp = head;
        System.out.println("\n===> Printing List!");
        int i = 1; // start the task label from 1.
        while (temp != null) {
            System.out.println("position" + i + ":" + "\t" + temp.data);
            i++;
            temp = temp.link;
        }
        System.out.println("<=== Done with printing List!\n");
    }

    public static void main(String[] args) {

        IntLinkedList list = new IntLinkedList(); // head -> null
        System.out.println("Now populating our initial linked-list");

        list.goToNext();    // head -> null
        System.out.println("Current data is: " + list.getDataAtCurrent());  // -1

        list.addItem(1);    // head -> 1, current is head
        list.addItem(2);
        list.addItem(5);
        list.addItem(15);
        list.addItem(88);
        list.addItem(3);
        list.addItem(8);
        list.addItem(99);
        list.addItem(4);
        list.showList();     // head -> 1 -> 2 -> .... 4, current is head

        list.setDataAtCurrent(666);  //  head -> 666 -> 2 -> .... 4, current is head
        list.goToPrev();    // Can't go to previous, current is head!
        list.deleteCurrent();   //  666 deleted, head -> 2 -> .... 4, current is head (2)
        list.insertAfterCurrent(777);
        list.showList(); //  head -> 2 -> 777 -> .... 4, current is head
    }
}
