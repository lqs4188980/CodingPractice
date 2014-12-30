package com.leetcode.firstMissingPositive;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
        int i = 0;
        while (i < A.length) {
            
            if (A[i] > 0 && A[i] < A.length && A[i] != A[A[i] - 1]) {
                int temp = A[i];
                A[i] = A[temp - 1];
                A[temp - 1] = temp;
                i--;
            }
            
            i++;
        }
        
        for (i = 0; i < A.length; i++) {
            if (A[i] != (i + 1)) {
                return i + 1;
            }
        }
        
        return A.length + 1;
    }
}
