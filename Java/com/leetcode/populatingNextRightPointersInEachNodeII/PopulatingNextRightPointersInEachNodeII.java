package com.leetcode.populatingNextRightPointersInEachNodeII;

import com.leetcode.dataStructures.TreeLinkNode;

public class PopulatingNextRightPointersInEachNodeII {
	// A little naive solution
    public void connect(TreeLinkNode root) {
        if (root == null){
            return;
        }
        
        TreeLinkNode parentHead = root;
        TreeLinkNode parentTail = root;
        TreeLinkNode childHead = null;
        TreeLinkNode childTail = null;
        
        while (parentHead != null){
            while (parentHead != null){
                // Poll a node from parentQueue
                TreeLinkNode node = parentHead;
                
                // Update parentQueue
                parentHead = parentHead.next;
                if (parentHead == null){
                    parentTail = null;
                }
                
                // Add all its children to childQueue
                if (node.left != null){
                    if (childHead == null){
                        childHead = node.left;
                        childTail = childHead;
                    }
                    else{
                        childTail.next = node.left;
                        childTail = childTail.next;
                    }
                }
                
                if (node.right != null){
                    if (childHead == null){
                        childHead = node.right;
                        childTail = childHead;
                    }
                    else{
                        childTail.next = node.right;
                        childTail = childTail.next;
                    }
                }
                
            }
            
            // After adding all of the children to childQueue, we have already linked them together
            // Then we need to switch to next level
            
            parentHead = childHead;
            parentTail = childTail;
            
            childHead = null;
            childTail = null;
            
        }
        
        
    }
}
