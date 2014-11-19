package com.leetcode.populatingNextRightPointersInEachNode;

import com.leetcode.dataStructures.TreeLinkNode;

public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        TreeLinkNode dummy = new TreeLinkNode(-1),
                     head = null,
                     pt = null,
                     prevTree = null;
        dummy.next = root;
        head = dummy;
        
        while (head.next != null) {
            pt = head.next;
            head.next = null;
            prevTree = head;
            while (pt != null) {
                // Base on assumption: every non-leaf node has two children
                if (pt.left != null && pt.right != null) {
                    pt.left.next = pt.right;
                    prevTree.next = pt.left;
                    prevTree = pt.right;
                }
                pt = pt.next;
            }
            
        }
        
    }
}
