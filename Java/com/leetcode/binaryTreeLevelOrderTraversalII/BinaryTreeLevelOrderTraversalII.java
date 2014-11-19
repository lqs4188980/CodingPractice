package com.leetcode.binaryTreeLevelOrderTraversalII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.leetcode.dataStructures.TreeNode;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<ArrayList<Integer>> traversal = new LinkedList<ArrayList<Integer>>();
        
        if (root == null) {
            return (List)traversal;
        }
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode dummy = new TreeNode(-1);
        ArrayList<Integer> level = new ArrayList<Integer>();
        
        queue.add(root);
        queue.add(dummy);
        int length = 2;
        while (length > 0) {
            TreeNode n = queue.pop();
            --length;
            
            if (n == dummy) {
                traversal.push(level);
                if (length > 0) {
                    level = new ArrayList<Integer>();
                    queue.add(dummy);
                    ++length;
                }
            } else {
                level.add(n.val);
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
