package main.java.com.kangmin.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConstructBstFromTraversal {

    public static TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length - 1);
    }

    public static TreeNode bstFromPreorder(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new TreeNode(preorder[start]);
        }

//        if (start + 1 == end) {
//            TreeNode startNode = new TreeNode(preorder[start]);
//            TreeNode endNode = new TreeNode(preorder[end]);
//            if (preorder[start] < preorder[end]) {
//                startNode.right = endNode;
//            } else {
//                startNode.left = endNode;
//            }
//            return startNode;
//        }

        boolean lessFind = false;
        int leftIndex = Integer.MIN_VALUE;
        boolean largeFind = false;
        int rightIndex = Integer.MIN_VALUE;

        for (int i = start + 1; i <= end; i++) {
            if (!lessFind && preorder[i] < preorder[start]) {
                lessFind = true;
                leftIndex = i;
            }
            if (preorder[i] > preorder[start]) {
                largeFind = true;
                rightIndex = i;
                break;
            }
        }

        TreeNode startNode = new TreeNode(preorder[start]);
        if (lessFind && !largeFind) {
            startNode.left = bstFromPreorder(preorder, leftIndex, end);
        } else if (!lessFind && largeFind) {
            startNode.right = bstFromPreorder(preorder, rightIndex, end);
        } else if (lessFind && largeFind) {
            startNode.left = bstFromPreorder(preorder, leftIndex, rightIndex - 1);
            startNode.right = bstFromPreorder(preorder, rightIndex, end);
        }

        return startNode;
    }

    static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> rtLL = new ArrayList<>();
        if (root == null) {
            return rtLL;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = queue.poll();        //queue.remove, dequeue
                assert tempNode != null;
                currLevel.add(tempNode.val);
                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
            }
            rtLL.add(currLevel);
        }
        return rtLL;
    }

    public static void main(final String[] args) {
        int[] arr = {8, 5, 1, 7, 10, 12};
        TreeNode root = bstFromPreorder(arr);
        System.out.println(levelOrderTraversal(root));
    }
}
