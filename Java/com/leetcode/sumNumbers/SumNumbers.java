package com.leetcode.sumNumbers;

import java.util.Stack;

public class SumNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode rootNode = new TreeNode(0);
		rootNode.left = new TreeNode(1);
		rootNode.right = new TreeNode(3);
		System.out.println(sumNumbers(rootNode));
	}
	
	public static int sumNumbers(TreeNode root) {
        if(root.left == null && root.right == null){
            return root.val;
        }
        
        int sum = 0;
        Stack<Integer> numStack = new Stack<Integer>();
        numStack.push(root.val);
        
        if(root.left != null){
            sum += getSum(root.left, numStack);
        }
        if(root.right != null){
            sum += getSum(root.right, numStack);
        }
        
        return sum;
    }
    
    private static int getSum(TreeNode root, Stack<Integer> numStack){
        int sum = 0;
        Stack<Integer> localStack = new Stack<Integer>();
        localStack.addAll(numStack);
        localStack.push(root.val);
        if(root.left == null && root.right == null){
        	
            
            int counter = 0;
            System.out.println(numStack);
            while(!localStack.empty()){
                
                sum += (localStack.pop() * (int)(Math.pow(10, counter)));
                ++counter;
            }
            System.out.println(counter);
            return sum;
        }
        
        
        if(root.left != null){
            sum += getSum(root.left, localStack);
        }
        
        if(root.right != null){
            sum += getSum(root.right, localStack);
        }
        return sum;
    }

}
