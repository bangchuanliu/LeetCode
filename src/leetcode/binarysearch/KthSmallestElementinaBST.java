package leetcode.binarysearch;

import java.util.LinkedList;

import common.TreeNode;

public class KthSmallestElementinaBST {

	public int kthSmallest(TreeNode root, int k) {
		
		if (root == null || k < 0) {
			return 0;
		}
		
		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode p = root;
		int count = 0;
		
		while (!stack.isEmpty() || p != null) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				TreeNode node = stack.pop();
				count++;
				if (count == k) {
					return node.val;
				}
				p = node.right;
			}
		}
		
		return 0;
	}
}


class TreeNode1 {
	int val;
	TreeNode left;
	TreeNode right;
	int pos;

	TreeNode1(int x) {
		val = x;
	}
}
