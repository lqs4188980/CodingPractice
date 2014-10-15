package com.leetcode.romanToInteger;

import java.util.HashMap;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInt("D"));
	}
	
    public static int romanToInt(String s) {
        if (s == null || s.length() == 1) {
            return 0;
        }
        
        int sum = 0,
            base = 0,
            length = s.length(),
            i = length - 1;
            
        HashMap<Character, Integer> table = new HashMap<Character, Integer>();
        table.put('I', 1);
        table.put('V', 5);
        table.put('X', 10);
        table.put('L', 50);
        table.put('C', 100);
        table.put('D', 500);
        table.put('M', 1000);
            
        while (i >= 0) {
        	System.out.println(i);
            char token = s.charAt(i);
            
            base = table.get(token);
            System.out.println(base);
            
            int j = i - 1;
            while (j >= 0) {
                char prev = s.charAt(j);
                int value = table.get(prev);
                if (value < base) {
                    base -= value;
                    j--;
                } else {
                    break;
                }
            }
            
            i = j;
            sum += base;
            
        }
        
        return sum;
    }

}
