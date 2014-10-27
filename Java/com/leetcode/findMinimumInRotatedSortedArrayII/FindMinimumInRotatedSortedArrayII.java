package com.leetcode.findMinimumInRotatedSortedArrayII;

public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] num) {

        if (num == null || num.length == 0) {
            return -1;
        }
        
        if (num.length == 1) {
            return num[0];
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < num.length; i++) {
            if (num[i] < min) {
                min = num[i];
            }
        }
        return min;
    }
}
