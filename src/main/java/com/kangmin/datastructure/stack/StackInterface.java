package main.java.com.kangmin.datastructure.stack;

public interface StackInterface<T> {

    void push(T data);

    T pop();

    T peek();

    int size();

    boolean isEmpty();
}
