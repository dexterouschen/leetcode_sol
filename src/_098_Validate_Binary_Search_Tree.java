import java.util.ArrayList;
import java.util.List;

import shared.TreeNode;

public class _098_Validate_Binary_Search_Tree {

	/*
	 * Returns true if the given tree is a binary search tree (efficient
	 * version).
	 */
	public static boolean isValidBST1(TreeNode node) {
		/*
		 * use Long in case the given tree is a single node with Integer.min/max
		 */
		return (isBSTUtil(node, Long.MIN_VALUE, Long.MAX_VALUE));
	}

	/*
	 * Returns true if the given tree is a BST and its values are >= min and <=
	 * max.
	 */
	private static boolean isBSTUtil(TreeNode node, long min, long max) {

		/* an empty tree is BST */
		if (node == null)
			return true;

		/* false if this node violates the min/max constraint */
		if (node.val < min || node.val > max)
			return false;

		/*
		 * otherwise check the subtrees recursively, tightening the min or max
		 * constraint
		 */
		return isBSTUtil(node.left, min, node.val - 1) && // Allow only distinct
															// values
				isBSTUtil(node.right, node.val + 1, max); // Allow only distinct
															// values
	}

	public boolean isValidBST(TreeNode root) {

		List<TreeNode> stack = new ArrayList<>();
		// The first node to be visited is the leftmost
		TreeNode node = root;
		if (root == null || root.left == null && root.right == null) {
			return true;
		}
		Integer pre = null;
		while (node != null) {
			stack.add(node);
			node = node.left;
		}
		// Traverse the tree
		while (stack.size() > 0) {
			// Visit the top node
			node = stack.remove(stack.size() - 1);
			if (pre != null && node.val <= pre) {
				return false;
			}
			pre = node.val;

			// Find the next node
			if (node.right != null) {
				node = node.right;
				// The next node to be visited is the leftmost
				while (node != null) {
					stack.add(node);
					node = node.left;
				}
			}
		}
		return true;
	}
}
