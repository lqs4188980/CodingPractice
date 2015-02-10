package com.leetcode.countAndSay;

import java.util.LinkedList;

public class CountAndSay {
	
	public String countAndSay(int n) {
        if (n < 1) {
            return "";
        }
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        int cache = -1,
            counter = 0,
            curr = -1,
            level = 1;
            
        queue.add(1);
        queue.add(0);
        
        while (level < n) {
            curr = queue.pop();
            if (curr != 0) {
                if (cache != -1) {
                    if (cache != curr) {
                        queue.add(counter);
                        queue.add(cache);
                        cache = curr;
                        counter = 1;
                    } else {
                        ++counter;
                    }
                } else {
                    cache = curr;
                    counter = 1;
                }
                
            } else {
                ++level;
                queue.add(counter);
                queue.add(cache);
                cache = -1;
                counter = 0;
                
                queue.add(0);
            }
        }
        
        StringBuilder b = new StringBuilder();
        while ((curr = queue.pop()) != 0) {
            b.append(curr);
        }
        
        return b.toString();
    }

}
