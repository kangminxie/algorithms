package main.java.com.kangmin.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InvertBinaryTree {

    public TreeNode invertTreeRecursive(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = invertTreeRecursive(root.right);
        root.right = invertTreeRecursive(temp);
        return root;
    }

    public TreeNode invertTreeDFS(TreeNode root) {
        if (root == null) {
            return null;
        }

        final Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
        return root;
    }

    public TreeNode invertTreeBFS(TreeNode root) {
        if (root == null) {
            return null;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currnt = queue.poll();
            TreeNode temp = currnt.left;
            currnt.left = currnt.right;
            currnt.right = temp;

            if (currnt.left != null) {
                queue.offer(currnt.left);
            }
            if (currnt.right != null) {
                queue.offer(currnt.right);
            }
        }
        return root;
    }
}
