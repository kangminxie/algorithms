package main.java.com.kangmin.datastructure.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseSubstringsBetweenEachPair {

    public String reverseParentheses(String s) {
        final Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                final Queue<Character> p = new LinkedList<>();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    p.add(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                while (!p.isEmpty()) {
                    stack.push(p.remove());
                }
            } else {
                stack.push(c);
            }
        }

        final StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
