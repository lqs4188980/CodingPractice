package com.leetcode.postorderTraversal;


public class TreeNodeListNode {
	TreeNode node;
    TreeNodeListNode next;
    boolean isRoot;
    TreeNodeListNode(TreeNode node, boolean isRoot){
        this.node = node;
        this.isRoot = isRoot;
    }
}
