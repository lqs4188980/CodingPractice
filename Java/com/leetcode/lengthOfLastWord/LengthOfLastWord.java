package com.leetcode.lengthOfLastWord;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        
        int count = 0;
        int length = s.length();
        
        for (int i = length - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && count != 0) {
                return count;
            } else if (s.charAt(i) != ' '){
                count++;
            }
        }
        return count;
    }
}
