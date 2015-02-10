package com.leetcode.trappingRainWater;

public class TrappingRainWater {
	public int trap(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int[] leftMax = new int[A.length];
        
        leftMax[0] = -1;
        int max = A[0];
        for (int i = 1; i < A.length; ++i) {
            leftMax[i] = max;
            if (A[i] > max) {
                max = A[i];
            }
        }
        
        max = A[A.length - 1];
        int area = 0;
        for (int i = A.length - 2; i >= 0; --i) {
            area += Math.max(0, Math.min(leftMax[i], max) - A[i]);
            if (A[i] > max) {
                max = A[i];
            }
        }
        
        return area;
    }
	
	/* O(n) time complexity, O(1) space complexity
	public int trap(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int l = 0,
            r = A.length - 1,
            area = 0,
            min = -1;
            
        while (l < r) {
            if (A[l] < A[r]) {
                min = A[l];
                ++l;
                
                while (l < r && A[l] <= min) {
                    area += min - A[l];
                    ++l;
                }
            } else {
                min = A[r];
                --r;
                
                while (l < r && A[r] <= min) {
                    area += min - A[r];
                    --r;
                }
            }
        }
        
        return area;
    }
	 */
}
