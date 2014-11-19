package com.leetcode.pathSum;

import com.leetcode.dataStructures.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        
        if (root.left == null && root.right == null){
            if (sum != root.val){
                return false;
            }
            else{
                return true;
            }
        }
        
        return (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));
    }
}
