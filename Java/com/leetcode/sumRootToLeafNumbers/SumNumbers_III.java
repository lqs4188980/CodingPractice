package com.leetcode.sumRootToLeafNumbers;

import com.leetcode.dataStructures.TreeNode;

// A much better solution
public class SumNumbers_III {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return root.val;
        }
        
        return (int)getPath(root, 0);
    }
    
    private long getPath(TreeNode root, long n) {
        n = n * 10 + root.val;
        // Recursive termination
        if (root.left == null && root.right == null) {
            return n;
        }
        
        int sum = 0;
        if (root.left != null) {
            sum += getPath(root.left, n);
        }
        if (root.right != null) {
            sum += getPath(root.right, n);
        }
        
        return sum;
    }
}
