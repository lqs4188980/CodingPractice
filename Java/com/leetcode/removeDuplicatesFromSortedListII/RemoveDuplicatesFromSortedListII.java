package com.leetcode.removeDuplicatesFromSortedListII;

import com.leetcode.dataStructures.ListNode;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode current = head;
        
        dummy.next = head;
        
        while (current != null) {
            // In the duplicate block
            if (current.next != null && current.val == current.next.val) {
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                
                if (current.next != null) {
                    current = current.next;
                    prev.next = current;
                } else {
                    prev.next = null;
                }
            } else {
                prev = current;
                current = current.next;
            }
        }
        
        return dummy.next;

    }
}
