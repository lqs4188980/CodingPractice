package com.leetcode.factorialTrailingZeroes;

public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
        if (n < 5) {
            return 0;
        }
        
        long pwofFive = 5;
        
        long quotient = Integer.MAX_VALUE;
        long sum = 0;
        while (quotient > 0) {
            quotient = n / pwofFive;
            sum += quotient;
            pwofFive *= 5;
        }
        
        return (int)sum;
    }
}
