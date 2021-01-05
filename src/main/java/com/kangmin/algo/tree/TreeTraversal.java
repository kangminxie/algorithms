package com.kangmin.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {

    ////////////////////////////
    // == PreOrderTraversal ==
    ////////////////////////////
    List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfsPreOrderTraversal(root, result);
        return result;
    }

    private void dfsPreOrderTraversal(TreeNode node, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = node;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                list.add(current.val);
                current = current.left;
            }
            current = stack.pop();
            current = current.right;
        }
    }

    private void dfsPreOrderTraversalV2(TreeNode node, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current != null) {
                list.add(current.val);
                stack.push(current.right);
                stack.push(current.left);
            }
        }
    }

    ////////////////////////////
    // == InOrderTraversal ==
    ////////////////////////////
    List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfsInOrderTraversal(root, result);
        return result;
    }

    private void dfsInOrderTraversal(TreeNode node, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = node;
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

    ////////////////////////////
    // == PostOrderTraversal ==
    ////////////////////////////
    List<Integer> postOrderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        dfsPostOrderTraversal(root, result);
        return result;
    }

    private void dfsPostOrderTraversal(TreeNode node, LinkedList<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = node;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                list.addFirst(current.val);
                current = current.right;
            }
            current = stack.pop();
            current = current.left;
        }
    }

    private void dfsPostOrderTraversalV2(TreeNode node, LinkedList<Integer> list) {
//        if (node == null) {
//            return;
//        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current != null) {
                list.addFirst(current.val);
                stack.push(current.left);
                stack.push(current.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeTraversal instance = new TreeTraversal();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = TreeUtility.generateBSTFromArray(arr);
        //        4
        //     2     6
        //  1   3  5   7

        List<Integer> listPre = instance.preOrderTraversal(root);
        System.out.println("\nPrint tree - PreOrder Traversal: ");
        System.out.println(listPre); // [4, 2, 1, 3, 6, 5, 7]

        List<Integer> listIn = instance.inOrderTraversal(root);
        System.out.println("\nPrint tree - InOrder Traversal: ");
        System.out.println(listIn); // [1, 2, 3, 4, 5, 6, 7]

        List<Integer> listPost = instance.postOrderTraversal(root);
        System.out.println("\nPrint tree - PostOrder Traversal: ");
        System.out.println(listPost); // [1, 3, 2, 5, 7, 6, 4]

        List<List<Integer>> listOfList = TreeUtility.levelOrderTraversal(root);
        System.out.println("\nPrint tree - LevelOrder Traversal: ");
        System.out.println(listOfList); // [[4], [2, 6], [1, 3, 5, 7]]
    }
}
