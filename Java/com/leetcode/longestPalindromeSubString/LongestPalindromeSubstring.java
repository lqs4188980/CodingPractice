package com.leetcode.longestPalindromeSubString;

public class LongestPalindromeSubstring {

	
	
	public String longestPalindrome(String s) {
        
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        
        boolean[][] palin = new boolean[s.length()][s.length()];
        for (int i = 0; i < palin.length; ++i) {
            palin[i][i] = true;
        }
        
        int max = 1;
        int start = 0;
        int end = 0;
        for (int i = 1; i < s.length(); ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j < 2 || palin[i - 1][j + 1]) {
                        palin[i][j] = true;
                    }
                    
                    if (palin[i][j]) {
                        int length = i - j + 1;
                        if (length > max) {
                            start = j;
                            end = i;
                            max = length;
                        }
                    }
                }
            }
        }
        
        return s.substring(start, end + 1);
    }

}
