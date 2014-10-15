package com.leetcode.insertionSortList;

public class InsertionSortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        // This will be the new list head
        ListNode i = new ListNode(head.val);
        
        ListNode current, pre;
        while(head.next != null){
            head = head.next;
            current = i;
            pre = i;
            while(current.next != null && current.val <= head.val){
                pre = current;
                current = current.next;
            }
            
            // On the head
            if(pre == current){
                if(current.val > head.val){
                    ListNode node = new ListNode(head.val);
                    node.next = i;
                    i = node;
                    continue;
                }
            }
            if(current.next == null){
                if(current.val <= head.val){
                    ListNode node = new ListNode(head.val);
                    current.next = node;
                    continue;
                }
                
            }
            ListNode node = new ListNode(head.val);
            pre.next = node;
            node.next = current;
        }
        
        return i;
    }
}
