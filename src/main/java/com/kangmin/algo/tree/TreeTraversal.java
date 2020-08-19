package com.kangmin.algo.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

    static List<Integer> inOrderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        dfsInOrderTraversal(root, result);
        return result;
    }

    private static void dfsInOrderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        TreeNode current = node;
        Stack<TreeNode> stack = new Stack<>();
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = TreeUtility.generateBSTfromArray(arr);
        //        4
        //     2     6
        //  1   3  5   7

        List<Integer> list = inOrderTraversal(root);
        System.out.println("Print tree - InOrder Traversal: ");
        System.out.println(list);

        List<List<Integer>> listOfList = TreeUtility.levelOrderTraversal(root);
        System.out.println("Print tree - LevelOrder Traversal: ");
        System.out.println(listOfList);
    }
}
