package main.java.com.kangmin.datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class QueueUsingTwoStacks implements QueueInterface<Integer> {

    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    QueueUsingTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // initially, push all items to stack 1, |<s1>| a b c d, |<s2>| empty
    // then push all to stack2, |<s2>| d b c a, |<s1>| empty
    QueueUsingTwoStacks(int[] array) {
        this();
        for (int a : array) {
            stack1.push(a);
        }
        cleanLoadingStack();
    }

    QueueUsingTwoStacks(List<Integer> arrayList) {
        this();
        arrayList.forEach( a -> stack1.push(a));
        cleanLoadingStack();
    }

    private boolean cleanLoadingStack() {
        if (stack1.empty()) {
            // no actual operation was done
            return false;
        }
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        return true;
    }

    @Override
    public void enqueue(Integer data) {
        stack1.push(data);
    }

    @Override
    public Integer dequeue() {
        if (stack2.empty()) {
            if (cleanLoadingStack()) {
                return stack2.pop();
            } else {
                System.out.println("Queue is empty");
                return -1;
            }
        }
        return stack2.pop();
    }

    @Override
    public Integer peek() {
        if (stack2.empty()) {
            if (cleanLoadingStack()) {
                return stack2.peek();
            } else {
                System.out.println("Queue is empty");
                return -1;
            }
        }
        return stack2.peek();
    }

    @Override
    public void print() {
        System.out.println("\nPrint queue:");
        List<Integer> arrayList = new ArrayList<>();
        printHeadingStack(arrayList);
        if (cleanLoadingStack()) {
            printHeadingStack(arrayList);
        }
        System.out.println("end");
        arrayList.forEach( a -> stack1.push(a));
        cleanLoadingStack();
    }

    private void printHeadingStack(List<Integer> list) {
        if (stack2.empty()) {
            System.out.println("stack2 is empty");
            return;
        }
        while (!stack2.empty()) {
            int current = stack2.pop();
            list.add(current);
            System.out.print(current + "->");
        }
    }

    public static void main(final String[] args) {
        final int[] array = {1, 2, 3, 4, 5};
        QueueUsingTwoStacks q = new QueueUsingTwoStacks(array);
        q.print(); // 1->2->3->4->5->end
        System.out.println(q.peek()); // 1

        q.enqueue(6);
        q.print(); // 1->2->3->4->5->6->end

        System.out.println(q.dequeue()); // 1;
        q.print(); // 2->3->4->5->6->end
        System.out.println(q.peek()); // 2

        q.dequeue();
        q.print(); // 3->4->5->6->end
        System.out.println(q.peek()); // 3
    }
}
