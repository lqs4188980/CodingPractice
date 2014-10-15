package com.leetcode.scrambleString;

import java.util.Arrays;

public class ScrambleString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScrambleString instance = new ScrambleString();
		System.out.println(instance.isScramble("ab", "ba"));
	}
	
    public boolean isScramble(String s1, String s2) {
    	System.out.println("s1: " + s1 + ", s2: " + s2);
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
        	System.out.println("#1");
            return false;
        }
        
        if (s1.equals(s2)) {
        	System.out.println("#2");
            return true;
        }
        
        char[] s1Chars = s1.toCharArray();
        Arrays.sort(s1Chars);
        String sig1 = new String(s1Chars);
        
        char[] s2Chars = s2.toCharArray();
        Arrays.sort(s2Chars);
        String sig2 = new String(s2Chars);
        
        if (!sig1.equals(sig2)) {
        	System.out.println("#3");
            return false;
        }
        int len = s1.length();
        for (int i = 1; i < len; i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            if ((isScramble(s11, s2.substring(0, i)) && isScramble(s12, s2.substring(i))) 
            || (isScramble(s11, s2.substring(len - i)) && isScramble(s12, s2.substring(0, len - i)))) {
            	System.out.println("#4");
                return true;
            } 
        }
        System.out.println("#5");
        return false;
    }

}
