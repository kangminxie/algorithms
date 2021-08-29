package main.java.com.kangmin.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TraversalTree {

	// == Pre-Order Traversal ==
	private List<Integer> preOrderTraversal(TreeNode root) {
		final List<Integer> result = new ArrayList<>();
		final Stack<TreeNode> stack = new Stack<>();

		TreeNode current = root;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				result.add(current.val); //System.out.println("added: " + current.val);
				stack.add(current);
				current = current.left;
			} // until current is null, go to most left
			current = stack.pop();
			current = current.right;
		}
		return result;
	}

	// == In-Order Traversal ==
	private List<Integer> inOrderTraversal(TreeNode root) {
		final List<Integer> result = new ArrayList<>();
		final Stack<TreeNode> stack = new Stack<>();

		TreeNode current = root;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.add(current);
				current = current.left;
			} // until current is null, go to most left
			current = stack.pop();
			result.add(current.val); //System.out.println("added: " + current.val);
			current = current.right;
		}
		return result;
	}

	// == Morris Method In-Order Traversal ==
	private List<Integer> inOrderTraversalMorris(TreeNode root) {
		final List<Integer> result = new ArrayList<>();
		TreeNode curr = root;
		TreeNode prev;
		while (curr != null) {
			if (curr.left == null) {
				result.add(curr.val);
				curr = curr.right;
			} else {
				prev = curr.left;
				while (prev.right != null) {
					prev = prev.right;
				}
				prev.right = curr;
				TreeNode temp = curr;
				curr = curr.left;
				temp.left = null;
			}
		}
		return result;
	}

	public int rangeSumBST(TreeNode root, int L, int R) {
		int result = 0;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node != null) {
				if (L <= node.val && node.val <= R) {
					result += node.val;
				}
				if (L < node.val) {
					stack.push(node.left);
				}
				if (node.val < R) {
					stack.push(node.right);
				}
			}
		}
		return result;
	}

	private int rangeSumBSTRecursive(TreeNode root, int L, int R) {
		if (root == null) {
			return 0;
		}
		if (root.val > R) {
			return rangeSumBSTRecursive(root.left, L, R);
		}
		if (root.val < L) {
			return rangeSumBSTRecursive(root.right, L, R);
		}
		return root.val + rangeSumBSTRecursive(root.left, L, R) + rangeSumBSTRecursive(root.right, L, R);
	}

	// == Reverse-In-Order Traversal ==
	private List<Integer> reverseOrderTraversal(TreeNode root) {
		final List<Integer> result = new ArrayList<>();
		final Stack<TreeNode> stack = new Stack<>();

		TreeNode current = root;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.add(current);
				current = current.right;
			} // until current is null, go to most left
			current = stack.pop();
			result.add(current.val); //System.out.println("added: " + current.val);
			current = current.left;
		}
		return result;
	}

	// == Post-Order Traversal ==
	private List<Integer> postOrderTraversal(TreeNode root) {
		final LinkedList<Integer> result = new LinkedList<>();
		final Stack<TreeNode> stack = new Stack<>();

		TreeNode current = root;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				result.addFirst(current.val); //System.out.println("added: " + current.val);
				stack.add(current);
				current = current.right;
			} // until current is null, go to most left
			current = stack.pop();
			current = current.left;
		}
		return result;
	}

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
                TreeNode tempNode = queue.poll();		//queue.remove, dequeue
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

	public static void main(final String[] args) {
		// root element is 4
		//          4
		//        2    6
		//      1  3  5  7
		//
		final TreeNode t1 = new TreeNode(1);
		final TreeNode t2 = new TreeNode(2);
		final TreeNode t3 = new TreeNode(3);
		final TreeNode t4 = new TreeNode(4);
		final TreeNode t5 = new TreeNode(5);
		final TreeNode t6 = new TreeNode(6);
		final TreeNode t7 = new TreeNode(7);
		t4.left = t2;
		t4.right = t6;
		t2.left = t1;
		t2.right = t3;
		t6.left = t5;
		t6.right = t7;

		final TraversalTree test = new TraversalTree();

		final List<Integer> preResult = test.preOrderTraversal(t4);
		System.out.println("Pre-Order-Traversal result is:");
		System.out.println(preResult);

		final List<Integer> inResult = test.inOrderTraversal(t4);
		System.out.println("In-Order-Traversal result is:");
		System.out.println(inResult);

		final List<Integer> postResult = test.postOrderTraversal(t4);
		System.out.println("Post-Order-Traversal result is:");
		System.out.println(postResult);

		final List<List<Integer>> levelResult = test.levelOrderTraversal(t4);
		System.out.println("Level-Order-Traversal result is:");
		System.out.println(levelResult);


		final List<Integer> reverOrderResult = test.reverseOrderTraversal(t4);
		System.out.println("Reverse-Order-Traversal result is:");
		System.out.println(reverOrderResult);

/*		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.addFirst(5);
		System.out.println(list);*/
	}

}
