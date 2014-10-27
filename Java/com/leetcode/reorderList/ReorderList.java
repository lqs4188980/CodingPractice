package com.leetcode.reorderList;

import com.leetcode.dataStructures.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {
        // Find the mid point and reverse the right half, then merge the two part
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        
        int count = 0;
        ListNode pt = head;
        while (pt != null) {
            pt = pt.next;
            ++count;
        }
        
        int mid = count / 2;
        ListNode midNode = head;
        int index = 0;
        while (index < mid) {
            midNode = midNode.next;
            ++index;
        }
        
        // Break the link between left and right
        ListNode rightHalf = midNode.next;
        midNode.next = null;
        
        // Reverse the right half list
        ListNode prev = rightHalf;
        ListNode current = prev.next, 
                 next = null;
        prev.next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        // Merge two list
        pt = head;
        while (prev != null) {
            next = prev.next;
            prev.next = pt.next;
            pt.next = prev;
            prev = next;
            pt = pt.next.next;
        }
        
        return;
        
    }
}
