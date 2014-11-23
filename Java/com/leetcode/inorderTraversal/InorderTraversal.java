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
	
	/*
	 *     public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<Integer>();
        
        if (root == null) {
            return traversal;
        }
        
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode n = root;
        
        while (stack.size() != 0 || n != null) {
            if (n != null) {
                stack.push(n);
                n = n.left;
            } else {
                n = stack.pop();
                traversal.add(n.val);
                n = n.right;
            }
        }
        
        return traversal;
    }
	 */

}
