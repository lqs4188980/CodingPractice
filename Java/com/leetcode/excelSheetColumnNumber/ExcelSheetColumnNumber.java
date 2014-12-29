package com.leetcode.excelSheetColumnNumber;

public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        char[] names = s.toCharArray();
        
        int i = names.length - 1;
        long multiplier = 1;
        long columns = 0;
        while (i >= 0) {
            columns += (names[i--] - 64) * multiplier;
            multiplier *= 26;
        }
        
        return (int)columns;
    }
}
