package com.leetcode.mergeKLists;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.dataStructures.ListNode;

public class MergeKLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		lists.add(null);
		ListNode node = new ListNode(-1);
		node.next = new ListNode(5);
		node.next = new ListNode(11);
		lists.add(node);
		lists.add(null);
		node = new ListNode(6);
		node.next = new ListNode(10);
		lists.add(node);
		
		System.out.println(lists);
		
		System.out.println(merge(0, lists.size(), lists).val);
	}
	
    public static ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        return merge(0, lists.size(), lists);

    }
    
    private static ListNode merge(int index, int length, List<ListNode> lists) {
        if (length == 1) {
            ListNode head = new ListNode(-1);
            ListNode pt = head;
            ListNode scanner = lists.get(index);
            while (scanner != null) {
                pt.next = scanner;
                scanner = scanner.next;
                pt = pt.next;
            }
            
            head = head.next;
            return head;
            
        }
        
        int halfSize = length / 2;
        ListNode leftList = merge(index, halfSize, lists);
        ListNode rightList = merge(index + halfSize, length - halfSize, lists);
        
        ListNode pt1 = leftList,
                 pt2 = rightList,
                 list = new ListNode(-1),
                 pt3 = list;
                 
        while (pt1 != null || pt2 != null) {
        	
            if (pt1 != null && pt2 == null) {
            	System.out.println("pt1 not null");
                pt3.next = pt1;
                break;
            } else if (pt1 == null && pt2 != null) {
            	System.out.println("pt2 not null");
                pt3.next = pt2;
                break;
            } else if (pt1 != null && pt2 != null) {
            	System.out.println("both not null");
            	printList(pt1);
            	printList(pt2);
                if (pt1.val < pt2.val) {
                    pt3.next = pt1;
                    pt1 = pt1.next;
                    pt3 = pt3.next;
                } else {
                    pt3.next = pt2;
                    pt2 = pt2.next;
                    pt3 = pt3.next;
                }
            }
        }
        
        list = list.next;
        return list;
    }
    
    private static void printList(ListNode node) {
    	ListNode pt = node;
    	while (pt != null) {
    		System.out.print(pt.val + ' ');
    		pt = pt.next;
    	}
    	System.out.print('\n');
    }

}
