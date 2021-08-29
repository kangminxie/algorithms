package main.java.com.kangmin.csce.stack;

interface StackInterface<T> {

    void push(T data);

    T pop();

    T peek();

    void print();
}

