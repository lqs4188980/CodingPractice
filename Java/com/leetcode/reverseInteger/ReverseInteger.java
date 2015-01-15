package com.leetcode.reverseInteger;

public class ReverseInteger {
	
	public int reverse(int x) {
        if (x > -10 && x < 10) {
            return x;
        }
        
        long reverse = 0;
        long temp = x;
        int sign = 1;
        
        if (temp < 0) {
            sign = -1;
            temp *= -1;
        }
        
        while (temp > 0) {
            reverse = reverse * 10 + temp % 10;
            temp /= 10;
        }
        
        reverse *= sign;
        
        if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
            return 0;
        }
        
        return (int)reverse;
    }

}
