package com.leetcode.binaryTreeMaximumPathSum;

import com.leetcode.dataStructures.TreeNode;

public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return root.val;
        }
        int[] crossMax = new int[1];
        crossMax[0] = Integer.MIN_VALUE;
        int rootEndMax = getMax(root, crossMax);
        return (rootEndMax > crossMax[0] ? rootEndMax : crossMax[0]);
        
    }
    
    int getMax(TreeNode root, int[] crossMax){
        int leftMax = 0;
        int rightMax = 0 ;
        if (root.left == null && root.right == null){
            if (root.val > crossMax[0]){
                crossMax[0] = root.val;
            }
            return root.val;
        }
        if (root.left != null){
            leftMax = getMax(root.left, crossMax);    
        }
        if (root.right != null){
            rightMax = getMax(root.right, crossMax);
        }
        
        int cross = root.val;
        if (leftMax > 0){
            cross += leftMax;
        }
        
        if (rightMax > 0){
            cross += rightMax;
        }
        
        if (cross > crossMax[0]){
            crossMax[0] = cross;
        }
        
        
        return (root.val > ((leftMax + root.val) > (rightMax + root.val) ? (leftMax + root.val) : (rightMax + root.val)) ? root.val : ((leftMax + root.val) > (rightMax + root.val) ? (leftMax + root.val) : (rightMax + root.val)));
    }
}
