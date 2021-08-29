package main.java.com.kangmin.datastructure.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MinFunctionUsingTwoStacks {

    // |<s1>| 2 1 3 4
    // |<s2>| 2 1 1 1
    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    MinFunctionUsingTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    MinFunctionUsingTwoStacks(List<Integer> list) {
        this();
        int globalMin = Integer.MAX_VALUE;
        for (int a : list) {
            stack1.push(a);
            globalMin = Math.min(a, globalMin);
            stack2.push(globalMin);
        }
    }

    int push(int a) {
        stack1.push(a);
        if (stack2.empty() || a < stack2.peek()) {
            stack2.push(a);
        } else {
            stack2.push(stack2.peek());
        }
        return a;
    }

    int peek() {
        if (stack1.empty()) {
            return -1;
        }
        return stack1.peek();
    }

    int pop() {
        if (stack1.empty()) {
            return -1;
        }
        return stack1.pop();
    }

    int minF() {
        return stack2.peek();
    }

    public static void main(final String[] args) {
        MinFunctionUsingTwoStacks m1 = new MinFunctionUsingTwoStacks();
        m1.push(2);
        assert m1.peek() == 2;
        assert m1.minF() == 2;

        m1.push(3);
        assert m1.peek() == 3;
        assert m1.minF() == 2;

        assert m1.push(1) == 1;
        assert m1.peek() == 1;
        assert m1.minF() == 1;

        Integer[] array = {2, 5, 1, 3};
        MinFunctionUsingTwoStacks m2 = new MinFunctionUsingTwoStacks(Arrays.asList(array));
        assert m1.minF() == 1;

        m2.pop();   // 2, 5, 1
        assert m1.minF() == 1;

        m2.pop();  // 2, 5
        assert m1.minF() == 2;

        assert m2.pop() == 5;
        // 2
        assert m1.minF() == 2;
    }
}
