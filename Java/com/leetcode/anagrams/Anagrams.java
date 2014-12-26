package com.leetcode.anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Anagrams {
	public List<String> anagrams(String[] strs) {
        ArrayList<String> solutions = new ArrayList<String>();
        if (strs == null || strs.length == 0) {
            return (List)solutions;
        }
        
        HashMap<String, ArrayList<String>> dict = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] buff = strs[i].toCharArray();
            Arrays.sort(buff);
            String sig = new String(buff);
            if (dict.containsKey(sig)) {
                dict.get(sig).add(strs[i]);
            } else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(strs[i]);
                dict.put(sig, list);
            }
        }
        
        Iterator<ArrayList<String>> iter = dict.values().iterator();
        while (iter.hasNext()) {
            ArrayList<String> temp = (ArrayList<String>)iter.next();
            if (temp.size() > 1) {
                solutions.addAll(temp);
            }
        }
        
        return (List)solutions;
    }
}
