package com.leetcode.romanToInteger;

import java.util.HashMap;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class RomanToInteger {
	
	public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        HashMap<Character, Integer> table = new HashMap<Character, Integer>();
        
        table.put('I', 1);
        table.put('V', 5);
        table.put('X', 10);
        table.put('L', 50);
        table.put('C', 100);
        table.put('D', 500);
        table.put('M', 1000);
        
        int index = 0;
        int num = 0;
        while (index < s.length()) {
            int value = table.get(s.charAt(index));
            if (index + 1 < s.length() && table.get(s.charAt(index + 1)) > value) {
                num += table.get(s.charAt(++index)) - value;
            } else {
                num += value;
            }
            ++index;
        }
        
        return num;
    }

}
