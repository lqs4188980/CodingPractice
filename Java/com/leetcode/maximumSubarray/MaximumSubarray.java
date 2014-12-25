package com.leetcode.maximumSubarray;

public class MaximumSubarray {
	public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        
        int maxSofar = Integer.MIN_VALUE;
        int maxEndhere = 0;
        for (int i = 0; i < A.length; ++i) {
            maxEndhere = Math.max(maxEndhere + A[i], A[i]);
            maxSofar = Math.max(maxEndhere, maxSofar);
        }
        
        return maxSofar;
    }
}
