package main.java.com.kangmin.csce.stack;

public class GenLLStack<T> implements StackInterface<T> {

    // == internal class ListNode ==
    private class ListNode {
        private final T data;
        private final ListNode link;

        ListNode(T aData, ListNode aLink) {
            this.data = aData;
            this.link = aLink;
        }
    }

    private ListNode head;

    GenLLStack() {
        head = null;
    }

    // == method push, add the newData to head of Stack, no return value ==
    @Override
    public void push(T newData) {
        head = new ListNode(newData, head);
    }

    // == method pop, return the head's data and move head to next link ==
    @Override
    public T pop() {
        if (head == null) {
            return null;
        }
        T retVal = head.data;
        head = head.link;
        return retVal;
    }

    // == method peek, return the head's data and keep the head ==
    @Override
    public T peek() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    // == method print, show all the data from head to last ==
    @Override
    public void print() {
        if (head == null) {
            System.out.println("Empty Stack, nothing to print");
        }
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + ", ");
            temp = temp.link;
        }
    }

    // == method size, return the size of current list stack ==
    public int size() {
        if (head == null) {
            return 0;
        }
        ListNode current = head;
        int i = 0;
        while (current != null) {
            current = current.link;
            i++;
        }
        return i;
    }

    public static void main(final String[] args) {
        final GenLLStack<Integer> instance = new GenLLStack<>();
        instance.push(1);
        System.out.println(instance.peek());    // 1
        instance.push(2);
        instance.push(3);
        System.out.println(instance.peek());    // 3
        System.out.println(instance.pop());     // 3
        instance.push(5);
        instance.push(6);
        System.out.println(instance.size());     // 4
        instance.print();               // 6,5,2,1,
    }
}
