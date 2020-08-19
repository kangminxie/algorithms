package com.kangmin.algo.stack;

interface QueueInterface<T> {

    void enqueue(T data);

    T dequeue();

    T peek();

    void print();
}
