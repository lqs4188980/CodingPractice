package com.leetcode.integerToRoman;

public class IntegerToRoman {
	public String intToRoman(int num) {
        int[] threshold = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        int count = 0;
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < threshold.length; ++i) {
            count = num / threshold[i];
            for (int j = 0; j < count; ++j) {
                b.append(symbols[i]);
            }
            
            num %= threshold[i];
        }
        
        return b.toString();
    }
}
