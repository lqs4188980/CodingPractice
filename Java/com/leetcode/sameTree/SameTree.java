package com.leetcode.sameTree;

import java.util.LinkedList;

import com.leetcode.dataStructures.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        LinkedList<TreeNode> p_queue = new LinkedList<TreeNode>();
        LinkedList<TreeNode> q_queue = new LinkedList<TreeNode>();
        
        if (p != null) {
            p_queue.add(p);
        }
        if (q != null) {
            q_queue.add(q);
        }
        
        while (p_queue.size() == q_queue.size() && p_queue.size() != 0) {
            TreeNode p_node = p_queue.poll();
            TreeNode q_node = q_queue.poll();
            
            if (p_node.val != q_node.val || p_node.left == null && q_node.left != null || p_node.left != null && q_node.left == null || p_node.right != null && q_node.right == null || p_node.right == null && q_node.right != null) {
                return false;
            }
            
            if (p_node.left != null) {
                p_queue.add(p_node.left);
            }
            if (p_node.right != null) {
                p_queue.add(p_node.right);
            }
            if (q_node.left != null) {
                q_queue.add(q_node.left);
            }
            if (q_node.right != null) {
                q_queue.add(q_node.right);
            }
            
            
        }
        
        if (p_queue.size() != q_queue.size()) {
            return false;
        }
        return true;
    }
}
