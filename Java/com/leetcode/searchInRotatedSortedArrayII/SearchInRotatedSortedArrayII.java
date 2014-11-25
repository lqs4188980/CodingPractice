package com.leetcode.searchInRotatedSortedArrayII;

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
    	
    	// This solution is like a shit. The main idea is find a range that is ascending.
        if (A == null || A.length == 0) {
            return false;
        }
        
        int l = 0, r = A.length - 1, mid = 0;
        
        while (l <= r) {
            mid = (l + r) / 2;
            if (A[mid] == target) {
                return true;
            } 
            
            if (A[l] == A[r]) {
                ++l;
                continue;
            }
            
            // No Rotation between l and r
            if (A[l] < A[r]) {
                if (A[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (A[l] < A[mid]) {
                    if (target > A[l] && target < A[mid]) {
                        r = mid - 1;
                    } else if (target > A[mid] || target < A[l]) {
                        l = mid + 1;
                    } else if (target == A[l]){
                        return true;
                    }
                } else if (A[l] == A[mid]){
                    l = mid + 1;
                } else if (A[r] > A[mid]){
                    if (target > A[mid] && target < A[r]) {
                        l = mid + 1;
                    } else if (target < A[mid] || target > A[r]) {
                        r = mid - 1;
                    } else if (target == A[r]) {
                        return true;
                    }
                } else if (A[r] == A[mid]) {
                    r = mid - 1;
                }
            }
        }
        
        return false;
    }
}
