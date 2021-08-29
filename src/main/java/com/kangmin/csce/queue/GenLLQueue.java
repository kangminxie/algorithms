package main.java.com.kangmin.csce.queue;

public class GenLLQueue<T> implements QueueInterface<T> {

    // == internal class ListNode ==
    private class ListNode {
        private final T data;
        private ListNode link;

        ListNode(T aData, ListNode aLink) {
            this.data = aData;
            this.link = aLink;
        }
    }

    private ListNode head;
    private ListNode tail;

    GenLLQueue() {
        head = tail = null;
    }

    // Define method enqueue(void), insert T data to the tail of Queue
    // The moves to tail to point to the newly added element.
    @Override
    public void enqueue(T data) {
        ListNode newNode = new ListNode(data, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.link = newNode; // if not empty, add newNode to current tail's link
        tail = newNode; // move the previous tail to new tail(new Node)
    }

    // Define method dequeue, removes and returns the first element in the queue
    // return type is T data
    @Override
    public T dequeue() {
        if (head == null && tail == null) { // empty Queue
            System.out.println("can't dequeue a empty queue");
            return null;
        }
        ListNode temp = head;
        assert temp != null;
        if (temp.link == null) { // only one element in Queue
            tail = null;
        }
        head = head.link; // move head to next
        return temp.data;
    }

    // Define method peek, returns the first element of the queue without removing
    // it
    // return type is T data
    @Override
    public T peek() {
        if (head == null)
            return null;// empty list
        return head.data;
    }


    // Define method showQueue(void), prints out the queue in order
    @Override
    public void print() {
        if (head == null) {
            System.out.println("Empty queue");
        }
        ListNode temp = head;
        while (temp != null) { // Iterate all node list
            System.out.println(temp.data);
            temp = temp.link;
        }
    }

    // == method size, return the size of current list queue ==
    public int size() {
        if (head == null) {
            return 0;
        }
        ListNode current = head;
        int i = 0;
        while (current != null) {
            current = current.link;
            i++;
        }
        return i;
    }

    public static void main(final String[] args) {
        System.out.println("Testing Generic Linked List Queue");
        System.out.println("Enqueue'ing 10 characters from abcdefg...xyz");
        GenLLQueue<Character> queue = new GenLLQueue<>(); // create a new Integer Queue
        String testString = "abcdefghijklmnopqrstuvwxyz1";

        for (int i = 0; i < 10; i++) {  // enqueue a~j to the Queue
            queue.enqueue(testString.charAt(i));  // check enqueue method
        }
        System.out.println("Dequeue'ing 5 characters and printing them out.");
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.dequeue());  // dequeue check, print each head, 0~9
        }
        System.out.println("Testing peek");
        queue.enqueue('Z');   // Queue has six numbers now
        System.out.println(queue.peek()); // should print 10 if correct
        // checked the peek method, while 5 should be shown but not removed

        System.out.println("Testing show queue");
        for (int i = 0; i < 10; i += 3) {   // enqueue a, d, g, j after Z
            queue.enqueue(testString.charAt(i));
        }
        System.out.println(queue.size());
        queue.print();    // print the final Queue
        System.out.println(queue.size());
    }
}
