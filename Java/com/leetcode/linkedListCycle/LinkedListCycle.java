package com.leetcode.linkedListCycle;

import com.leetcode.dataStructures.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        // We use two pointers: one will access every node; the other one will access every two node. If they can finally meet, then there is a cycle in the list. If one pointer is reaching the end, there is no cycle.
        
        if (head == null) {
            return false;
        }
        
        ListNode pt1 = head;
        ListNode pt2 = head;
        while (pt2 != null) {
            pt1 = pt1.next;
            pt2 = pt2.next;
            if (pt2 != null) {
                pt2 = pt2.next;
            } else {
                return false;
            }
            
            if (pt1 == pt2) {
                return true;
            }
        }
        
        return false;
    }
}
