package com.leetcode.addBinary;

public class AddBinary {
	public String addBinary(String a, String b) {
        if (a == null || b == null) {
            if (a != null) {
                return a;
            } else if (b != null) {
                return b;
            } else {
                return "";
            }
        }
        
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        
        int lengthA = a.length(),
            lengthB = b.length();
            
        int carry = 0;
        
        int ptA = lengthA - 1,
            ptB = lengthB - 1;
        
        StringBuilder builder = new StringBuilder();
        
        for (; ptA >= 0;) {
            if (ptB >= 0) {
                int value = (a.charAt(ptA) - 48) + (b.charAt(ptB) - 48) + carry;
                carry = 0;
                if (value > 1) {
                    carry = 1;
                    builder.append(value - 2);
                } else {
                    builder.append(value);
                }
                
                ptA--;
                ptB--;
                
            } else {
                int value = (a.charAt(ptA) - 48) + carry;
                carry = 0;
                if (value > 1) {
                    carry = 1;
                    builder.append(value - 2);
                } else {
                    builder.append(value);
                }
                
                ptA--;
            }
        }
        if (carry == 1) {
            builder.append(carry);
        }
        
        return builder.reverse().toString();
    }
}
