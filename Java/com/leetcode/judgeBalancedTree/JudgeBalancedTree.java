package com.leetcode.judgeBalancedTree;




public class JudgeBalancedTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// I'll do this using DFS, but I hope I can find a way to judge it when the imbalance is occur.
	// I'll try iterative deepening first.
	public static boolean isBalanced(TreeNode root) {
		int leftHeight = 0;
		int rightHeight = 0;
		
		// Special Cases
        if(root == null){
        	return true;
        }
        
        if(root.left == null && root.right == null){
        	return true;
        }
        
        if(root.left == null && root.right != null){
        	leftHeight = 0;
        	rightHeight = getHeight(root.right);
        	if(Math.abs(leftHeight - rightHeight) > 1){
        		return false;
        	}
        	else {
				return isBalanced(root.right);
			}
        }
        
        if(root.left != null && root.right == null){
        	leftHeight = getHeight(root.left);
        	rightHeight = 0;
        	if(Math.abs(leftHeight - rightHeight) > 1){
        		return false;
        	}
        	else {
				return isBalanced(root.left);
			}
        }
        
        // Normal Cases
        leftHeight = getHeight(root.left);
        rightHeight = getHeight(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1){
        	return false;
        }
        else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
    }
	
	private static int getHeight(TreeNode root){
		
		if(root == null){
			return 0;
		}
		return max(getHeight(root.left), getHeight(root.right)) + 1;
		
	}
	
	private static int max(int a, int b){
		return a < b ? b : a;
	}
	
	

}
