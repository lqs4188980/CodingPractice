package com.leetcode.flattenBinaryTreeToLinkedList;

import java.util.LinkedList;

import com.leetcode.dataStructures.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        // Preorder traversal
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        
        stack.push(root);
        int length = 1;
        TreeNode pt = new TreeNode(-1);
        while (length > 0) {
            TreeNode n = stack.pop();
            --length;
            
            if (n.right != null) {
                stack.push(n.right);
                ++length;
            }
            if (n.left != null) {
                stack.push(n.left);
                ++length;
            }
            
            n.left = null;
            n.right = null;
            pt.right = n;
            pt = pt.right;
        }
        
    }
}
