import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import shared.TreeNode;

public class _102_Binary_Tree_Level_Order_Traversal {
	/*
	 * Given a binary tree, return the level order traversal of its nodes'
	 * values. (ie, from left to right, level by level).
	 * 
	 * For example:
	 * Given binary tree {3,9,20,#,#,15,7},
	 * 
	 * return its level order traversal as:
	 * [
	 * [3],
	 * [9,20],
	 * [15,7]
	 * ]
	 * 
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> al = new ArrayList<List<Integer>>();
		List<Integer> nodeValues = new ArrayList<Integer>();
		if (root == null)
			return al;

		/*
		 * to track the start of each level, use separate queue
		 */
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		LinkedList<TreeNode> next = new LinkedList<TreeNode>();
		current.add(root);

		/*
		 * use up all nodes available in current queue
		 */
		while (!current.isEmpty()) {
			TreeNode node = current.remove();

			/*
			 * put children in next queue
			 */
			if (node.left != null)
				next.add(node.left);
			if (node.right != null)
				next.add(node.right);

			nodeValues.add(node.val);
			/*
			 * if no nodes in current queue
			 * means current level is finished
			 */
			if (current.isEmpty()) {
				/*
				 * next is the current now
				 */
				current = next;
				/*
				 * make a new next
				 */
				next = new LinkedList<TreeNode>();
				/*
				 * append current level result
				 */
				al.add(nodeValues);
				/*
				 * for a new level result
				 */
				nodeValues = new ArrayList<Integer>();
			}

		}
		return al;
	}

	// public static List<List<Integer>> levelOrder1(TreeNode root) {
	// List<List<Integer>> al = new ArrayList<List<Integer>>();
	// List<Integer> nodeValues = new ArrayList<Integer>();
	// if (root == null)
	// return al;
	//
	// LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	// queue.add(root);
	// queue.add(null);
	//
	// while (!queue.isEmpty()) {
	// TreeNode node = queue.remove();
	// while (node != null) {
	// if (node.left != null)
	// queue.add(node.left);
	// if (node.right != null)
	// queue.add(node.right);
	// nodeValues.add(node.val);
	// node = queue.remove();
	// }
	// if (queue.isEmpty()) {
	// if (nodeValues.size() > 0) {
	// al.add(nodeValues);
	// }
	// break;
	// }
	// queue.add(null);
	// if (node == null) {
	// if (nodeValues.size() > 0) {
	// al.add(nodeValues);
	// nodeValues = new ArrayList<Integer>();
	// }
	// }
	// }
	// return al;
	// }

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t3.right = t5;
		// levelOrder1(t1);
	}

}
