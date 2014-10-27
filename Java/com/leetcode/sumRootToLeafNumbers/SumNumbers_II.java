package com.leetcode.sumRootToLeafNumbers;

import java.util.ArrayList;

import com.leetcode.dataStructures.TreeNode;

// Another solution to this problem
public class SumNumbers_II {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return root.val;
        }
        
        ArrayList<String> numbers = getPath(root, new StringBuilder());
        long sum = 0;
        for (String s : numbers) {
            sum += Integer.parseInt(s);
        }
        
        return (int)sum;
    }
    
    private ArrayList<String> getPath(TreeNode root, StringBuilder s) {
        s.append(root.val);
        ArrayList<String> numbers = new ArrayList<String>();
        // Recursive termination
        if (root.left == null && root.right == null) {
            numbers.add(s.toString());
            return numbers;
        }
        
        if (root.left != null) {
            numbers.addAll(getPath(root.left, new StringBuilder(s.toString())));
        }
        if (root.right != null) {
            numbers.addAll(getPath(root.right, new StringBuilder(s.toString())));
        }
        
        return numbers;
    }
}
