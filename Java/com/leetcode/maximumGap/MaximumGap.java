package com.leetcode.maximumGap;

import java.util.ArrayList;
import java.util.Iterator;

public class MaximumGap {
	public static void main(String[] argv) {
		MaximumGap instance = new MaximumGap();
		int[] num = {3, 6, 9 ,1};
		System.out.println(instance.maximumGap(num));
	}
	
public int maximumGap(int[] num) {
        
        if (num == null || num.length < 2) {
            return 0;
        }
        
        int mask = 1;
        ArrayList<Integer> pool = new ArrayList<Integer>();
        for (int i = 0; i < num.length; ++i) {
            pool.add(num[i]);
        }
        
        ArrayList<Integer> zeros = new ArrayList<Integer>();
        ArrayList<Integer> ones = new ArrayList<Integer>();
        for (int i = 0; i < 32; ++i) {
            mask = 1 << i;
            Iterator<Integer> iter = pool.iterator();
            while (iter.hasNext()) {
                int v = iter.next();
                if ((v & mask) != 0) {
                    ones.add(v);
                } else {
                    zeros.add(v);
                }
            }
            
            pool.clear();
            pool.addAll(zeros);
            pool.addAll(ones);
            zeros.clear();
            ones.clear();
        }
        
        int maxGap = -1;
        int cache = -1;
        for (int i = 1; i < num.length; ++i) {
            cache = pool.get(i) - pool.get(i - 1);
            if (cache > maxGap) {
                maxGap = cache;
            }
        }
        
        
        return maxGap;
    
    }
}
