package com.leetcode.wordBreak;

import java.util.Set;


/*
 * This is a solution that utilizes DP. 
 * s[i] is true means for string s, substring(0, i) is in the dict or a composition of words from dict 
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null)
            return false;
        if(dict.contains(s))
            return true;
        StringBuilder string = new StringBuilder(s);
        int length = string.length();
        boolean table[] = new boolean[length + 1];
        for(int i = 0; i <= length; i++){
            table[i] = false;
        }
        table[0] = true;
        for(int i = 1; i <= length; i++){
            if(dict.contains(string.substring(0, i))){
                table[i] = true;
                continue;
            }
            for(int j = 0; j < i; j++){
                if(table[j] && dict.contains(string.substring(j, i))){
                    table[i] = true;
                }
            }
        }
        return table[length];
    }
}
