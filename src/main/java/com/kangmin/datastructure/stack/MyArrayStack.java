package main.java.com.kangmin.datastructure.stack;

public class MyArrayStack<T> implements StackInterface<T> {

    private T[] stack;
    private int headIndex;

    private static final int DEFAULT_SIZE = 26;

    public MyArrayStack() {
        this.init(DEFAULT_SIZE);
    }

    public MyArrayStack(final int size) {
        this.init(size);
    }

    @SuppressWarnings("unchecked")
    private void init(final int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Can't initialize a ArrayStack with size <= 0");
        }
        headIndex = 0;
        stack = (T[]) new Object[size];
    }

    @Override
    public void push(T data) {
        if (headIndex >= stack.length) {
            throw new RuntimeException("stack is full!");
        }
        stack[headIndex] = data;
        headIndex++;
    }

    @Override
    public T pop() {
        if (this.isEmpty()) {
            return null;
        }

        final T rtValue = stack[headIndex - 1];
        stack[headIndex - 1] = null;
        headIndex--;
        return rtValue;
    }

    @Override
    public T peek() {
        if (this.isEmpty()) {
            return null;
        }
        return stack[headIndex - 1];
    }

    @Override
    public int size() {
        return headIndex;
    }

    @Override
    public boolean isEmpty() {
        return headIndex == 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MyArrayStack: ");
        for (final T each : stack) {
            if (each != null) {
                sb.append(each).append(" | ");
            } else {
                break;
            }
        }
        sb.append("TOP/HEAD");
        return sb.toString();
    }

    public static void main(final String[] args) {
        MyArrayStack<Integer> stack = new MyArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);


        MyArrayStack<Integer> stack2 = new MyArrayStack<>(5);
        stack2.push(6);
        stack2.push(5);
        stack2.push(4);
        System.out.println(stack2);
        stack2.pop();
        stack2.pop();
        System.out.println(stack2);
    }
}
