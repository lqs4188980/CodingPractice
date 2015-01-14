package com.leetcode.binaryTreeUpsideDown;

import java.util.HashMap;
import java.util.Stack;

import com.leetcode.dataStructures.TreeNode;


public class BinaryTreeUpsideDown {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		// My original iterative edition
		Stack<TreeNode> stack = new Stack<TreeNode>();
		HashMap<TreeNode, TreeNode> siblings = new HashMap<TreeNode, TreeNode>();
		TreeNode pt = root;
		while (pt.left != null) {
			stack.push(pt);
			if (pt.right != null) {
				siblings.put(pt, pt.right);
			}
			pt = pt.left;
		}
		
		TreeNode root_new = new TreeNode(pt.val);
		pt = root_new;
		while (!stack.empty()) {
			pt.right = stack.pop();
			if (siblings.containsKey(pt.right)) {
				pt.left = siblings.get(pt.right);
			}
			
			pt.right.right = null;
			pt.right.left = null;
			pt = pt.right;
		}
		
		return root_new;
		
	}
	
	public TreeNode upsideDownBinaryTreeRecursion(TreeNode root) {
		TreeNode root_new = null;
		buildRecursion(root, root_new);
		return root_new;
	}
	
	private TreeNode buildRecursion(TreeNode root, TreeNode root_new) {
		if (root == null) {
			return root;
		}
		if (root.left == null) {
			root_new = new TreeNode(root.val);
			return root_new;
		}
		
		TreeNode parent = buildRecursion(root.left, root_new);
		parent.right = root;
		parent.left = root.right;
		root.left = null;
		root.right = null;
		return root;
	}
}
