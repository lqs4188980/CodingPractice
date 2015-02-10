package com.leetcode.firstMissingPositive;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }
        
        int temp = -1;
        int i = 0;
        while (i < A.length) {
            if (A[i] <= A.length && A[i] > 0 && A[i] != A[A[i] - 1]) {
                temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
            } else {
                ++i;
            }
        }
        
        for (int j = 0; j < A.length; ++j) {
            if (A[j] != j + 1) {
                return j + 1;
            }
        }
        
        return A.length + 1;
    }
}
