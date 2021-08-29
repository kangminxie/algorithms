package main.java.com.kangmin.algo.dfs;

public class DistributeCoinsInBinaryTree {

    private int moves = 0;

    public int distributeCoins(TreeNode root) {
        postOrderTraversal(root, null);
        return moves;
    }

    private void postOrderTraversal(TreeNode curr, TreeNode parent) {
        if (curr == null) return;
        postOrderTraversal(curr.left, curr);
        postOrderTraversal(curr.right, curr);
        if (curr.val == 0) {
            moves += 1;
            parent.val -= 1;
        } else if (curr.val > 1) {
            moves += curr.val - 1;
            parent.val += curr.val - 1;
        }
    }
}
