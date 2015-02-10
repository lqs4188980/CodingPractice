package com.leetcode.letterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
	public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        
        if (digits == null) {
            return (List)result;
        }
        
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        search(digits, 0, "", mapping, result);
        
        return (List)result;
    }
    
    private void search(String digits, int current, String s, String[] mapping, ArrayList<String> result) {
        if (current == digits.length()) {
            result.add(s);
            return;
        } 
        
        int index = digits.charAt(current) - '0';
        char c = ' ';
        for (int i = 0; i < mapping[index].length(); ++i) {
            c = mapping[index].charAt(i);
            search(digits, current + 1, s + c, mapping, result);
        }
    }
    
    /*
     public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        result.add("");
        if (digits == null || digits.length() == 0) {
            return (List)result;
        }
        
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        
        int value = -1;
        char c = ' ';
        for (int i = 0; i < digits.length(); ++i) {
            ArrayList<String> cache = new ArrayList<String>();
            value = digits.charAt(i) - '0';
            for (int j = 0; j < mapping[value].length(); ++j) {
                c = mapping[value].charAt(j);
                for (String s : result) {
                    StringBuilder b = new StringBuilder(s);
                    b.append(c);
                    cache.add(b.toString());
                }
            }
            
            result.clear();
            result.addAll(cache);
        }
        
        return (List)result;
    }
     */
}
