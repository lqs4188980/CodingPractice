package com.leetcode.findMinimumInRotatedSortedArray;

public class FindMinimumInRotatedSortedArray {
	public static void main(String[] args) {
	
	}

	public int findMin(int[] num) {
        	// Binary Search
        	// Terminate Condition: num[mid] < num[mid - 1] && num[mid] < num[mid + 1]
        	// Invariance: num[mid] < num[up] && num[mid] > num[low]
        	// Loop Condition: up > low
        	// If num[mid] > num[up]: low = mid + 1
        	// If num[mid] < num[low]: up = mid - 1
        	
        	if (num.length == 1) {
        	    return num[0];
        	}
        	
        	int up = num.length - 1,
        	    low = 0,
        	    mid = (up + low) / 2;
        	while (up > low) {
        	    if (mid + 1 < num.length && mid - 1 >= 0 && num[mid] < num[mid - 1] && num[mid] < num[mid + 1]) {
        	        return num[mid];
        	    }
        	    if (num[mid] > num[up]) {
        	        low = mid + 1;
        	    } else {
        	        up = mid - 1;
        	    }
        	    
        	    mid = (up + low) / 2;
        	}
        	return num[mid];
	}
}
