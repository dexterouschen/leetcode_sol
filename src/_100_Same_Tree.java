import shared.TreeNode;

public class _100_Same_Tree {

	/*
	 * Given two binary trees, write a function to check if they are equal or
	 * not.
	 * 
	 * Two binary trees are considered equal if they are structurally identical
	 * and the nodes have the same value.
	 */

	public boolean isSameTree(TreeNode p, TreeNode q) {

		/*
		 * during the traversal, at any point that a pair is not equal, false
		 */

		/*
		 * all empty, same
		 */
		if (p == null && q == null) {
			return true;
		}
		/*
		 * one is empty, the other is not, not same
		 */
		if (p != null && q == null || p == null && q != null) {
			return false;
		}
		/*
		 * both not empty, but not equal, not same
		 */
		if (p != null && q != null && p.val != q.val) {
			return false;
		}
		/*
		 * traverse through left and right subtrees
		 */
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
