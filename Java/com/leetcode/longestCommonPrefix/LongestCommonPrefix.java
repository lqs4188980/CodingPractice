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
    
    public String longestCommonPrefix_edited(String[] strs) {
        if (strs == null || strs.length == 0 || strs[0] == null || strs[0].length() == 0) {
            return "";
        }
        
        char c = ' ';
        for (int i = 0; i < strs[0].length(); ++i) {
            c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; ++j) {
                if (strs[j] == null || strs[j].length() == 0) {
                    return "";
                }
                
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        
        return strs[0];
    }
}
