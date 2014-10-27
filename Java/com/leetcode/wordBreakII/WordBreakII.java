package com.leetcode.wordBreakII;

import java.util.ArrayList;
import java.util.Set;

public class WordBreakII {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        if (s == null || dict == null) {
            return new ArrayList<String>();
        }
        StringBuilder sBuilder = new StringBuilder(s);
        int length = sBuilder.length();
        boolean starts[] = new boolean[length + 1];
        starts[0] = true;
        
        // Justify whether s can be constructed from dict using the method of Word Break I
        for(int i = 1; i <= length; i++){
            if(dict.contains(sBuilder.substring(0, i))){
                starts[i] = true;
                continue;
            }
            for(int j = 0; j < i; j++){
                if(starts[j] && dict.contains(sBuilder.substring(j, i))){
                    starts[i] = true;
                }
            }
        }
        // If it cannot be constructed, return empty list
        if(starts[length] == false)
            return new ArrayList<String>();
        
        ArrayList<String> result = search(sBuilder, 0, dict);
        
        return result;
    }
    
    // BSF. This part can be optimized using the DP table.
    // The return value of each level is composed by appending each returned word to current word
    private ArrayList<String> search(StringBuilder s, int start, Set<String> dict){
        int length = s.length();
        ArrayList<String> rv = new ArrayList<String>();
        for(int i = start; i <= length; i++){
            if(dict.contains(s.substring(start, i))){
                String word = s.substring(start, i);
                if(i != length){
                    ArrayList<String> sub = search(s, i, dict);
                    for(String string : sub){
                        StringBuilder temp = new StringBuilder(word);
                        temp.append(' ');
                        temp.append(string);
                        rv.add(temp.toString());
                    }
                }
                else{
                    rv.add(word);
                }
            }
        }
        return rv;
    }
}
