package leetcode.tree;

import common.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem,
 * 
 * a height-balanced binary tree is defined as a binary tree in which the depth
 * of the two subtrees of every node never differ by more than 1.
 * 
 * 
 * 
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 *
 * @date Jan 28, 2015
 */
public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}

		if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1) {
			return isBalanced(root.left) && isBalanced(root.right);
		}
		return false;
	}

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		} else {
			int maxL = maxDepth(root.left);
			int maxR = maxDepth(root.right);
			return Math.max(maxL, maxR) + 1;
		}
	}

	public static void main(String[] args) {
		BalancedBinaryTree instance = new BalancedBinaryTree();

	}
}
