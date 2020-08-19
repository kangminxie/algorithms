package com.kangmin.algo.csce.heap;

interface HeapInterface<T> {
    void insert(T data);

    T remove();

    T peek();

    void heapSort();

    void print();
}
