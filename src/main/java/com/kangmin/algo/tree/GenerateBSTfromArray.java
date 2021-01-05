package com.kangmin.algo.tree;

import java.util.Arrays;

public class GenerateBSTfromArray {

	/**
	 * method to populate a binary search tree from an array
	 * @param a an int array
	 * @return root node of the tree
	 */
	public static TreeNode generateBSTfromArray(int[] a) {
		if (a == null || a.length == 0) {
			return null;
		}
		Arrays.sort(a);
		int[] current = new int[1];
		return sortedArrayToBST(a, 0, a.length - 1, current);
	}

	/**
	 * enhanced method to populate a binary search tree from an sub-array
	 * @param a an int array
	 * @return root node of the tree
	 */
    private static TreeNode sortedArrayToBST(int[] a, int start, int end, int[] current) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode left = sortedArrayToBST(a, start, mid - 1, current);
        TreeNode root = new TreeNode(a[current[0]]);
        //System.out.println("Created a TreeNode with value: " + a[current[0]]);
        current[0]++;
        TreeNode right = sortedArrayToBST(a, mid + 1, end, current);

        root.left = left;
        root.right = right;
        return root;
    }
}
