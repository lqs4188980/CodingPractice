package com.leetcode.validParentheses;

import java.util.HashMap;
import java.util.LinkedList;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("([])"));
	}
	
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        LinkedList<Character> stack = new LinkedList<Character>();
        HashMap<Character, Character> table = new HashMap<Character, Character>();
        table.put(')', '(');
        table.put(']', '[');
        table.put('}', '{');
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if ((stack.size() != 0 && stack.peekFirst() != table.get(c)) || stack.size() == 0) {
                	System.out.println(stack.size());
                	System.out.println(stack.peekLast());
                	System.out.println(stack);
                	System.out.println(table.get(c));
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

}
