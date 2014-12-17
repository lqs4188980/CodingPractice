package com.leetcode.rotateList;

import com.leetcode.dataStructures.ListNode;

public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }
        
        ListNode pt = head;
        ListNode tail = pt;
        int length = 0;
        while (pt != null) {
            length++;
            tail = pt;
            pt = pt.next;
        }
        if (n % length == 0) {
            return head;
        }
        
        int remained = length - (n % length);
        
        ListNode prev = null;
        pt = head;
        for (int i = 0; i < remained; i++) {
            prev = pt;
            pt = pt.next;
        }
        
        tail.next = head;
        prev.next = null;
        head = pt;
        return head;
    }
}
