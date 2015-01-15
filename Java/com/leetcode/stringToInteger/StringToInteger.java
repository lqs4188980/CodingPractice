package com.leetcode.stringToInteger;

public class StringToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringToInteger instance = new StringToInteger();
		System.out.println(instance.atoi("+-2"));
	}
	
	public int atoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        int start = -1;
        int index = 0;
        char c = ' ';
        boolean hasSign = false;
        while (index < str.length()) {
            c = str.charAt(index);
            if (c <= '9' && c >= '0') {
                if (!hasSign) {
                    start = index;
                }
                break;
            }
            
            else if (c == '+' || c == '-') {
                if (hasSign) {
                    return 0;
                } else {
                    hasSign = true;
                    start = index;
                }
            }
            
            else if (c != ' ') {
                return 0;
            }
            
            ++index;
        }
        
        if (start == -1) {
            return 0;
        }
        
        int end;
        c = ' ';
        for (end = start + 1; end < str.length(); ++end) {
            c = str.charAt(end);
            if (c < '0' || c > '9') {
                break;
            }
        }
        
        if (hasSign && end - start < 2) {
            return 0;
        }
        
        return parseInt(str.substring(start, end));
    }
    
    private int parseInt(String s) {
        int sign = 1;
        int index = 0;
        char first = s.charAt(0);
        
        if (first == '-' || first == '+') {
            sign = first == '-' ? -1 : 1;
            ++index;
        }
        
        long raw = 0;
        while (index < s.length()) {
            raw = raw * 10 + s.charAt(index) - '0';
            if (sign == 1 && raw >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            
            if (sign == -1 && raw > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }
            
            ++index;
        }
        
        
        
        return (int)(raw * sign);
    }

}
