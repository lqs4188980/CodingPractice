package com.leetcode.regularExpressionMatching;

public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
        return recurseMatch(s, 0, p, 0);
    }
    
    private boolean recurseMatch(String s, int i, String p, int j) {
        if (j == p.length()) {
            return i == s.length();
        }
        
        if ((j + 1 < p.length() && p.charAt(j + 1) != '*') || (j + 1 == p.length())) {
            return i < s.length() &&
                    ((p.charAt(j) == s.charAt(i)) || (p.charAt(j) == '.')) &&
                    recurseMatch(s, i + 1, p, j + 1);
        }
        
        while ((i < s.length()) && ((p.charAt(j) == s.charAt(i)) || (p.charAt(j) == '.'))) {
            if (recurseMatch(s, i, p, j + 2)) {
                return true;
            }
            ++i;
        }
        
        return recurseMatch(s, i, p, j + 2);
    }
}
