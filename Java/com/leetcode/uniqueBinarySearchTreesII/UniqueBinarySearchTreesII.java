package com.leetcode.uniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.dataStructures.TreeNode;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n < 0) {
            return (List)new ArrayList<TreeNode>();
        }
        
        if (n == 0) {
            ArrayList<TreeNode> trees = new ArrayList<TreeNode>();
            trees.add(null);
            return (List)trees;
        }
        
        return getSubTrees(1, n);
    }
    
    private List<TreeNode> getSubTrees(int start, int end) {
        ArrayList<TreeNode> subTrees = new ArrayList<TreeNode>();
        if (start > end) {
            subTrees.add(null);
            return (List)subTrees;
        }
        if (start == end) {
            subTrees.add(new TreeNode(start));
            return (List)subTrees;
        }
        
        for (int i = start; i <= end; ++i) {
            List<TreeNode> left = getSubTrees(start, i - 1);
            List<TreeNode> right = getSubTrees(i + 1, end);
            
            for (int j = 0; j < left.size(); ++j) {
                for (int k = 0; k < right.size(); ++k) {
                    TreeNode n = new TreeNode(i);
                    n.left = left.get(j);
                    n.right = right.get(k);
                    subTrees.add(n);
                }
            }
        }
        
        return (List)subTrees;
    }
}
