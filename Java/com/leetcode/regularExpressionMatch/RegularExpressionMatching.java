package com.leetcode.regularExpressionMatch;

public class RegularExpressionMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isMatch("aab", "c*a*b"));
	}
	
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        
        int sLength = s.length(),
            pLength = p.length(),
            i = 0,
            j = 0,
            startPosition = -1;
        
        boolean startMatch = false;
        
        while (j < pLength) {
        	System.out.println("i: " + i + ", j: " + j);
            char pChar = p.charAt(j);
            if (!startMatch) {
                if (i < sLength) {
                    char sChar = s.charAt(i);
                    if (sChar == pChar || pChar == '.' || pChar == '*') {
                        startMatch = true;
                        startPosition = i;
                        i++;
                        j++;
                        
                        if (pChar == '*' && j < pLength) {
                            pChar = p.charAt(j);
                            if (pChar != '.' && pChar != '*') {
                                while (i < sLength && s.charAt(i) != pChar) {
                                    i++;
                                }
                            }
                        } else if (j == pLength) {
                            return true;
                        }
                        
                    } else {
                        i++;
                    }
                } else {
                    return false;
                }
            } else {
                if (i < sLength) {
                    char sChar = s.charAt(i);
                    if (sChar == pChar || pChar == '.' || pChar == '*') {
                        i++;
                        j++;
                        if (pChar == '*' && j < pLength) {
                            pChar = p.charAt(j);
                            if (pChar != '.' && pChar != '*') {
                                while (i < sLength && s.charAt(i) != pChar) {
                                    i++;
                                }
                            }
                        } else if (pChar == '*' && j == pLength) {
                            return true;
                        }
                    } else {
                        i = startPosition + 1;
                        j = 0;
                        startMatch = false;
                    }
                } else {
                	break;
                }
            }
        }
        
        if (j == pLength && i == sLength) {
            return true;
        } else {
            return false;
        }
        
        
        
        
    }

}
