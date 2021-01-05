package com.kangmin.algo.tree;

import java.util.ArrayList;
import java.util.List;

public class MinAbsDiffBST {

	public int getMinimumDifference(TreeNode root) {

		List<Integer> ls = new ArrayList<>();
		assign(root, ls);

		int[] b = new int[ls.size() - 1];
		for (int i = 0; i < b.length; i++) {
			b[i] = Math.abs(ls.get(i + 1) - ls.get(i));
			// System.out.println(i + ": " + b[i]);
		}

		int minDiff = b[0];
		for (int i = 1; i < b.length; i++) {
			minDiff = Math.min(minDiff, b[i]);
		}

		return minDiff;
	}

	// In-order assign
	private static void assign(TreeNode aNode, List<Integer> al) {
		if (aNode == null) {
			return;
		}
		if (aNode.left != null) {
			assign(aNode.left, al);
		}
		al.add(aNode.val);
		if (aNode.right != null) {
			assign(aNode.right, al);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
