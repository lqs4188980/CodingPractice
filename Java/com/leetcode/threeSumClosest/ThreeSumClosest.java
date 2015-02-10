package com.leetcode.threeSumClosest;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3) {
            return Integer.MAX_VALUE;
        }
        
        int j = -1, k = -1, remain = -1, min = Integer.MAX_VALUE, value = -1, dist = -1, sum = -1;
        Arrays.sort(num);
        for (int i = 0; i < num.length; ++i) {
            remain = target - num[i];
            j = i + 1;
            k = num.length - 1;
            while (j < k) {
                value = num[j] + num[k];
                dist = Math.abs(value - remain);
                
                if (dist < min) {
                    min = dist;
                    sum = num[i] + value;
                } 
                
                if (value > remain) {
                    --k;
                } else {
                    ++j;
                }
            }
        }
        
        return sum;
    }
}
