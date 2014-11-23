package com.leetcode.validateBinarySearchTree;

import java.util.LinkedList;

import com.leetcode.dataStructures.TreeNode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        // Inorder Traversal
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        int value = Integer.MIN_VALUE;
        
        while (stack.size() != 0 || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            }
            else {
                node = stack.pop();
                if (node.val > value) {
                    value = node.val;
                }
                else {
                    return false;
                }
                node = node.right;
            }
        }
        
        return true;
    }
}
