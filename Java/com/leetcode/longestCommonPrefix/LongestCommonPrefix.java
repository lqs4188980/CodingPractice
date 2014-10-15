package com.leetcode.longestCommonPrefix;

public class LongestCommonPrefix {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"c", "c"};
		System.out.println(longestCommonPrefix(strs));
	}
	
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } 
        
        if (strs.length == 1) {
            return strs[0];
        }
        
        
        
        StringBuilder builder = new StringBuilder();
        
        int i = 0,
            length = Integer.MAX_VALUE;
            
        for (String str : strs) {
            if (str.length() < length) {
                length = str.length();
            }
        }
        System.out.println(length);
        while (i < length) {
        	System.out.println(i);
        	int j = 0;
            char c = strs[j].charAt(i);
            j++;
            while (j < strs.length) {
                if (strs[j].charAt(i) != c) {
                    break;
                }
                j++;
            }
            if (j < strs.length) {
                break;
            }
            builder.append(c);
            i++;
            
        }
        
        return builder.toString();
    }
}
