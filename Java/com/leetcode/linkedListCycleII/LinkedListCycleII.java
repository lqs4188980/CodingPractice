package com.leetcode.linkedListCycleII;

import com.leetcode.dataStructures.ListNode;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        if(head.next == head)
            return head;
        
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCircle = false;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
            if(fast.next == null){
                return null;
            }
            fast = fast.next;
            if(slow == fast){
                hasCircle = true;
                break;
            }
        }
        if(!hasCircle)
            return null;
        slow = head;
        if(head == fast)
            return head;
        while(true){
            slow = slow.next;
            fast = fast.next;
            if(slow == fast){
                return slow;
            }
        }
    }
}
