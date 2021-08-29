package main.java.com.kangmin.csce.heap;

interface HeapInterface<T> {
    void insert(T data);

    T remove();

    T peek();

    void heapSort();

    void print();
}
