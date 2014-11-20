package com.leetcode.maximumDepthOfBinaryTree;

import com.leetcode.dataStructures.TreeNode;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        
        if (leftMax < rightMax) {
            return rightMax + 1;
        }
        return leftMax + 1;
    }
    
    /*
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode dummy = new TreeNode(-1);
        
        queue.add(root);
        queue.add(dummy);
        int length = 2;
        int depth = 1;
        while (length > 0) {
            TreeNode n = queue.pop();
            --length;
            
            if (n == dummy) {
                if (length > 0) {
                    ++depth;
                    queue.add(dummy);
                    ++length;
                }
            } else {
                if (n.left != null) {
                    queue.add(n.left);
                    ++length;
                }
                if (n.right != null) {
                    queue.add(n.right);
                    ++length;
                }
            }
        }
        
        return depth;
    }
     */
}
