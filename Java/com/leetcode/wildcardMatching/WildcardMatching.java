package com.leetcode.wildcardMatching;

public class WildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WildcardMatching instance = new WildcardMatching();
		System.out.println(instance.isMatch("aa", "*"));
	}
	
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        
        int Slength = s.length(),
            Plength = p.length();
        
        int p1 = 0,
            p2 = 0;
        while (p1 < Slength && p2 < Plength) {
            char token = p.charAt(p2);
            if (token == '*') {
            	++p2;
                while (p2 < Plength && (token = p.charAt(p2)) == '*') {
                    ++p2;
                }
                
                // Exit condition: token != '*' or p2 == Plength
                // Plength - 1 is '*'
                if (p2 == Plength) {
                    return true;
                }
                
                if (token == '?') {
                	// Last char
                    if (p2 == Plength - 1 && p1 >= 0) {
                    	return true;
                    }
                    
                    token = p.charAt(++p2);
                    ++p1;
                    if (token == '*' || token == '?') {
                    	continue;
                    } else {
						while (p1 < Slength && s.charAt(p1) != token) {
							++p1;
						}
						if (p1 == Slength) {
							return false;
						} else {
							++p1;
							++p2;
							continue;
						}
					}
                    
                }
                
                while (p1 < Slength && s.charAt(p1) != token) {
                    ++p1;
                }
                
                if (p1 == Slength) {
                    return false;
                } else {
                    ++p1;
                    ++p2;
                    continue;
                }
            }
            
            
            // p2 < Plength: '?' or some other chars
            if (token == '?') {
                // match every char, but must be a char
                ++p1;
                ++p2;
                continue;
            }
            
            // Normal char pattern
            if (s.charAt(p1) != token) {
                return false;
            } else {
                ++p1;
                ++p2;
                continue;
            }
            
        }
        if ((p1 == Slength && p2 == Plength - 1 && p.charAt(p2) == '*') || p1 == Slength && p2 == Plength) {
            return true;
        } else {
            return false;
        }
    }

}
