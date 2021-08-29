package main.java.com.kangmin.datastructure.queue;

public class MyArrayQueue<T> implements QueueInterface<T> {

    private T[] queue;
    private int frontIndex;
    private int backIndex;
    private int numItems;

    private static final int DEFAULT_SIZE = 26;

    public MyArrayQueue() {
        this.init(DEFAULT_SIZE);
    }

    public MyArrayQueue(final int size) {
        this.init(size);
    }

    @SuppressWarnings("unchecked")
    private void init(final int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Can't initialize a ArrayQueue with size <= 0");
        }
        queue = (T[]) new Object[size];
        frontIndex = 0;
        backIndex = -1;
        numItems = 0;
    }

    @Override
    public void enqueue(T data) {
        if (isFull()) {
            throw new RuntimeException("ArrayQueue is full already!");
        }
        backIndex++;
        int normalIndex = backIndex % queue.length;
        queue[normalIndex] = data;
        numItems++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        int normalIndex = frontIndex % queue.length;
        final T result = queue[normalIndex];

        frontIndex++;
        numItems--;
        return result;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        int normalIndex = frontIndex % queue.length;
        return queue[normalIndex];
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MyArrayQueue: Front | ");

        int count = numItems;
        int normalIndex = frontIndex % queue.length;
        while (count > 0) {
            sb.append(queue[normalIndex % queue.length]).append(" | ");
            normalIndex++;
            count--;
        }

        sb.append("Back");
        return sb.toString();
    }

    @Override
    public int size() {
        return this.numItems;
    }

    @Override
    public boolean isEmpty() {
        return this.numItems == 0;
    }

    private boolean isFull() {
        return this.numItems == queue.length;
    }

    public static void main(final String[] args) {
        System.out.println("Test MyArrayQueue<T> implements QueueInterface<T>");
        System.out.println("Enqueue some characters from abc...xyz");

        QueueInterface<Character> queue = new MyArrayQueue<>();
        String testString = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < 10; i++) {  // enqueue a~j to the Queue
            queue.enqueue(testString.charAt(i));  // check enqueue method
        }
        System.out.println(queue);
        // Front | a | b | c | d | e | f | g | h | i | j | Back

        System.out.println("Dequeue'ing 5 characters and printing them out.");
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.dequeue());
        }
        System.out.println(queue);
        // Front | f | g | h | i | j | Back
        System.out.println(queue.size());  // 5

        System.out.println("Testing peek");
        queue.enqueue('Z');
        System.out.println(queue.peek());  // f
        System.out.println(queue);
        // Front | f | g | h | i | j | Z | Back

        System.out.println(queue.size());  // 6


        MyArrayQueue<Integer> queue2 = new MyArrayQueue<>(3);
        queue2.enqueue(1);
        queue2.enqueue(2);
        queue2.enqueue(3);
        System.out.println(queue2.size());  //  3
        System.out.println(queue2.frontIndex);  //  0
        System.out.println(queue2.backIndex);  //  2

        try {
            queue2.enqueue(4);
        } catch (final RuntimeException e) {
            System.out.println("*** Exception: " + e.getMessage());
        }

        queue2.dequeue();
        System.out.println(queue2.size());  //  2
        System.out.println(queue2.frontIndex);  //  1
        System.out.println(queue2.backIndex);  //  2
    }
}
