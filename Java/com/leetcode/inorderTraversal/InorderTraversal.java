package com.leetcode.inorderTraversal;

import java.util.ArrayList;

public class InorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> traverseResult = new ArrayList<Integer>();
		if(root == null){
			return traverseResult;
		}
		traverseResult.addAll(inorderTraversal(root.left));
		traverseResult.add(root.val);
		traverseResult.addAll(inorderTraversal(root.right));
		return traverseResult;
    }
	

}
