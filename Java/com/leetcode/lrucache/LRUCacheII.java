package com.leetcode.lrucache;

import java.util.HashMap;
import java.util.LinkedList;

/*
 * This implementation using LinkedList implementation
 */
public class LRUCacheII {
    private final LinkedList<Cache> queue;
    private final HashMap<Integer, Cache> map;
    private final int volume;
    private int count;
    public LRUCacheII(int capacity) {
        queue = new LinkedList<Cache>();
        map = new HashMap<Integer, Cache>();
        volume = capacity;
        count = 0;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            queue.remove(map.get(key));
            queue.add(map.get(key));
            return map.get(key).getValue();
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).setValue(value);
            queue.remove(map.get(key));
            queue.add(map.get(key));
        } else {
            if (count < volume) {
                Cache c = new Cache(key, value);
                map.put(key, c);
                queue.add(c);
                count++;
            } else {
                map.remove(queue.poll().getKey());
                Cache c = new Cache(key, value);
                map.put(key, c);
                queue.add(c);
            }
        }
    }
}

class Cache {
    private final int key;
    private int value;
    
    Cache(int key, int value) {
        this.key = key;
        this.value = value;
    }
    
    public int getKey() {
        return key;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
