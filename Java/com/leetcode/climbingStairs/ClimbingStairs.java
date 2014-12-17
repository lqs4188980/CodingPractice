package com.leetcode.climbingStairs;

public class ClimbingStairs {
	public int climbStairs(int n) {
        // I try some bottom-up method
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        
        int[] table = new int[2];
        
        table[0] = 1;
        table[1] = 2;
        
        int value = -1;
        for (int i = 3; i <= n; ++i) {
            value = table[0] + table[1];
            table[0] = table[1];
            table[1] = value;
        }
        
        return table[1];
    }
}
