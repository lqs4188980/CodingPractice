package com.leetcode.generateParentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        
        if (n == 0) {
            result.add("");
            return (List)result;
        }
        
        getSolutions(n, 0, 0, "", result);
        
        return (List)result;
    }
    
    private void getSolutions(int n, int left, int right, String s, ArrayList<String> result) {
        if (left + right == n * 2) {
            result.add(s);
            return;
        }
        
        if (left < n) {
            StringBuilder b = new StringBuilder(s);
            b.append('(');
            getSolutions(n, left + 1, right, b.toString(), result);
        }
        
        if (left > right) {
            StringBuilder b = new StringBuilder(s);
            b.append(')');
            getSolutions(n, left, right + 1, b.toString(), result);
        }
    }
}
