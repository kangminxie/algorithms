package main.java.com.kangmin.datastructure.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLayerTraversal {

    // == Level-Order Traversal ==
    private List<List<Integer>> levelOrderTraversal(TreeNode root) {
        final List<List<Integer>> rtLL = new ArrayList<>();
        if (root == null) {
            return rtLL;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = queue.poll();
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
            rtLL.add(currLevel);
        }
        return rtLL;
    }
}
