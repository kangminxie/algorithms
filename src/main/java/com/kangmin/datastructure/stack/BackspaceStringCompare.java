package main.java.com.kangmin.datastructure.stack;

import java.util.Stack;

public class BackspaceStringCompare {

    // S and T are not null
    public boolean backspaceCompareV1(String S, String T) {
        return getCleanString(S).equals(getCleanString(T));
    }

    private String getCleanString(String s) {
        final char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char c : arr) {
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder("");
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
