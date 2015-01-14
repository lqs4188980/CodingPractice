package com.leetcode.medianOfTwoSortedArrays;

public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
        if ((A.length + B.length) % 2 == 0) {
            return (getKth(A, 0, A.length, B, 0, B.length, (A.length + B.length) / 2) + getKth(A, 0, A.length, B, 0, B.length, (A.length + B.length) / 2 + 1)) / 2.0;
            
        } else {
            return (double)getKth(A, 0, A.length, B, 0, B.length, (A.length + B.length) / 2 + 1);
        }
        
    }
    
    
    
    private int getKth(int[] A, int A_start, int A_length, int[] B, int B_start, int B_length, int k) {
        if (A_length <= 0) {
            return B[B_start + k - 1];
        } 
        
        if (B_length <= 0) {
            return A[A_start + k - 1];
        }
        
        if (k <= 1) {
            return Math.min(A[A_start], B[B_start]);
        }
        
        if (A[A_start + A_length / 2] >= B[B_start + B_length / 2]) {
            if (A_length / 2 + B_length / 2 + 1 >= k) {
                return getKth(A, A_start, A_length / 2, B, B_start, B_length, k);
            } else {
                return getKth(A, A_start, A_length, B, B_start + B_length / 2 + 1, B_length - (B_length / 2 + 1), k - (B_length / 2 + 1));
            }
        } else {
            if (A_length / 2 + B_length / 2 + 1 >= k) {
                return getKth(A, A_start, A_length, B, B_start, B_length / 2, k);
            } else {
                return getKth(A, A_start + (A_length / 2 + 1), A_length - (A_length / 2 + 1), B, B_start, B_length, k - (A_length / 2 + 1));
            }
        }
    }
}
