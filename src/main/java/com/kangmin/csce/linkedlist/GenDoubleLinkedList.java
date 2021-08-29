package main.java.com.kangmin.csce.linkedlist;

public class GenDoubleLinkedList<T> {

    private class ListNode {
        private T data;
        private ListNode next;
        private ListNode prev;

        public ListNode(T aData, ListNode nextLink, ListNode prevLink) {
            this.data = aData;
            this.next = nextLink;
            this.prev = prevLink;
        }
    }

    private ListNode head;
    private ListNode current;

    public GenDoubleLinkedList() {
        head = current = null;
    }

    public void goToNext() {
        if (current.next != null) {
            current = current.next;
        }
    }

    public void goToPrev() {
        if (current.prev != null) {
            current = current.prev;
        }
    }

    public T getDataAtCurrent() {
        if (current != null)
            return current.data;
        else {
            return null;
        }
    }

    public void setDataAtCurrent(T aData) {
        if (current != null)
            current.data = aData;
    }

    public void insert(T newData) {
        ListNode newNode = new ListNode(newData, null, null);
        if (head == null) {
            head = newNode;
            current = head;
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    public void insertNodeAfterCurrent(T newData) {
        ListNode newNode = new ListNode(newData, null, null);
        if (current != null) {
            ListNode temp = current.next;
            newNode.next = current.next;
            newNode.prev = current;
            current.next = newNode;
            temp.prev = newNode;
        } else if (head != null) {
            System.out.println("Current iterated too far.");
        } else {
            System.out.println("Trying to insert in an empty List.");
        }
    }

    public void deleteCurrentNode() {
        if ((current != null) && (current.prev != null)) {
            ListNode temp = current.prev;
            temp.next = current.next;
            current = current.next;
            current.prev = temp;
        } else if (current != null) {
            head = current.next;
            current = head;
            current.prev = null;
        } else {
            System.out.println("Can't delete from an empty List.");
        }
    }

    public void showList() {
        ListNode temp = head;
        System.out.println("Below please see myTacoList for now:");
        int i = 1;
        while (temp != null) {
            System.out.println("Item." + i + "\t" + temp.data);
            i++;
            temp = temp.next;
        }
    }

    public boolean inList(T aData) {
        if (head == null) {
            return false;
        }
        ListNode temp = head;
        while (temp != null) {
            if (!temp.data.equals(aData)) {
                temp = temp.next;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean moreToIterate() {
        return current != null;
    }

    public void resetIterate() {
        current = head;
    }

    public static void main(String[] args) {
        GenDoubleLinkedList<Integer> list = new GenDoubleLinkedList<>();
        System.out.println("Now populating our initial doubly linked-list");

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
        System.out.println(list.inList(2019));

        list.setDataAtCurrent(666);  //  head -> 666 -> 2 -> .... 4, current is head
        list.goToPrev();    // Can't go to previous, current is head!
        list.deleteCurrentNode();   //  666 deleted, head -> 2 -> .... 4, current is head (2)
        list.insertNodeAfterCurrent(777);
        list.showList(); //  head -> 2 -> 777 -> .... 4, current is head
        list.resetIterate();
    }
}
