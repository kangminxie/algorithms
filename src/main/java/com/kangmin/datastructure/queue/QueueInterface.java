package main.java.com.kangmin.datastructure.queue;

public interface QueueInterface<T> {

    void enqueue(T data);

    T dequeue();

    T peek();

    int size();

    boolean isEmpty();
}
