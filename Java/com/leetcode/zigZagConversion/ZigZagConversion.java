package com.leetcode.zigZagConversion;

public class ZigZagConversion {
	public String convert(String s, int nRows) {
        if (s == null || s.length() == 0 || nRows == 0) {
            return "";
        }
        
        StringBuilder[] rows = new StringBuilder[nRows];
        
        for (int i = 0; i < rows.length; ++i) {
            rows[i] = new StringBuilder();
        }
        
        int index = 0;
        boolean isIncrease = true;
        for (int i = 0; i < s.length(); ++i) {
            rows[index].append(s.charAt(i));
            if (isIncrease) {
                if (++index == nRows) {
                    index = Math.max(0, index - 2);
                    if (index > 0) {
                        isIncrease = false;
                    }
                }
            } else {
                if (--index < 0) {
                    isIncrease = true;
                    index = 1 < nRows ? 1 : 0;
                }
            }
        }
        
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < rows.length; ++i) {
            temp.append(rows[i].toString());
        }
        
        return temp.toString();
    }
}
