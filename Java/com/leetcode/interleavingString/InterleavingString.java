package com.leetcode.interleavingString;

public class InterleavingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s1 == "") {
            if (s2 != null) {
                if (s2.equals(s3)) {
                    return true;
                }
                return false;
            }
            else if (s3 != null) {
                return false;
            }
            else {
                return true;
            }
        }
        
        if (s2 == null || s2 == "") {
            if (s1 != null) {
                if (s1.equals(s3)) {
                    return true;
                }
                return false;
            }
            else if (s3 != null) {
                return false;
            }
            else {
                return true;
            }
        }
        
        if (s3.length() != (s1.length() + s2.length())) {
            return false;
        }
        
        StringBuilder b1 = new StringBuilder(s1);
        StringBuilder b2 = new StringBuilder(s2);
        StringBuilder b3 = new StringBuilder(s3);
        
        int l1 = b1.length();
        int l2 = b2.length();
        int l3 = b3.length();
        
        for (int p1 = 0, p2 = 0, p3 = 0; (p1 < l1 || p2 < l2) && p3 < l3; p3++) {
            if (p1 < l1 && b3.charAt(p3) == b1.charAt(p1)) {
                p1++;
                continue;
            }
            if (p2 < l2 && b3.charAt(p3) == b2.charAt(p2)) {
                p2++;
                continue;
            }
            return false;
        }
        
        return true;
        
    }

}
