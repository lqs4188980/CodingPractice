package com.leetcode.longestValidParentheses;

import java.util.Stack;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (!stack.empty() && s.charAt(stack.peek()) == '(') {
                stack.pop();
                max = Math.max(max, i - (stack.empty() ? -1 : stack.peek()));
            } else {
                stack.push(i);
            }
        }
        
        return max;
    }
}
