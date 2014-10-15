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
        System.out.println("Add " + start);
        queue.add("");
        System.out.println("Add \"\"");
        qLen += 2;
        
        
        while (qLen != 0) {
            String curr = queue.poll();
            System.out.println("Current word is " + curr);
            --qLen;
            System.out.println("The queue length is " + qLen);
            if (!curr.equals("")) {
                if (curr.equals(end)) {
                    return step + 1;
                }
                
                if (dict.size() > 0) {
                	System.out.println("Dict size is not zero");
                    
                    for (int i = 0; i < wLen; i++) {
                    	char[] word = curr.toCharArray();
                        for (char c = 'a'; c <= 'z'; c++) {
                            word[i] = c;
                            String branch = new String(word);
                            
                            if (dict.contains(branch)) {
                                queue.add(branch);
                                System.out.println("Add " + branch);
                                ++qLen;
                                dict.remove(branch);
                            }
                        }
                    }
                } 
                
            } else if (qLen > 0){
                ++step;
                queue.add("");
                System.out.println("Add \"\"");
                ++qLen;
                System.out.println("The queue length is " + qLen);
            }
        }
        
        return 0;
        
    }

}
