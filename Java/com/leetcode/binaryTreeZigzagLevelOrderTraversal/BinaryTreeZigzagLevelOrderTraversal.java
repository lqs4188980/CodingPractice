package com.leetcode.binaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.leetcode.dataStructures.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<LinkedList<Integer>> traversal = new ArrayList<LinkedList<Integer>>();
        
        if (root == null) {
            return (List)traversal;
        }
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode dummy = new TreeNode(-1);
        LinkedList<Integer> level = new LinkedList<Integer>();
        boolean ltr = true;
        
        queue.add(root);
        queue.add(dummy);
        int length = 2;
        
        while (length > 0) {
            TreeNode n = queue.pop();
            --length;
            
            if (n == dummy) {
                traversal.add(level);
                if (length > 0) {
                    queue.add(dummy);
                    ++length;
                    level = new LinkedList<Integer>();
                    ltr = !ltr;
                }
            } else {
                if (ltr) {
                    level.add(n.val);
                } else {
                    level.push(n.val);
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
        
        return (List)traversal;
    }
}
