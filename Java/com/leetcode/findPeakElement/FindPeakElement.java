package com.leetcode.findPeakElement;

public class FindPeakElement {
	public int findPeakElement(int[] num) {
        // Binary search edition
        if (num.length == 1) {
            return 0;
        }
        
        int mid = 0;
        int l = 0;
        int r = num.length - 1;
        
        while (l <= r) {
            mid = (l + r) / 2;
            if ((mid == 0 || num[mid] >= num[mid - 1]) && (mid == num.length - 1 || num[mid] >= num[mid + 1])) {
                return mid;
            }
            
            if (mid > 0 && num[mid - 1] > num[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return l;
        
    }
    
    /*
    public int findPeakElement(int[] num) {
        if (num.length == 1) {
            return 0;
        }
        
        for (int i = 1; i < num.length; ++i) {
            // i - 1 is peek
            if (num[i] < num[i - 1]) {
                return i - 1;
            }
        }
        
        return num.length - 1;
    }
    */
}
