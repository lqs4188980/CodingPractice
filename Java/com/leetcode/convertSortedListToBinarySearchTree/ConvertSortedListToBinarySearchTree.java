package com.leetcode.convertSortedListToBinarySearchTree;

import com.leetcode.dataStructures.ListNode;
import com.leetcode.dataStructures.TreeNode;

public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        
        // Find mid node
        ListNode fPt = head;
        ListNode sPt = head;
        ListNode prev = null;
        while (fPt != null) {
            fPt = fPt.next;
            if (fPt != null) {
                fPt = fPt.next;
                prev = sPt;
                sPt = sPt.next;
            }
        }
        
        TreeNode root = new TreeNode(sPt.val);
        // Only one node, prev == null
        if (prev != null) {
            prev.next = null;
        }
        // Only one node and mid == head
        if (head != sPt) {
            root.left = sortedListToBST(head);
        } else {
            root.left = null;
        }
        root.right = sortedListToBST(sPt.next);
        
        return root;
    }
}
