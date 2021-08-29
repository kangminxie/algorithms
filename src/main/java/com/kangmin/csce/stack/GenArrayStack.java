package main.java.com.kangmin.csce.stack;

public class GenArrayStack<T> implements StackInterface<T>  {

    private T[] stack;
    private int indexNewHead;

    private static final int DEFAULT_SIZE = 64;

    GenArrayStack() {
        this(DEFAULT_SIZE);
    }

    GenArrayStack(int size) {
        this.init(size);
    }

    @SuppressWarnings("unchecked")
    private void init(int size) {
        indexNewHead = 0;
        if (size > 0) {
            stack = (T[]) (new Object[size]);
        }
    }

    @Override
    public void push(T data) {
        if (this.indexNewHead < this.stack.length) {
            this.stack[indexNewHead] = data;
            this.indexNewHead++;
        } else {
            System.out.println("The stack is full already");
        }
    }

    @Override
    public T pop() {
        if (indexNewHead == 0) {
            return null;
        }
        T retVal = stack[indexNewHead - 1];
        indexNewHead = indexNewHead - 1;
        return retVal;
    }

    @Override
    public T peek() {
        if (indexNewHead == 0) {
            return null;
        }
        return stack[indexNewHead - 1];
    }

    @Override
    public void print() {
        if (indexNewHead == 0) {
            System.out.println("Empty Stack - Nothing to print");
            return;
        }
        for (int i = indexNewHead - 1; i >= 0; i--) {
            System.out.println(stack[i] + ", ");
        }
    }

    public int size() {
        return indexNewHead;
    }

    public static void main(final String[] args) {
        System.out.println("Testing Generic Array Stack");
        GenArrayStack<Integer> instance = new GenArrayStack<>();
        instance.push(1);
        System.out.println(instance.peek());    // 1
        instance.push(2);
        instance.push(3);
        System.out.println(instance.peek());    // 3
        System.out.println(instance.pop());     // 3
        instance.push(4);
        System.out.println(instance.size());     // 3
        instance.print();               // 4,2,1,
        System.out.println("Done with testing Generic Array Stack");
    }
}
