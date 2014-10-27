package com.leetcode.sortList;

import com.leetcode.dataStructures.ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        int length = 0;
        ListNode pt = head;
        while (pt != null) {
            pt = pt.next;
            length++;
        }
        return merge(head, length);
    }
    
    private ListNode merge(ListNode head, int length) {
        ListNode newHead = new ListNode(-1);
        // ListNode prev = newHead;
        ListNode pt = newHead;
        ListNode nextStart = head;
        ListNode tail = null;
        int round = length;
        int unit = 1;
        int count = 0;
        
        ListNode left = null,
                right = null;
        while (round > 0) {
            while (count < length) {
                left = nextStart;
                right = left;
                
                for (int i = 0; i < unit && right != null; i++) {
                    tail = right;
                    right = right.next;
                }
                if (tail != null) {
                    tail.next = null;    
                }
                tail = right;
                for (int i = 0; i < unit - 1 && tail != null; i++) {
                    tail = tail.next;
                }
                if (tail != null) {
                    nextStart = tail.next;
                    tail.next = null;
                }
                
                while (left != null || right != null) {
                    if (left == null && right != null) {
                        pt.next = right;
                        right = right.next;
                        pt = pt.next;
                        
                    } else if (left != null && right == null) {
                        pt.next = left;
                        left = left.next;
                        pt = pt.next;
                        
                    } else {
                        if (left.val < right.val) {
                            pt.next = left;
                            left = left.next;
                            pt = pt.next;
                            
                        } else {
                            pt.next = right;
                            right = right.next;
                            pt = pt.next;
                        }
                    }
                    count++;
                }
                
            }
            count = 0;
            round = round >> 1;
            unit = unit << 1;
            pt.next = null;
            pt = newHead;
            nextStart = pt.next;
        }
        
        return newHead.next;
    }
}
