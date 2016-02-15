import shared.TreeNode;

public class _226_Invert_Binary_Tree {
	/*
	 * Invert a binary tree.
	 *
	 * 4
	 * / \
	 * 2 7
	 * / \ / \
	 * 1 3 6 9
	 * to
	 * 4
	 * / \
	 * 7 2
	 * / \ / \
	 * 9 6 3 1
	 */
	public TreeNode invertTree(TreeNode root) {
		/*
		 * Use a temporary variable to swap left and right pointers
		 * and recursively traverse through the whole tree
		 * to do it for each node
		 */
		if (root == null) {
			return root;
		}

		TreeNode temp = root.right;
		root.right = root.left;
		root.left = temp;

		invertTree(root.left);
		invertTree(root.right);

		return root;
	}
}
