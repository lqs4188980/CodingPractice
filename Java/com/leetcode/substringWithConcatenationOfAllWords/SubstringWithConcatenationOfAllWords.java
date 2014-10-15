package com.leetcode.substringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] L = {"fooo","barr","wing","ding","wing"};
		List<Integer> list = findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", L);
		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.print('\n');
	}
	
    public static List<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> solutions = new ArrayList<Integer>();
        if (S == null || L == null || L.length == 0) {
            return (List)solutions;
        }
        
        HashMap<String, Integer> table = new HashMap<String, Integer>();
        
        for (String s : L) {
            if (!table.containsKey(s)) {
                table.put(s, 1);
            } else {
                table.put(s, table.get(s) + 1);
            }
        }
        
        StringBuilder builder = new StringBuilder(S);
        
        int length = builder.length();
        int wordLength = L[0].length();
        
        int i = 0;
        
        while (i + wordLength < length) {
            HashMap<String, Integer> cloneMap = (HashMap<String, Integer>)table.clone();
            int start = i;
            while (!cloneMap.isEmpty() && i + wordLength < length) {
                String sub = builder.substring(i, i + wordLength);
                if (cloneMap.containsKey(sub)) {
                    int value = cloneMap.get(sub);
                    
                    if (value == 1) {
                        cloneMap.remove(sub);
                    } else {
                        cloneMap.put(sub, value - 1);
                    }
                    
                    i = i + wordLength;
                } else {
                    break;
                }
            }
            
            if (cloneMap.isEmpty()) {
                solutions.add(start);
            }
            i = start + 1;
        }
        
        return (List)solutions;
    }

}
