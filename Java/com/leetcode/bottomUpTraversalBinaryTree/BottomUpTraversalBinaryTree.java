package com.leetcode.bottomUpTraversalBinaryTree;

import java.util.ArrayList;

public class BottomUpTraversalBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		
		for(ArrayList<Integer> level : levelOrderBottom(root)){
			System.out.print("[");
			for(Integer node : level){
				System.out.print(node + " ");
			}
			System.out.print("]\n");
		}
	}
	
	public static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		/*
		 * I think it should use BFS to traverse over the tree.
		 */
		if(root == null){
			return new ArrayList<ArrayList<Integer>>();
		}
		ArrayList<ArrayList<Integer>> traverseResults = new ArrayList<ArrayList<Integer>>();
		ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
		nodeList.add(root);
		traverseByLevel(nodeList, traverseResults);
		return traverseResults;
        
    }
	
	private static void traverseByLevel(ArrayList<TreeNode> nodeList, ArrayList<ArrayList<Integer>> results){
		// If nodeList is empty, then we know we are reaching bottom, then return.
		if(nodeList.isEmpty()){
			results.add(new ArrayList<Integer>());
			return;
		}
		// If nodeList is non-empty, we need to add all the children of the node in the node list into a new list and call the function
		ArrayList<TreeNode> childrenList = new ArrayList<TreeNode>();
		ArrayList<Integer> traversedNodes = new ArrayList<Integer>();
		for(TreeNode node : nodeList){
			if(node.left != null){
				childrenList.add(node.left);
			}
			if(node.right != null){
				childrenList.add(node.right);
			}
			traversedNodes.add(node.val);
		}
		
		if (childrenList.isEmpty()) {
			results.add(traversedNodes);
			return;
		}
		else {
			traverseByLevel(childrenList, results);
			results.add(traversedNodes);
			return;
		}
	}

}
