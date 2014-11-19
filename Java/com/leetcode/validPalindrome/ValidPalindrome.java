package com.leetcode.validPalindrome;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null){
            return false;
        }
        
        if (s.length() < 2){
            return true;
        }
        
        
        StringBuilder sBuilder = new StringBuilder(s);
        int length = sBuilder.length();
        
        for(int i = 0, j = length - 1; i <= j;){
            char c1 = sBuilder.charAt(i);
            char c2 = sBuilder.charAt(j);
            
            c1 = upperToLower(c1);
            c2 = upperToLower(c2);
            
            if (!isAlphanumeric(c1)){
                i++;
                continue;
            }
            if (!isAlphanumeric(c2)){
                j--;
                continue;
            }
            if (c1 != c2){
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
    
    public boolean isAlphanumeric(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
    
    public char upperToLower(char c){
        if (c >= 'A' && c <= 'Z'){
            return (char)(c + 32);
        }
        return c;
    }
}
