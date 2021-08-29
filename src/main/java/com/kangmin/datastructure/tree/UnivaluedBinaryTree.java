package main.java.com.kangmin.datastructure.tree;

public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isUni(root, root.val);
    }

    private boolean isUni(TreeNode node, int value) {
        if (node == null) {
            return true;
        }
        if (node.val != value) {
            return false;
        }
        return isUni(node.left, value) && isUni(node.right, value);
    }
}
