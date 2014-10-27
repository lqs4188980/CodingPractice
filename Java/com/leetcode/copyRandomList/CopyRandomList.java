package com.leetcode.copyRandomList;

import java.util.HashMap;
import com.leetcode.dataStructures.RandomListNode;

public class CopyRandomList {

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        
        // Duplicate each node
        // Also we need a map hear, <l1Addr, l2Node>, maybe faster.
        HashMap<RandomListNode, RandomListNode> randomMap = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode p1 = head;
        RandomListNode l2 = new RandomListNode(p1.label);
        RandomListNode p2 = l2;
        randomMap.put(head, l2);
        p1 = p1.next;
        
        // Copy a new list alone the next pointer and build mapping relation
        while(p1 != null){
            RandomListNode temp = new RandomListNode(p1.label);
            randomMap.put(p1, temp);
            p2.next = temp;
            p2 = p2.next;
            p1 = p1.next;
        }
        
        // Fix random pointer in the new list
        p1 = head;
        p2 = l2;
        while(p2 != null){
            p2.random = randomMap.get(p1.random);
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return l2;
        
    }

}
