package com.leetcode.longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

		
	public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        HashSet<Character> dict = new HashSet<Character>();
        
        int i = 0, j = 0;
        int max = -1;
        while (j < s.length()) {
            char c = s.charAt(j);
            if (dict.contains(c)) {
                max = Math.max(max, j - i);
                while (s.charAt(i) != c) {
                    dict.remove(s.charAt(i++));
                }
                dict.remove(s.charAt(i++));
            } else {
                dict.add(c);
                ++j;
            }
        }
        
        max = Math.max(max, j - i);
        
        return max;
    
    }

}
