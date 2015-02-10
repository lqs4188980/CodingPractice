package com.leetcode.mergeKSortedLists;

import java.util.List;

import com.leetcode.dataStructures.ListNode;

public class MergeKSortedLists {
	public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        return merge(lists, 0, lists.size());
        
    }
    
    private ListNode merge(List<ListNode> lists, int start, int size) {
        if (size == 1) {
            return lists.get(start);
        }
        
        int half = size / 2;
        ListNode l = merge(lists, start, half);
        ListNode r = merge(lists, start + half, size - half);
        
        ListNode dummy = new ListNode(-1);
        ListNode pt = dummy;
        
        while (l != null && r != null) {
            if (l.val <= r.val) {
                pt.next = l;
                l = l.next;
            } else {
                pt.next = r;
                r = r.next;
            }
            
            pt = pt.next;
        }
        
        ListNode smaller = (l == null ? r : l);
        while (smaller != null) {
            pt.next = smaller;
            smaller = smaller.next;
            pt = pt.next;
        }
        
        return dummy.next;
    }
}
