package com.leetcode.trappingRainWater;

public class TrappingRainWater {
	public int trap(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        
        int[] leftMax = new int[A.length];
        int[] rightMax = new int[A.length];
        int max = -1;
        
        leftMax[0] = 0;
        max = A[0];
        for (int i = 1; i < A.length; ++i) {
            leftMax[i] = max;
            if (max < A[i]) {
                max = A[i];
            }
        }
        
        int ct = 0;
        int res = 0;
        
        rightMax[A.length - 1] = 0;
        max = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; --i) {
            rightMax[i] = max;
            if (max < A[i]) {
                max = A[i];
            }
            
            ct = Math.min(leftMax[i], rightMax[i]) - A[i];
            if (ct > 0) {
                res += ct;
            }
        }
        
        return res;
    }
}
