package com.leetcode.constructBinaryTreeFromInorderAndPostorderTraversal;

import com.leetcode.dataStructures.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return buildTree(inorder, postorder, 0, inorder.length, 0, postorder.length);
    }
    
    private TreeNode buildTree(int[] inorder, int[] postorder, int inorderStart, int inorderLength, int postorderStart, int postorderLength) {
        TreeNode root = new TreeNode(postorder[postorderStart + postorderLength - 1]);
        
        for (int i = 0; i < inorderLength; ++i) {
            if (inorder[inorderStart + i] == root.val) {
                if (i == 0) {
                    root.left = null;
                } else {
                    root.left = buildTree(inorder, postorder, inorderStart, i, postorderStart, i);
                }
                
                if (i + 1 == inorderLength) {
                    root.right = null;
                } else {
                    root.right = buildTree(inorder, postorder, inorderStart + i + 1, inorderLength - i - 1, postorderStart + postorderLength - 1 - (inorderLength - i - 1), inorderLength - i - 1);
                }
                
                return root;
            }
        }
        
        return root;
    }
}
