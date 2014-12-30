package com.leetcode.combinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

public class CombinationSum2 {

	
	public List<List<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) {
            return (List)solutions;
        }
        
        Arrays.sort(num);
        search(num, target, new ArrayList<Integer>(), solutions, 0, 0, new HashSet<String>());
        
        return (List)solutions;
    }
    
    private void search(int[] num, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> solutions, int sum, int start, HashSet<String> sigSet) {
        if (sum == target) {
            if (dupChecker(sigSet, path)) {
                solutions.add(path);
            }
            
            return;
        }
        
        for (int i = start; i < num.length; ++i) {
            if (sum + num[i] <= target) {
                ArrayList<Integer> cloned = (ArrayList<Integer>)path.clone();
                cloned.add(num[i]);
                search(num, target, cloned, solutions, sum + num[i], i + 1, sigSet);
            } else {
                return;
            }
        }
        
        
    }
    
    private boolean dupChecker(HashSet<String> sigSet, ArrayList<Integer> path) {
        StringBuilder b = new StringBuilder();
        for (int i : path) {
            b.append(i);
        }
        
        String sig = b.toString();
        if (sigSet.contains(sig)) {
            return false;
        } else {
            sigSet.add(sig);
            return true;
        }
    }
}
