package com.leetcode.insertionSortList;

public class InsertionSortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode newHead = new ListNode(-1),
                ptNew = newHead,
                pt = head,
                temp = null;
        
        while (pt != null) {
            temp = pt;
            pt = pt.next;
            temp.next = null;
            
            while (ptNew.next != null && ptNew.next.val < temp.val) {
                    ptNew = ptNew.next;
            }
            temp.next = ptNew.next;
            ptNew.next = temp;
            
            ptNew = newHead;
        }
        
        return newHead.next;
    }
}
