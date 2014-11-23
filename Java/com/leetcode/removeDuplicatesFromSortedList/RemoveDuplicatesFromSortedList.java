package com.leetcode.removeDuplicatesFromSortedList;

import com.leetcode.dataStructures.ListNode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        
        ListNode prev = head;
        ListNode current = head.next;
        int val = prev.val;
        
        while (current != null) {
            if (current.val == val) {
                prev.next = current.next;
                current = prev.next;
            } else {
                val = current.val;
                prev = current;
                current = current.next;
            }
            
            
        }
        
        return head;
    }
}
