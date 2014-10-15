package com.leetcode.longestPalindromeSubString;

public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longestPalindrome("aaaa");
	}
	
    public static String longestPalindrome(String s) {
        
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        
        int length = s.length();
        boolean[][] state = new boolean[length][length];
        
        for (int i = 0; i < length; i++) {
            state[i][i] = true;
        }
        
        int 
            max = 0,
            start = 0,
            end = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
            	System.out.println("j: " + j + ", i: " + i);
                state[j][i] = (s.charAt(j) == s.charAt(i) && (i - j < 2 || state[j + 1][i - 1]));
                System.out.println("state[" + j + "]" + "[" + i + "] = " + state[j][i]);
                if (state[j][i] && i - j + 1 > max) {
                	System.out.println("Update start and end");
                    max = i - j + 1;
                    start = j;
                    end = i;
                }
            }
        }
        
        System.out.println("start: " + start + ", end: " + end);
        return s.substring(start, end + 1);
    }

}
