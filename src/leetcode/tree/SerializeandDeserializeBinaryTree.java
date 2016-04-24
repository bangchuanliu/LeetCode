package leetcode.tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import common.TreeNode;

public class SerializeandDeserializeBinaryTree {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		return sb.substring(0, sb.length()-1); 
	}
	
	public void serialize(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("#,");
		} else {
			sb.append(root.val).append(",");
			serialize(root.left, sb);
			serialize(root.right, sb);
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.trim().length() == 0) {
			return null;
		}
		Deque<String> deque = new LinkedList<>();
		deque.addAll(Arrays.asList(data.split(",")));
		return deserialize(deque);
	}
	
	public TreeNode deserialize(Deque<String> deque) {
		TreeNode root = null;
		if (!deque.isEmpty()) {
			String str = deque.poll();
			if (!str.equals("#")) {
				root = new TreeNode(Integer.parseInt(str));
				TreeNode left = deserialize(deque);
				TreeNode right = deserialize(deque);
				root.left = left;
				root.right = right;
			}
		}
		return root;
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(3);
		TreeNode n7 = new TreeNode(1);
		
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;
		n4.left = n6;
		n4.right = n7;
		
		SerializeandDeserializeBinaryTree instance = new SerializeandDeserializeBinaryTree();
		String serializedStr = instance.serialize(n1);
		System.out.println(serializedStr);
		TreeNode root = instance.deserialize(serializedStr);
		System.out.println(instance.serialize(root));
	}
}
