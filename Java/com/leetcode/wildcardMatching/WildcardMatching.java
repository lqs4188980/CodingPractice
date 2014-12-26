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
        // Record the p1 position when encounter a * in p
        int lastP1 = -1;
        // Record last * position
        int lastStar = -1;
        // Decide if previous char of p2 is *
        boolean prevStar = false;
        while (p1 < Slength) {
            if (p2 == Plength && lastStar == -1) {
                return false;
            } else if (p2 == Plength && lastStar != -1) {
                p1 = lastP1 + 1;
                p2 = lastStar;
                continue;
            }
            
            char token = p.charAt(p2);
            if (token == '*') {
                while (p2 < Plength && p.charAt(p2) == '*') {
                    ++p2;
                }
                
                if (p2 == Plength) {
                    return true;
                }
                
                prevStar = true;
                lastStar = p2 - 1;
                lastP1 = p1;
                continue;
            }
            
            if (token == '?' || token == s.charAt(p1)) {
                ++p1;
                ++p2;
                prevStar = false;
                continue;
            } else {
                if (prevStar) {
                    ++p1;
                } else if (lastStar != -1) {
                    p1 = lastP1 + 1;
                    p2 = lastStar;
                } else {
                    return false;
                }
            }
        }
        
        while (p2 < Plength && p.charAt(p2) == '*') {
            ++p2;
        }
        
        if (p2 == Plength) {
            return true;
        } else {
            return false;
        }
        
    }

}
