package com.kangmin.algo.csce.queue;

public class GenArrayQueue<T> implements QueueInterface<T> {

    private T[] queue;
    private int tailIndex;

    private static final int DEFAULT_SIZE = 64;

    GenArrayQueue() {
        this(DEFAULT_SIZE);
    }

    GenArrayQueue(int size) {
        this.init(size);
    }

    @SuppressWarnings("unchecked")
    private void init(int size) {
        tailIndex = 0;
        if (size > 0) {
            queue = (T[]) (new Object[size]);
        }
    }

    // Define method enqueue(void), insert T data to the tail of Queue
    // The moves to tail to point to the newly added element.
    @SuppressWarnings("unchecked")
    @Override
    public void enqueue(Object data) {
        if (this.queue.length <= this.tailIndex + 1) {
            System.out.println("The queue is full already");
        }
        this.queue[tailIndex] = (T) data;
        this.tailIndex++;
    }

    // Define method dequeue, removes and returns the first element in the queue
    // return type is T data
    @Override
    public T dequeue() {
        T retItem = queue[0];
        if (tailIndex >= 0) {
            System.arraycopy(queue, 1, queue, 0, tailIndex);
        }
        tailIndex--;
        return retItem;
    }

    // Define method peek, returns the first element of the queue without removing
    // return type is T data
    @Override
    public T peek() {
        if (tailIndex == 0) {
            return null;// empty list
        }
        return queue[0];
    }

    // Define method print - prints out the queue in order ==
    @Override
    public void print() {
        if (tailIndex == 0) {
            System.out.println("Empty queue - Nothing to print");
            return;
        }
        for (int i = 0; i < tailIndex; i++) {
            System.out.println(queue[i]);
        }
    }

    public int size() {
        if (tailIndex == 0) {
            return 0;
        }
        return tailIndex;
    }

    public static void main(final String[] args) {
        GenArrayQueue<Character> queue = new GenArrayQueue<>();
        String testString = "abcdefghijklmnopqrstuvwxyz";

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
    }
}
