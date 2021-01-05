package com.kangmin.algo.tree;

public class SumRootToLeafBin {

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    int result = 0;

    private void dfs(TreeNode root, int current) {
        if (root == null) {
            return;
        }
        current = current << 1 | root.val;
        if (root.left == null && root.right == null) {
            result += current;
        }
        dfs(root.left, current);
        dfs(root.right, current);
    }
}
