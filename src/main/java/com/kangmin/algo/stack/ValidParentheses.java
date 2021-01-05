package com.kangmin.algo.stack;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValidV1(final String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        final Stack<Character> stack = new Stack<>();
        final char[] arr = s.toCharArray();
        for (final char c : arr) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


}
