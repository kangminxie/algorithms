package main.java.com.kangmin.datastructure.queue;

public class MyLinkedQueue<T> implements QueueInterface<T> {

    private ListNode<T> head;
    private ListNode<T> tail;
    private int size;

    public MyLinkedQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void enqueue(T data) {
        final ListNode<T> newNode = new ListNode<>(data);

        if (this.isEmpty()) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    @Override
    public T dequeue() {
        if (this.isEmpty()) {
            return null;
        }

        ListNode<T> temp = head;
        head = head.next;
        size--;

        return temp.val;
    }

    @Override
    public T peek() {
        if (this.isEmpty()) {
            return null;
        }

        return head.val;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MyLinkedQueue: head -> ");

        ListNode<T> temp = head;
        while (temp != null) {
            sb.append(temp.val).append(" -> ");
            temp = temp.next;
        }

        sb.append("null");
        return sb.toString();
    }

    public static void main(final String[] args) {
        System.out.println("Test MyLinkedQueue<T> implements QueueInterface<T>");
        System.out.println("Enqueue some characters from abc...xyz");

        QueueInterface<Character> queue = new MyLinkedQueue<>();
        String testString = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < 10; i++) {  // enqueue a~j to the Queue
            queue.enqueue(testString.charAt(i));  // check enqueue method
        }
        System.out.println(queue);
        // a -> b -> c -> d -> e -> f -> g -> h -> i -> j -> null

        System.out.println("Dequeue'ing 5 characters and printing them out.");
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.dequeue());
        }
        System.out.println(queue);
        // f -> g -> h -> i -> j -> null
        System.out.println(queue.size());  // 5

        System.out.println("Testing peek");
        queue.enqueue('Z');
        System.out.println(queue.peek());  // f
        System.out.println(queue);
        // f -> g -> h -> i -> j -> Z -> null

        System.out.println(queue.size());  // 6
    }
}
