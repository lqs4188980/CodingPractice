package com.leetcode.convertSortedArrayToBinarySearchTree;

import com.leetcode.dataStructures.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null) {
            return null;
        }
        return sortedArrayToBST(num, 0, num.length);
    }
    
    private TreeNode sortedArrayToBST(int[] num, int start, int length) {
        if (length == 0) {
            return null;
        }
        
        int mid = length / 2;
        TreeNode root = new TreeNode(num[start + mid]);
        
        root.left = sortedArrayToBST(num, start, mid);
        root.right = sortedArrayToBST(num, start + mid + 1, length - mid - 1);
        
        return root;
    }
}
