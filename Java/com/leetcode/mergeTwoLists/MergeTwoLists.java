package com.leetcode.mergeTwoLists;

public class MergeTwoLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeTwoLists instance = new MergeTwoLists();
		instance.mergeTwoLists(new ListNode(2), new ListNode(1));
	}
	
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Insert l2 into l1
        if (l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return l2;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = l1;
        
        ListNode pt1 = dummy;
        ListNode pt2 = l2;
        while (pt2 != null) {
            if (pt1.next != null) {
                if (pt2.val < pt1.next.val) {
                    ListNode node = pt2;
                    pt2 = pt2.next;
                    
                    node.next = pt1.next;
                    pt1.next = node;
                    pt1 = pt1.next;
                } else {
                    pt1 = pt1.next;
                }
            } else {
                ListNode node = pt2;
                pt2 = pt2.next;
                
                node.next = pt1.next;
                pt1.next = node;
            }
        }
        
        return dummy.next;
    }
	/*
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = null, current = null;
		
		if(l1 == null && l2 != null){
			return l2;
		}
		if(l2 == null && l1 != null){
			return l1;
		}
		if (l1 == null && l2 == null) {
			return null;
		}
		if(l1.val <= l2.val){
			head = l1;
			l1 = l1.next;
			current = head;
		}
		else {
			head = l2;
			l2 = l2.next;
			current = head;
		}
        while(l1 != null || l2 != null){
        	if(l1 == null && l2 != null){
    			current.next = l2;
    			l2 = l2.next;
    			current = current.next;
    			continue;
    		}
    		if(l2 == null && l1 != null){
    			current.next = l1;
    			l1 = l1.next;
    			current = current.next;
    			continue;
    		}
        	if(l1.val <= l2.val){
        		current.next = l1;
        		l1 = l1.next;
        		current = current.next;
        	}
        	else {
				current.next = l2;
				l2 = l2.next;
				current = current.next;
			}
        }
		return head;
    }
*/
}
