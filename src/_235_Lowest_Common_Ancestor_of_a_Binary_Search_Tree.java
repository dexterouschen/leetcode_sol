import shared.TreeNode;

public class _235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

	/*
	 * Given a binary search tree (BST), find the lowest common ancestor (LCA)
	 * of two given nodes in the BST.
	 *
	 * According to the definition of LCA on Wikipedia: “The lowest common
	 * ancestor is defined between two nodes v and w as the lowest node in T
	 * that has both v and w as descendants (where we allow a node to be a
	 * descendant of itself).”
	 * 
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
			TreeNode q) {
		/*
		 * Make use of BST's feature, monotonic preorder sequence
		 */
		if (root == null) {
			return null;
		}
		/*
		 * get min/max of p, q before compared to root
		 */
		if (Math.max(p.val, q.val) < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		}
		if (Math.min(p.val, q.val) > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		}
		return root;
	}

	/*
	 * Doesn't make use of BST's feature
	 * when neither p/q is the target, this approach is slower
	 */
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p,
			TreeNode q) {
		if (root == p || root == q || root == null)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null)
			return root;
		return left != null ? left : right;
	}
}
