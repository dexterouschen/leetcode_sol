import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import shared.TreeNode;

public class _199_Binary_Tree_Right_Side_View {
	/*
	 * Given a binary tree, imagine yourself standing on the right side of it,
	 * return the values of the nodes you can see ordered from top to bottom.
	 * 
	 * For example:
	 * Given the following binary tree,
	 * 1 <---
	 * / \
	 * 2 3 <---
	 * \ \
	 * 5 4 <---
	 * You should return [1, 3, 4].
	 */
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		rightView(root, result, 0);
		return result;
	}

	public void rightView(TreeNode curr, List<Integer> result, int currDepth) {
		if (curr == null) {
			return;
		}
		/*
		 * if right exists, add to result, size expanded, even left exists
		 * this won't match again
		 */
		if (currDepth == result.size()) {
			result.add(curr.val);
		}

		/*
		 * try to fetch right first
		 */
		rightView(curr.right, result, currDepth + 1);
		rightView(curr.left, result, currDepth + 1);

	}

	/*
	 * level-order, get last, not too efficient
	 */
	public List<Integer> rightSideView1(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
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

			/*
			 * if no nodes in current queue
			 * means current level is finished
			 */
			if (current.isEmpty()) {
				result.add(node.val);
				/*
				 * next is the current now
				 */
				current = next;
				/*
				 * make a new next
				 */
				next = new LinkedList<TreeNode>();
			}

		}

		return result;
	}
}
