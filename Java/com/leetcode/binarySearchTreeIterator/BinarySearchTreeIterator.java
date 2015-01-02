package com.leetcode.binarySearchTreeIterator;

import java.util.Stack;

import com.leetcode.dataStructures.TreeNode;

public class BinarySearchTreeIterator {

}

class BSTIterator {
	// Inorder traversal
    Stack<TreeNode> s = new Stack<TreeNode>();
    TreeNode pt = null;
    public BSTIterator(TreeNode root) {
        pt = root;
        while (pt != null) {
            s.push(pt);
            pt = pt.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (!s.empty() || pt != null) {
            return true;
        } else {
            return false;
        }
    }

    /** @return the next smallest number */
    public int next() {
        int value = -1;
        pt = s.pop();
        value = pt.val;
        pt = pt.right;
        while (pt != null) {
            s.push(pt);
            pt = pt.left;
        }
        return value;
    }
}
