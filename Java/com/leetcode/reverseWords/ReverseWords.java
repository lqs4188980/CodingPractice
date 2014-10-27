package com.leetcode.reverseWords;

public class ReverseWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWords instance = new ReverseWords();
		instance.reverseWords("the sky is blue");
	}
	
	
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        StringBuilder from = new StringBuilder(s);
        StringBuilder to = new StringBuilder();
        
        boolean word = false;
        int length = s.length();
        int end = length - 1;
        
        for (int i = length - 1; i >= 0; i--) {
            char c = from.charAt(i);
            if (c == ' ') {
                if (!word) {
                    continue;
                } else {
                    copyWords(from, to, i + 1, end);
                    word = false;
                    continue;
                }
            } else {
                if (!word) {
                    end = i;
                    word = true;
                    continue;
                } else {
                    continue;
                }
            }
        }
        
        if (word) {
            copyWords(from, to, 0, end);
        }
        if (to.length() != 0) {
            return to.substring(1);
        } else {
            return "";
        }
        
    }
    
    private void copyWords(StringBuilder from, StringBuilder to, int start, int end) {
        to.append(' ');
        for (int i = start; i <= end; i++) {
            to.append(from.charAt(i));
        }
    }
}
