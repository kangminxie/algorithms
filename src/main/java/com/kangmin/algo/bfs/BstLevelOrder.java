package main.java.com.kangmin.algo.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BstLevelOrder {

    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        final List<List<Integer>> result = new ArrayList<>();
        levelOrderTraversal(root, result);
        return result;
    }

    private void levelOrderTraversal(TreeNode node, List<List<Integer>> list) {
        if (node == null) {
            return;
        }
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int sizeOfCurrentLevel = queue.size();
            final List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < sizeOfCurrentLevel; i++) {
                final TreeNode currentNode = queue.poll();
                assert currentNode != null;
                currentLevel.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            list.add(currentLevel);
        }
    }

    public static void main(String[] args) {
        // root element is 4
        //          4
        //        2    6
        //      1  3  5  7
        //
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t4.left = t2;
        t4.right = t6;
        t2.left = t1;
        t2.right = t3;
        t6.left = t5;
        t6.right = t7;
        final BstLevelOrder instance = new BstLevelOrder();
        final List<List<Integer>> levelOrder = instance.levelOrderTraversal(t4);
        System.out.println(levelOrder); // [[4], [2, 6], [1, 3, 5, 7]]
    }
}
