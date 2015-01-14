package com.leetcode.addTwoNumbers;

import com.leetcode.dataStructures.ListNode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 != null && l2 == null) {
            return l1;
        } else if (l1 == null && l2 != null) {
            return l2;
        }
        
        ListNode dummy = new ListNode(-1);
        int carry = 0;
        ListNode pt = dummy;
        
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        while (p1 != null && p2 != null) {
            int raw = p1.val + p2.val + carry;
            pt.next = new ListNode(raw % 10);
            carry = raw / 10;
            pt = pt.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        
        ListNode tail = p1 == null ? p2 : p1;
        while (tail != null) {
            int raw = tail.val + carry;
            pt.next = new ListNode(raw % 10);
            carry = raw / 10;
            pt = pt.next;
            tail = tail.next;
        }
        
        if (carry != 0) {
            pt.next = new ListNode(carry);
        }
        
        return dummy.next;
    }
}
