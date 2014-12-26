package com.leetcode.jumpGameII;

public class JumpGameII {
	public int jump(int[] A) {
        if (A == null || A.length == 0 || A.length == 1) {
            return 0;
        }
        
        int start = 0;
        int end = 0;
        int max = 0;
        int step = 0;
        int last = A.length - 1;
        while (start <= end && end < last) {
            for (int i = start; i <= end; ++i) {
                max = Math.max(A[i] + i, max);
                if (max >= last) {
                    return step + 1;
                }
            }
            start = end + 1;
            end = max;
            ++step;
        }
        
        return step;
    }
}
