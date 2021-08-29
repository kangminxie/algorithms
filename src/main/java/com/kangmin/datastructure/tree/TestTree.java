package main.java.com.kangmin.datastructure.tree;

public class TestTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static int count(TreeNode current) {
        // if it's null, it doesn't exist, return 0
        if (current == null) {
            return 0;
        }

        // count myself + my left child + my right child
        return 1 + count(current.left) + count(current.right);
    }

    public static int getMinimumDifference(TreeNode root) {

        int[] a = new int[count(root)];
        System.out.println("a.length is: " + a.length);

        assign(root, a, 0);


        int[] b = new int[a.length - 1];
        for (int i = 0; i < b.length; i++) {
            b[i] = Math.abs(a[i + 1] - a[i]);
            System.out.println(i + ": " + b[i]);
        }
        int minDiff = b[0];
        for (int i = 1; i < b.length; i++) {
            minDiff = Math.min(minDiff, b[i]);
        }

        return minDiff;
    }

    //In-order printing, return void

    private static void assign(TreeNode aNode, int[] a, int i) {

        if (aNode == null) {
            return;
        }

        if (aNode.left != null) {
            assign(aNode.left, a, i);
        }

        a[i] = (aNode.val);
        System.out.println("now i is: " + i);
        System.out.println("now a[i] is: " + a[i]);
        i = i + 1;


        if (aNode.right != null) {
            assign(aNode.right, a, i);
        }
    }


    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(2);
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(7);
        n0.left = n1;
        n0.right = n2;
        n2.right = n3;

        int z = getMinimumDifference(n0);
        System.out.println(z);
    }

}
