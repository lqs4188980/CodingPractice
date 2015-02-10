package com.leetcode.searchForARange;

public class SearchForARange {
	public int[] searchRange(int[] A, int target) {
        int[] range = new int[2];
        range[0] = -1;
        range[1] = -1;
        
        if (A == null || A.length == 0) {
            return range;    
        }
        
        updateRange(A, 0, A.length - 1, target, range);
        
        return range;
    }
    
    private void updateRange(int[] A, int start, int end, int target, int[] range) {
        if (start > end) {
            return;
        }
        
        int mid = (start + end) / 2;
        
        if (A[mid] == target) {
            if (range[0] == -1) {
                range[0] = mid;
                range[1] = mid;
            } else {
                range[0] = Math.min(range[0], mid);
                range[1] = Math.max(range[1], mid);
            }
            
            updateRange(A, start, mid - 1, target, range);
            updateRange(A, mid + 1, end, target, range);
            return;
        }
        
        if (A[mid] < target) {
            updateRange(A, mid + 1, end, target, range);
        } else {
            updateRange(A, start, mid - 1, target, range);
        }
    }
}
