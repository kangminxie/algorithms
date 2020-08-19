package com.kangmin.algo.csce.queue;

interface QueueInterface<T> {

    void enqueue(T data);

    T dequeue();

    T peek();

    void print();
}
