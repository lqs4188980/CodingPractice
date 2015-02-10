package com.leetcode.largestNumber;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestNumber {
	public String largestNumber(int[] num) {
        if (num == null || num.length == 0) {
            return "";
        }
        
        PriorityQueue<String> pq = new PriorityQueue<String>(num.length, new Comparator<String>() {
        	public int compare(String s1, String s2) {
                if (s1.equals(s2)) {
                    return 0;
                }
                
                return -(s1 + s2).compareTo(s2 + s1);
            }
		});
        
        int cache = 0;
        for (int i = 0; i < num.length; ++i) {
            if (num[i] != 0) {
                cache = num[i];
            }
            pq.add(String.valueOf(num[i]));
        }
        
        if (cache == 0) {
            return "0";
        }
        
        StringBuilder b = new StringBuilder();
        
        
        while (pq.size() != 0) {
            b.append(pq.poll());
        }
        
        return b.toString();
    }
}
