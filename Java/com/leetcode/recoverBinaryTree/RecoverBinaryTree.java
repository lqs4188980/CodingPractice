package com.leetcode.recoverBinaryTree;

public class RecoverBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(1);
		recoverTree(root);
	}
	
    public static void recoverTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return;
        if(root.left != null){
        	System.out.println("Reach left");
            TreeNode preMax = root;
            TreeNode realMax = preMax;
            
            realMax = getMax(root.left, realMax);
            System.out.println("preMax: " + preMax.val + "; realMax: " + realMax.val);
            if(realMax.val != preMax.val){
                switchVal(realMax, preMax);
                recoverTree(root);
            }
            recoverTree(root.left);
        }
        if(root.right != null){
        	System.out.println("Reach right");
            TreeNode preMin = root;
            TreeNode realMin = preMin;
            realMin = getMin(root.right, realMin);
            System.out.println("preMin: " + preMin.val + "; realMin: " + realMin.val);
            if(realMin.val != preMin.val){
                switchVal(realMin, preMin);
                recoverTree(root);
            }
            recoverTree(root.right);
        }
            
    }
    
    private static void switchVal(TreeNode node1, TreeNode node2){
        int buf = node1.val;
        node1.val = node2.val;
        node2.val = buf;
    }
    
    private static TreeNode getMax(TreeNode root, TreeNode realMax){
        if(root.val > realMax.val){
            realMax = root;
        }
        if(root.left != null){
            realMax = getMax(root.left, realMax);
        }
        if(root.right != null){
            realMax = getMax(root.right, realMax);
        }
        return realMax;
    }
    
    private static TreeNode getMin(TreeNode root, TreeNode realMin){
        if(root.val < realMin.val){
            realMin = root;  
        }
        if(root.left != null)
            realMin = getMin(root.left, realMin);
        if(root.right != null)
            realMin = getMin(root.right, realMin);
        return realMin;
    }

}
