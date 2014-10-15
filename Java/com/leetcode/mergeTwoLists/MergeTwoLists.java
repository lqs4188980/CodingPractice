package com.leetcode.mergeTwoLists;

public class MergeTwoLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mergeTwoLists(new ListNode(2), new ListNode(1));
	}
	
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

}
