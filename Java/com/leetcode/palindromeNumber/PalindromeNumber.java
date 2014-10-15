package com.leetcode.palindromeNumber;

public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isPalindrome(1000000001);
	}
	
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        long order = 1;
        int digits = 0;
        while (x / order > 0) {
            order *= 10;
            digits++;
        }
        System.out.println("Original: " + order);
        order /= 10;
        //order = (int)order;
        //System.out.println("Converted: " + order);
        int i = 1,
            j = digits;
            
        while (i <= j) {
        	System.out.println(x);
        	System.out.println(order);
        	System.out.println(x / order);
        	System.out.println(x % 10 + "\n\n");
            if ((x / order) != x % 10) {
                return false;
            }
            
            i++;
            j--;
            x = (int) (x - (x / order) * order);
            order /= 100;
            x /= 10;
        }
        
        return true;
        
        
    }

}
