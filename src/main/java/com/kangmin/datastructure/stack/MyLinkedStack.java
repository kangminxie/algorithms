package main.java.com.kangmin.datastructure.stack;

public class MyLinkedStack<T> implements StackInterface<T> {

    private ListNode<T> head;
    private int size;

    MyLinkedStack() {
        head = null;
    }

    MyLinkedStack(final T data) {
        head = new ListNode<>(data);
        size++;
    }

    @Override
    public void push(T data) {
        final ListNode<T> newNode = new ListNode<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public T pop() {
        if (this.isEmpty()) {
            return null;
        }
        final T rtValue = head.val;
        head = head.next;
        size--;

        return rtValue;
    }

    @Override
    public T peek() {
        if (this.isEmpty()) {
            return null;
        }
        return head.val;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MyLinkedStack: head -> ");

        ListNode<T> temp = head;
        while (temp != null) {
            sb.append(temp.val).append(" -> ");
            temp = temp.next;
        }

        sb.append("null");
        return sb.toString();
    }

    public static void main(final String[] args) {
        MyLinkedStack<Integer> stack = new MyLinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);


        MyLinkedStack<Integer> stack2 = new MyLinkedStack<>(65);
        stack2.push(9);
        stack2.push(28);
        stack2.push(31);
        System.out.println(stack2);
        stack2.pop();
        System.out.println(stack2);
    }
}
