package com.leetcode.symmetricTree;

import java.util.ArrayList;
import java.util.LinkedList;

import com.leetcode.dataStructures.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        // inorder traversal and compare head and tail iteratively
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        int currentLevelLength = 0;
        int nextLevelLength = 0;
        /*
        if (root.left != null) {
            queue.add(root.left);
            currentLevelLength++;
        }
        if (root.right != null) {
            queue.add(root.right);
            currentLevelLength++;
        }
        */
        queue.add(root);
        currentLevelLength++;
        TreeNode dummy = new TreeNode(Integer.MIN_VALUE);
        
        while (queue.size() != 0) {
            while (currentLevelLength > 0) {
                TreeNode node = queue.poll();
                currentLevelLength--;
                
                // Not a dummy node: dummy node did not has any child
                if (node.val != Integer.MIN_VALUE) {
                    if (node.left == null) {
                        queue.add(dummy);
                    }
                    else {
                        queue.add(node.left);
                    }
                    nextLevelLength++;
                    if (node.right == null) {
                        queue.add(dummy);
                    }
                    else {
                        queue.add(node.right);
                    }
                    nextLevelLength++;
                }
                level.add(node.val);
            }
            
            // Decide current level is symmetric
            int size = level.size();
            
            for (int i = 0, j = size - 1; i < size && j >= 0 && i <= j; i++, j--) {
                if (level.get(i).intValue() != level.get(j).intValue()) {
                    return false;
                }
            }
            
            level.clear();
            currentLevelLength = nextLevelLength;
            nextLevelLength = 0;
            
        }
        
        return true;
        
    }
}
