package com.leetcode.intersectionOfTwoLinkedLists;

import com.leetcode.dataStructures.ListNode;

public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /*
            We can connect A's tail to A's head and start discover circle from B. If there is a circle from B, then the circle will finally meet; else they will never meet.
        */
        
        if (headA == null || headB == null) {
            return null;
        }
        
        if (headA == headB) {
            return headA;
        }
        
        // Traverse A and link its tail to head
        ListNode pt = headA;
        while (pt.next != null) {
            pt = pt.next;
        }
        
        // We need to store the tail so that we can recover it later
        ListNode tailA = pt;
        pt.next = headA;
        
        // Traverse from B, fast pointer and slow pointer
        ListNode l = headB;
        ListNode r = headB;
        while (r != null) {
            r = r.next;
            if (r != null) {
                l = l.next;
                r = r.next;
            } else {
                // Reach the end of B, no loop, break.
                break;
            }
            
            if (l == r) {
                // There is a loop, and we need to find intersection later
                break;
            }
        }
        
        if (r == null) {
            // r reaches end of B, no loop
            tailA.next = null;
            return null;
        }
        
        // We place l to the head of B, then l and r proceed one node each time, when they meet again, the node is the intersection point
        l = headB;
        while (l != r) {
            l = l.next;
            r = r.next;
        }
        
        // Recover tailA
        tailA.next = null;
        
        return l;
    }
}
