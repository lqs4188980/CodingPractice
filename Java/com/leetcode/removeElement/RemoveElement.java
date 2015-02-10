package com.leetcode.removeElement;

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int i = 0;
        int j = A.length - 1;
        while (i <= j) {
            if (A[i] == elem) {
                A[i] = A[j--];
            } else {
                ++i;
            }
        }
        
        return j + 1;
    }
}
