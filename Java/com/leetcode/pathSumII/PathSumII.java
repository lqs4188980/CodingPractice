package com.leetcode.pathSumII;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.dataStructures.TreeNode;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> pathes = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) {
            return (List)pathes;
        }
        
        DFS(root, 0, sum, pathes, new ArrayList<Integer>());
        
        return (List)pathes;
    }
    
    private void DFS(TreeNode root, int currentSum, int sum, ArrayList<ArrayList<Integer>> pathes, ArrayList<Integer> path) {
        
        currentSum += root.val;
        if (currentSum == sum && root.left == null && root.right == null) {
            path.add(root.val);
            pathes.add(path);
            return;
        }
        

        if (root.left != null) {
            ArrayList<Integer> clonePath = (ArrayList<Integer>)path.clone();
            clonePath.add(root.val);
            DFS(root.left, currentSum, sum, pathes, clonePath);
        }
        
        if (root.right != null) {
            ArrayList<Integer> clonePath = (ArrayList<Integer>)path.clone();
            clonePath.add(root.val);
            DFS(root.right, currentSum, sum, pathes, clonePath);
        }
    }
}
