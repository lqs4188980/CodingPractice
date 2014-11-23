package com.leetcode.reverseLinkedListII;

import com.leetcode.dataStructures.ListNode;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = null;
        ListNode pt = head;
        ListNode next = null;
        ListNode tail = null;
        
        int start = 1;
        // Find start node
        while (start != m) {
            prev = pt;
            pt = pt.next;
            ++start;
        }
        
        dummy.next = pt;
        tail = pt;
        pt = pt.next;
        while (start != n) {
            next = pt.next;
            pt.next = dummy.next;
            dummy.next = pt;
            pt = next;
            ++start;
        }
        
        tail.next = pt;
        if (prev != null) {
            prev.next = dummy.next;
        } else {
            head = dummy.next;
        }
        
        return head;
    }
}
