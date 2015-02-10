package com.leetcode.searchInRotatedSortedArray;

public class SearchInRotatedSortedArray {
	public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int l = 0,
            r = A.length - 1,
            mid = 0;
            
        while (l <= r) {
            mid = (l + r) / 2;
            if (A[mid] == target) {
                return mid;
            } 
            
            if (A[l] <= A[mid]) {
                if (target < A[l] || target > A[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (target < A[mid] || target > A[r]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        
        return -1;
    }
}
