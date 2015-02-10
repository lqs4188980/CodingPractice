package com.leetcode.removeNthNodeFromEndOfList;

import com.leetcode.dataStructures.ListNode;

public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode l = head;
        ListNode r = head;
        int dist = n - 1;
        while (dist > 0 && r.next != null) {
            r = r.next;
            --dist;
        }
        
        while (r.next != null) {
            r = r.next;
            l = l.next;
            prev = prev.next;
        }
        
        prev.next = l.next;
        return dummy.next;
    }
}
