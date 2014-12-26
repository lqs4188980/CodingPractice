package com.leetcode.wildcardMatching;

public class WildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WildcardMatching instance = new WildcardMatching();
		System.out.println(instance.isMatch("hi", "*?"));
	}
	
	public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (s.length() == 0 && p.length() == 0 || s.equals(p)) {
            return true;
        }
        
        int Slength = s.length(),
            Plength = p.length();
        
        int p1 = 0,
            p2 = 0;
        int lastMatch = -1;
        while (p1 < Slength || p2 < Plength) {
            if (p1 == Slength && p2 < Plength) {
                if (p2 == Plength - 1 && p.charAt(p2) == '*') {
                    return true;
                }
                System.out.println("#1");
                return false;
            } 
            if (p1 < Slength && p2 == Plength) {
            	System.out.println("#2");
                return false;
            }
            
            
            while (p2 < Plength && p.charAt(p2) == '*') {
                ++p2;
            }
            
            if (p2 == Plength) {
                return true;
            }
            
            char token = p.charAt(p2);
            
            if (token == '?') {
                lastMatch = p1;
                ++p1;
            } else {
                if (token != s.charAt(p1) && p2 - 1 >= 0 && p.charAt(p2 - 1) == '*') {
                    p1 = lastMatch + 1;
                    while (p1 < Slength && s.charAt(p1) != token) {
                        ++p1;
                    }
                    if (p1 == Slength) {
                    	System.out.println("#3");
                        return false;
                    } else {
                        lastMatch = p1;
                        ++p1;
                    }
                } else if (token != s.charAt(p1) && p2 - 1 < 0) {
                	System.out.println("#4");
                    return false;
                } else if (token != s.charAt(p1) && p.charAt(p2 - 1) != '*') {
                    p1 = lastMatch + 1;
                    while (p2 >= 0 && p.charAt(p2) != '*') {
                        --p2;
                    }
                    
                    if (p2 < 0) {
                    	System.out.println("#5");
                        return false;
                    }
                } else {
                    lastMatch = p1;
                    ++p1;
                }
            }
            
            ++p2;
        }
        return true;
    }

}
