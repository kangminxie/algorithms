package main.java.com.kangmin.datastructure.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateBstFromArray {

    public static TreeNode generateBSTFromArray(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        Arrays.sort(a);     // if not sorted
        int[] current = new int[1];
        return sortedArrayToBST(a, 0, a.length - 1, current);
    }

    private static TreeNode sortedArrayToBST(int[] a, int start, int end, int[] current) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode left = sortedArrayToBST(a, start, mid - 1, current);
        TreeNode root = new TreeNode(a[current[0]]);
        System.out.println("midIndex is: " + mid);
        System.out.println("Created a TreeNode with value: " + a[current[0]] + " while a[mid] is: " + a[mid]);
        current[0]++;
        TreeNode right = sortedArrayToBST(a, mid + 1, end, current);

        root.left = left;
        root.right = right;
        return root;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }


    private static List<List<Integer>> levelOrderTraversal(TreeNode root) {
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

    public TreeNode sortedArrayToBSTV2(int[] nums) {
		if (nums.length == 0) {
			return null;
		}

        TreeNode root = new TreeNode();

        LinkedList<TreeNode> nodes = new LinkedList<>();
        LinkedList<Integer> loIdx = new LinkedList<>();
        LinkedList<Integer> hiIdx = new LinkedList<>();

        nodes.add(root);
        loIdx.add(0);
        hiIdx.add(nums.length - 1);

        while (!nodes.isEmpty()) {
            TreeNode parent = nodes.remove();
            Integer lo = loIdx.remove();
            Integer hi = hiIdx.remove();
            int mid = lo + (hi - lo) / 2;
            parent.val = nums[mid];
            if (lo <= mid - 1) {
                TreeNode node = new TreeNode();
                parent.left = node;
                nodes.add(node);
                loIdx.add(lo);
                hiIdx.add(mid - 1);
            }
            if (mid + 1 <= hi) {
                TreeNode node = new TreeNode();
                parent.right = node;
                nodes.add(node);
                loIdx.add(mid + 1);
                hiIdx.add(hi);
            }
        }

        return root;
    }

    public static void main(final String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        TreeNode root = generateBSTFromArray(arr);
        //       3
        //      1  4
        //     2    5
        System.out.println(levelOrderTraversal(root));

        int[] arr2 = {1, 2, 3, 4, 5};
        TreeNode root2 = sortedArrayToBST(arr2);
        System.out.println(levelOrderTraversal(root2));
    }
}
