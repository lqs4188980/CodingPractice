package com.leetcode.binaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.leetcode.dataStructures.TreeNode;


/*
 * This is a iterate traversal version
 * The main idea is manually simulate the recursive working stack. 
 * The hardest part is to store the current subtree root and judge which of it's child need to access.
 * So we need a pointer point to the last node we have accessed and compare it with current node's left and right child. 
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> traversal = new ArrayList<Integer>();
        if (root == null) {
            return (List)traversal;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null,
                 n = root;
        
        
        while (n != null) {
            // Traverse Down
        	// prev == null ----> n is the root node of the tree
        	// prev.left == n ----> n is the left child of prev
        	// prev.right == n ----> n is the right child of prev
        	// In general, when prev is the parent of n, it means we are tracking down the tree. 
            if (prev == null || prev.left == n || prev.right == n) {
            	// The children of n are not null, means we can continue tracking down, so we need to push n into stack and continue.
                if (n.left != null || n.right != null) {
                    prev = n;
                    stack.push(n);
                    if (n.left != null) {
                        n = n.left;
                    } else {
                        n = n.right;
                    }
                } else { // n is the leaf node, we need to traverse up, but we do not popup node from stack, because the node may have child need to traverse.
                    traversal.add(n.val);
                    prev = n;
                    if (!stack.empty()) {
                        n = stack.peek();
                    } else {
                        n = null;
                    }
                }
            } else {
            	// Traverse up
            	// When prev is the left child of n, we need to traverse the right child of n
                if (prev == n.left) {
                    prev = stack.peek();
                    if (n.right != null) {
                        n = n.right;
                    } else { // If the right child of n is null, we finish the traverse of this subtree an pop the root from stack
                        traversal.add(n.val);
                        if (!stack.empty()) {
                            prev = stack.pop();
                        }
                        if (!stack.empty()) {
                            n = stack.peek();
                        } else {
                            n = null;
                        }
                    }
                } else { // When prev is the right child of n, means we have finished traversal of this sub tree, we need to pop root node from stack.
                    traversal.add(n.val);
                    if (!stack.empty()) {
                        prev = stack.pop();
                    }
                    if (!stack.empty()) {
                        n = stack.peek();
                    } else {
                        n = null;
                    }
                }
            }
        }
        
        return (List)traversal;
    }
}
