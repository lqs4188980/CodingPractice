package com.leetcode.isSymmetric;

import java.util.ArrayList;
import java.util.LinkedList;



public class IsSymmetric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(4);
		root.left.right.left = new TreeNode(8);
		root.left.right.right = new TreeNode(9);
		root.right.right.left = new TreeNode(9);
		root.right.right.right = new TreeNode(8);
		System.out.println(isSymmetric(root));
	}

    public static boolean isSymmetric(TreeNode root) {
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
        
        while (queue.size() != 0) {
            while (currentLevelLength > 0) {
                TreeNode node = queue.poll();
                currentLevelLength--;
            
                if (node != null) {
                    if (node.left != null || node.right != null) {
                        queue.add(node.left);
                        nextLevelLength++;
                        queue.add(node.right);
                        nextLevelLength++;
                    }
                    level.add(node.val);
                }
                else {
                    level.add(null);
                }
                
            }
            
            showLevel(level);
            
            // Decide current level is symmetric
            int size = level.size();
            
            for (int i = 0, j = size - 1; i < size && j >= 0 && i <= j; i++, j--) {
                Integer obj1 = level.get(i);
                Integer obj2 = level.get(j);
                if (obj1 != null && obj2 != null) {
                    if (obj1.intValue() != obj2.intValue()) {
                        return false;
                    }
                    continue;
                }
                if (obj1 == null && obj2 == null) {
                    continue;
                }
                return false;
            }
            
            level.clear();
            currentLevelLength = nextLevelLength;
            nextLevelLength = 0;
            
        }
        
        return true;
        
    }
    
    private static void showLevel(ArrayList<Integer> level) {
    	for (Integer item : level) {
    		if (item == null) {
    			System.out.print("#");
    		}
    		else {
				System.out.print(item.intValue());
			}
    	}
    	System.out.print("\n");
    }
}
