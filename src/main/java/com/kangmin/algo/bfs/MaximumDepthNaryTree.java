package com.kangmin.algo.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    int val;
    List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class MaximumDepthNaryTree {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (current!= null && current.children != null) {
                    for (Node child : current.children) {
                        queue.offer(child);
                    }
                }

            }
            depth++;
        }
        return depth;
    }
}
