package com.leetcode.longestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "qopubjguxhxdipfzwswybgfylqvjzhar";
		lengthOfLongestSubstring(s);
	}
	
	public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLength = 0;
        int counter = 0;
        int sLength = s.length();
        for (int i = 0; i < sLength; i++) {
            char current = s.charAt(i);
            if (!map.containsKey(current)) {
            	System.out.print(current);
                map.put(current, i);
                counter++;
            } else {
            	System.out.print('\n');
                if (counter > maxLength) {
                    maxLength = counter;
                }
                counter = 0;
                i = map.get(current);
                map.clear();
            }
        }
        return maxLength;
    }

}
