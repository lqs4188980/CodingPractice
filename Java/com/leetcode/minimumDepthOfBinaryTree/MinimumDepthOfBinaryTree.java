package com.leetcode.minimumDepthOfBinaryTree;

import java.util.LinkedList;

import com.leetcode.dataStructures.TreeNode;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        TreeNode dummy = new TreeNode(-1);
        queue.add(dummy);
        int length = 2;
        int depth = 1;
        while (length > 0) {
            TreeNode n = queue.poll();
            --length;
            
            if (n == dummy) {
                if (length > 0) {
                    ++depth;
                    queue.add(dummy);
                    ++length;
                }
                
            } else {
                if (n.left == null && n.right == null) {
                    return depth;
                }
                
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
    
    /*
     *     
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftDepth = 0;
        int rightDepth = 0;
        
        if (root.left != null) {
            leftDepth = minDepth(root.left);
        }
        
        if (root.right != null) {
            rightDepth = minDepth(root.right);
        }
        
        if (leftDepth == 0 && rightDepth == 0){
            return 1;
        }
        else {
            if (leftDepth == 0 && rightDepth != 0){
                return ++rightDepth;
            }
            if (rightDepth == 0 && leftDepth != 0){
                return ++leftDepth;
            }
            
            if (leftDepth < rightDepth) {
                return ++leftDepth;
            }
            else {
                return ++rightDepth;
            }
        }
        
    }
     */
}
