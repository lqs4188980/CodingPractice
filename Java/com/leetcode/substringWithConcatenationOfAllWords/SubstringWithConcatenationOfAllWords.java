package com.leetcode.substringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {

	
	public List<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if (S == null || S.length() == 0 || L == null || L.length == 0) {
            return (List)result;
        }
        
        HashMap<String, Integer> wordDict = new HashMap<String, Integer>();
        HashSet<Character> initialSet = new HashSet<Character>();
        
        for (String s : L) {
            if (wordDict.containsKey(s)) {
                wordDict.put(s, wordDict.get(s) + 1);
            } else {
                wordDict.put(s, 1);
                initialSet.add(s.charAt(0));
            }
        }
        
        int wordLen = L[0].length();
        int range = wordLen * L.length;
        
        HashMap<String, Integer> found = new HashMap<String, Integer>();
        int count = 0;
        for (int i = 0; i < S.length() - range + 1; ++i) {
            if (initialSet.contains(S.charAt(i))) {
                found.clear();
                count = 0;
                for (int j = 0; j < range;) {
                    String s = S.substring(i + j, i + (j += wordLen));
                    if (wordDict.containsKey(s)) {
                        if (found.containsKey(s)) {
                            found.put(s, found.get(s) + 1);
                        } else {
                            found.put(s, 1);
                        }
                    } else {
                        break;
                    }
                    
                    if (wordDict.get(s) >= found.get(s)) {
                        ++count;
                    } else {
                        break;
                    }
                }
                
                if (count == L.length) {
                    result.add(i);
                }
            }
        }
        
        return (List)result;
    }

}
