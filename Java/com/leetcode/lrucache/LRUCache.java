package com.leetcode.lrucache;

import java.util.HashMap;

/*
 * The main idea of this implementation is using HashMap for fast accessing, 
 * and using queue for tracking most recently unused cache.
 * We create cache objects and add them into queue, also we map the cache's key to the reference of the cache objects.
 */
public class LRUCache {
	/*
	 * The implementation using self-defined link list as queue, which is two times faster than using LinkedList class as queue.
	 */
	int capacity;
    int count = 0;
    HashMap<Integer, ListNode> mMap;
    static ListNode head;
    ListNode tail;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache obj = new LRUCache(2);
		obj.get(2);
		obj.showList(head);
		obj.set(2, 6);
		obj.showList(head);
		obj.get(1);
		obj.showList(head);
		obj.set(1, 5);
		obj.showList(head);
		obj.set(1,2);
		obj.showList(head);
		obj.get(1);
		obj.showList(head);
		obj.get(2);
		obj.showList(head);

	}
	
    
    public LRUCache(int capacity) {
        // Maintain a map to track the key and value, and maintain a queue to track recently used.
        mMap = new HashMap<Integer, ListNode>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        // Each time we get, we need to query map first to get the value and then remove key from queue and enqueue that key
        if(mMap.containsKey(key)){
            ListNode node = mMap.get(key);
            moveToHead(node);
            return node.val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        // Test if the cache if full, if it is full, poll a key from queue and remove from map, then add a new one; if still empty insert or set the value and add the key to queue update count;
        if(mMap.containsKey(key)){
        	ListNode node = mMap.get(key);
            node.val = value;
            moveToHead(node);
        }
        else{
        	if(count != capacity){
        		if(count == 0){
        			head = new ListNode(key, value);
        			tail = head;
        			mMap.put(key, head);
        		}
        		else{
        			ListNode node = new ListNode(key, value);
        			addToHead(node);
        			mMap.put(key, node);
        		}
        		count++;
        	}
        	else{
                mMap.remove(tail.key);
                removeTail();
                count--;
                set(key, value);
            }
        }
        
        
    }
    
    public void moveToHead(ListNode node){
    	System.out.println(node + ", " + head);
        if(node != head){
        	System.out.println(node + ", " + tail);
            if(node == tail){
                tail = tail.prev;
                tail.next = null;
                head.prev = node;
                node.next = head;
                head = head.prev;
            }
            else{
                node.prev.next = node.next;
                node.next.prev = node.prev;
                head.prev = node;
                node.next = head;
                head = head.prev;
            }
        }

    }
    public void addToHead(ListNode node){
        head.prev = node;
        node.next = head;
        head = head.prev;
    }
    public void removeTail(){
        tail = tail.prev;
        if(tail != null)
            tail.next = null;
    }
    
    public void showList(ListNode head){
    	System.out.println("*******************************************************************");
    	while(head != null){
    		System.out.println(head.val);
    		head = head.next;
    	}
    	System.out.println("*******************************************************************");
    }
    public void showMap(HashMap<Integer, ListNode> mMap) {
		
	}

}
