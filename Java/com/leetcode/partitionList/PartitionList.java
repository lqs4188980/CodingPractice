package com.leetcode.partitionList;

import com.leetcode.dataStructures.ListNode;

public class PartitionList {


	
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode pt = head;
        ListNode prev = dummy;
        ListNode breakPoint = null;
        
        dummy.next = head;
        while (pt != null) {
            if (pt.val < x) {
                prev = pt;
                pt = pt.next;
            } else {
                breakPoint = prev;
                while (pt != null && pt.val >= x) {
                    prev = pt;
                    pt = pt.next;
                }
                
                if (pt != null) {
                    prev.next = pt.next;
                    pt.next = breakPoint.next;
                    breakPoint.next = pt;
                } else {
                    return dummy.next;
                }
            }
        }
        
        return dummy.next;
    }
	/*
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode scanner = head, lessHead = new ListNode(Integer.MIN_VALUE), less = lessHead, greaterHead = new ListNode(Integer.MAX_VALUE), greater = greaterHead;
        
        while (scanner != null) {
            if (scanner.val < x) {
                less.next = scanner;
                less = less.next;
            } else {
                greater.next = scanner;
                greater = greater.next;
            }
            scanner = scanner.next;
        }
        
        lessHead = lessHead.next;
        greaterHead = greaterHead.next;
        less.next = greaterHead;
        greater.next = null;
        
        return lessHead;
    }
*/
}
