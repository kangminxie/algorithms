package main.java.com.kangmin.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MyLinkedBinarySearchTree<T extends Comparable<T>> {

    private static class TreeNode<T> {

        private final T val;
        private TreeNode<T> left;
        private TreeNode<T> right;

        TreeNode(T val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode<T> root;

    MyLinkedBinarySearchTree() {
        root = null;
    }

    // == Insertion ==

    public void insert(T data) {
        root = insert(root, data);
    }

    private TreeNode<T> insert(TreeNode<T> node, T data) {
        if (node == null) {
            node = new TreeNode<>(data);
        } else if (data.compareTo(node.val) < 0) {
            node.left = insert(node.left, data);
        } else if (data.compareTo(node.val) > 0) {
            node.right = insert(node.right, data);
        }
        // do not insert again for existing value
        return node;
    }

    public boolean search(T data) {
        return search(root, data);
    }

    // == Search ==

    private boolean search(TreeNode<T> node, T data) {
        if (node == null) {
            return false;
        }

        if (data.compareTo(node.val) == 0) {
            return true;
        } else if (data.compareTo(node.val) < 0) {
            return search(node.left, data);
        } else {
            return search(node.right, data);
        }
    }

    // == delete ==

    public void delete(T data) {
        root = delete(root, data);
    }

    private TreeNode<T> delete(TreeNode<T> node, T data) {
        if (node == null) {
            return null;
        }

        if (data.compareTo(node.val) < 0) {
            node.left = delete(node.left, data);
        } else if (data.compareTo(node.val) > 0) {
            node.right = delete(node.right, data);
        } else {  // find node
            if (node.right == null) {
                return node.left;
            } else if (node.left == null) {
                return node.right;
            } else { // both left and right exists
                TreeNode<T> temp = node;
                // find min node in the right tree
                node = findMinInTree(node.right);
                // delete this min from right tree
                node.right = deleteMinFromTree(temp.right);
                // make sure left is still left
                node.left = temp.left;
            }
        }

        return node;
    }

    // helper method findMin(), return Node
    private TreeNode<T> findMinInTree(TreeNode<T> node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }

        return findMinInTree(node.left);
    }

    // helper method deleteMin(), return Node
    private TreeNode<T> deleteMinFromTree(TreeNode<T> node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node.right;
        }

        node.left = deleteMinFromTree(node.left);
        return node;
    }

    // == PreOrder Traversal ==

    public List<T> preOrderTraversal() {
        final List<T> result = new ArrayList<>();
        preOrderTraversal(root, result);
        return result;
    }

    private void preOrderTraversal(TreeNode<T> node, List<T> list) {
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> current = node;

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

    // == InOrder Traversal ==

    public List<T> inOrderTraversal() {
        final List<T> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }

    private void inOrderTraversal(TreeNode<T> node, List<T> list) {
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> current = node;

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

    // == PostOrder Traversal ==

    public List<T> postOrderTraversal() {
        final LinkedList<T> result = new LinkedList<>();
        postOrderTraversal(root, result);
        return result;
    }

    private void postOrderTraversal(TreeNode<T> node, LinkedList<T> list) {
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> current = node;

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

    // == LevelOrder Traversal ==

    public List<List<T>> levelOrderTraversal() {
        return levelOrderTraversal(root);
    }

    private List<List<T>> levelOrderTraversal(TreeNode<T> root) {
        final List<List<T>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        final Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<T> currLevel = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode<T> tempNode = queue.poll();
                if (tempNode != null) {
                    currLevel.add(tempNode.val);
                    if (tempNode.left != null) {
                        queue.offer(tempNode.left);
                    }
                    if (tempNode.right != null)	{
                        queue.offer(tempNode.right);
                    }
                }
            }
            result.add(currLevel);
        }
        return result;
    }

    public static void main(final String[] args) {
        final MyLinkedBinarySearchTree<Integer> myTree = new MyLinkedBinarySearchTree<>();
        myTree.insert(5);
        myTree.insert(2);
        myTree.insert(7);
        myTree.insert(1);
        myTree.insert(3);
        myTree.insert(6);
        myTree.insert(8);
        //          5
        //       2     7
        //     1  3   6  8
        //
        System.out.println(myTree.levelOrderTraversal());  // [[5], [2, 7], [1, 3, 6, 8]]
        System.out.println(myTree.preOrderTraversal());  // [5, 2, 1, 3, 7, 6, 8]
        System.out.println(myTree.inOrderTraversal());  // [1, 2, 3, 5, 6, 7, 8]
        System.out.println(myTree.postOrderTraversal());  // [1, 3, 2, 6, 8, 7, 5]

        myTree.insert(8);
        System.out.println(myTree.levelOrderTraversal()); // [[5], [2, 7], [1, 3, 6, 8]]

        myTree.delete(2);
        //          5
        //       3     7
        //     1     6  8
        //
        System.out.println(myTree.levelOrderTraversal()); // [[5], [3, 7], [1, 6, 8]]
    }
}
