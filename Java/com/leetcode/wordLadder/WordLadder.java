package com.leetcode.wordLadder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLadder instance = new WordLadder();
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		System.out.println(instance.ladderLength("hot", "cog", dict));
	}
	
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || (!start.equals(end) && (dict == null || dict.size() == 0))) {
            return 0;
        }
        
        if (start.equals(end)) {
            return 1;
        }
        
        int step = 0,
            qLen = 0,
            wLen = start.length();
        
        LinkedList<String> queue = new LinkedList<String>();
        queue.add(start);
        queue.add("");
        qLen += 2;
        
        
        while (qLen != 0) {
            String curr = queue.poll();
            --qLen;
            if (!curr.equals("")) {
                
                if (dict.size() > 0) {
                    
                    for (int i = 0; i < wLen; i++) {
                        char[] word = curr.toCharArray();
                        for (char c = 'a'; c <= 'z'; c++) {
                            word[i] = c;
                            String branch = new String(word);
                            if (branch.equals(end)) {
                                if (dict.contains(end)) {
                                    return step + 2;
                                }
                                else {
                                    return step + 1;
                                    
                                }
                                
                            }
                            if (dict.contains(branch)) {
                                queue.add(branch);
                                ++qLen;
                                dict.remove(branch);
                            }
                        }
                    }
                } 
                
            } else if (qLen > 0){
                ++step;
                queue.add("");
                ++qLen;
            }
        }
        
        return 0;
        
    }

}
