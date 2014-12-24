package com.leetcode.excelSheetColumnTitle;

import java.util.Stack;

public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
        if (n < 1) {
            return "";
        }
        
        Stack<Integer> name = new Stack<Integer>();
        
        int division = n;
        while (division != 0) {
            
            name.push(--division % 26);
            division /= 26;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!name.empty()) {
            int v = name.pop();
            sb.append((char)('A' + v));
        }
        
        return sb.toString();
        
    }
}
