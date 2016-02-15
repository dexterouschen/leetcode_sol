import shared.TreeNode;

public class _104_Maximum_Depth_of_Binary_Tree {
	/*
	 * Given a binary tree, find its maximum depth.
	 * 
	 * The maximum depth is the number of nodes along the longest path from the
	 * root node down to the farthest leaf node.
	 */
	public int maxDepth(TreeNode root) {
		/*
		 * DFS through the whole binary tree, for any empty node, depth 0
		 * 
		 * For any node
		 * max(maxDepth(left subtree) + 1, maxDepth(right subtree) + 1)
		 */
		if (root == null)
			return 0;
		return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
	}
}
