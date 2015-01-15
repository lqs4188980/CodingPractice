package com.leetcode.palindromeNumber;

public class PalindromeNumber {

	
	public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        if (x < 10) {
            return true;
        }
        
        long order = 1;
        long temp = x;
        while (temp > 0) {
            order *= 10;
            temp /= 10;
        }
        
        order /= 10;
        
        temp = x;
        while (temp > 0) {
            if (temp / order != temp % 10) {
                return false;
            }
            
            temp = (temp - (temp / order) * order) / 10;
            order /= 100;
        }
        
        return true;
    }

}
