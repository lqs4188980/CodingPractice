package com.leetcode.singleNumberII;

public class SingleNumberII {
	
	// Basic idea is calculate the count of each bit, if one bit appears 3 times, then the count % 3 should be zero. 
	// The remaining bit is only appear once, so it is belonging to the single number.
	int singleNumber(int A[], int n) {
	    int ones = 0, twos = 0, threes = 0;
	    for (int i = 0; i < n; i++) {
	        twos |= ones & A[i];
	        ones ^= A[i];// 异或3次 和 异或 1次的结果是一样的
	       //对于ones 和 twos 把出现了3次的位置设置为0 （取反之后1的位置为0）
	        threes = ones & twos;
	        ones &= ~threes;
	        twos &= ~threes;
	    }
	    return ones;
	}
}
