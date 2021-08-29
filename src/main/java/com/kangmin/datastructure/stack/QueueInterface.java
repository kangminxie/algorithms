package main.java.com.kangmin.datastructure.stack;

interface QueueInterface<T> {

    void enqueue(T data);

    T dequeue();

    T peek();

    void print();
}
