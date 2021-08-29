package main.java.com.kangmin.datastructure.stack;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPathV1(final String path) {
        if (path == null) {
            return null;
        }

        final String[] parts = path.split("/");
        final Stack<String> stack = new Stack<>();
        for (String part : parts) {
            if (!part.equals(".")
                    && !part.equals("..")
                    && !part.isEmpty()) {
                stack.push(part);
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        String result = "";
        while (!stack.isEmpty()) {
            result = "/" + stack.pop() + result;
        }
        return result;
    }
}
