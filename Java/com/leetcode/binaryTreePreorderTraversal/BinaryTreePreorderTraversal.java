package com.leetcode.binaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.leetcode.dataStructures.TreeNode;

/*
 * For preorder traversal, we need a stack: after accessing a node, we need push its right node first then left, because we want to access left node first.
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> traversal = new ArrayList<Integer>();
        
        if (root == null) {
            return (List)traversal;
        }
        
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        while (stack.peek() != null) {
            TreeNode n = stack.pop();
            traversal.add(n.val);
            if (n.right != null) {
                stack.push(n.right);
            }
            if (n.left != null) {
                stack.push(n.left);
            }
        }
        
        return (List)traversal;
    }
}
