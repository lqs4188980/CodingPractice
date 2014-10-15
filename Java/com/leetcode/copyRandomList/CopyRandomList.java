package com.leetcode.copyRandomList;

import java.util.HashMap;
import java.util.Set;

public class CopyRandomList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomListNode n1 = new RandomListNode(-1);
		RandomListNode n2 = new RandomListNode(-1);
		n1.next = n2;
		n1.random = n2;
		n2.random = n1;
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n1.random);
		System.out.println(n2.random);
		System.out.println("*************************************************************************");
		copyRandomList(n1);
	}
	
	
    public static RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        if(head.next == null){
            RandomListNode node = new RandomListNode(head.label);
            node.random = head.random;
            return node;
        }
        // Duplicate each node
        // Also we need a map hear, <l1Addr, l2Node>, maybe faster.
        HashMap<RandomListNode, RandomListNode> randomMap = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode current = head;
        RandomListNode l2 = new RandomListNode(current.label);
        RandomListNode l2Temp = l2;
        randomMap.put(current, l2);
        current = current.next;
        while(current != null){
            RandomListNode temp = new RandomListNode(current.label);
            l2Temp.next = temp;
            randomMap.put(current, temp);
            l2Temp = l2Temp.next;
            current = current.next;
        }
        
        RandomListNode p1 = head;
        RandomListNode p2 = l2;
        while(p1 != null){
            p2.random = randomMap.get(p1.random);
            p1 = p1.next;
            p2 = p2.next;
        }
        Set<RandomListNode> keyset = randomMap.keySet();
        for(RandomListNode node : keyset){
        	System.out.println(node + ": " + randomMap.get(node));
        }
        System.out.println("**********************************************************************");
        System.out.println(l2);
        System.out.println(l2.next);
        System.out.println(l2.random);
        System.out.println(l2.next.random);
        System.out.println(l2.next.next);
        return l2;
        
    }

}
