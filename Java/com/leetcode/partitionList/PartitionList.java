package com.leetcode.partitionList;

import com.leetcode.dataStructures.ListNode;

public class PartitionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		ListNode rv = partition(head, 2);
		while (rv != null) {
			System.out.println(rv.val);
			rv = rv.next;
		}

	}
	
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

}
