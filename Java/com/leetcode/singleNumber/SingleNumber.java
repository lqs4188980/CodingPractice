package com.leetcode.singleNumber;

public class SingleNumber {
	
	// Exclusive or all the number. The remaining number is the single number
    public int singleNumber(int[] A) {
        int rv = 0;
        for(int i = 0; i < A.length; i++){
            rv ^= A[i];
        }
        return rv;
    }
}
