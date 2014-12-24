package com.leetcode.stringToInteger;

public class StringToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringToInteger instance = new StringToInteger();
		System.out.println(instance.atoi("+-2"));
	}
	
	public int atoi(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        
        int i = 0;
        int length = str.length();
        while (i < length && str.charAt(i) == ' ') {
            ++i;
        }
        
        if (i < length) {
            String num = "";
            char sign = str.charAt(i);
            int start = i;
            if (sign == '-' || sign == '+') {
                ++i;
            }
            for (int j = i; j < length; ++j) {
                char c = str.charAt(j);
                if (c < '0' || c > '9') {
                    num = str.substring(start, j);
                    break;
                }
            }
            
            if (num == "") {
                num = str.substring(start, length);
            }
            
            return convert(num);
        } else {
            return 0;
        }
    }
    
    private int convert(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int sign = 1;
        int index = 0;
        char c = s.charAt(0);
        if (c == '-' || c == '+') {
            index++;
            if (c == '-') {
                sign = -1;
            }
        }
        
        
        long cache = 0;
        long multiplier = 1;
        for (int j = s.length() - 1; j >= index; --j) {
            cache += (s.charAt(j) - 48) * multiplier;
            if (cache * sign >= Integer.MAX_VALUE) {
            	return Integer.MAX_VALUE;
            } else if (cache * sign <= Integer.MIN_VALUE){
            	return Integer.MIN_VALUE;
            }
            multiplier *= 10;
        }
        
        cache *= sign;
        
        if (cache >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (cache <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int)cache;
        }
        
    }

}
