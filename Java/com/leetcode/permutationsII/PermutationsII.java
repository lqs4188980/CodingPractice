package com.leetcode.permutationsII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] num) {
        LinkedList<ArrayList<Integer>> solutions = new LinkedList<ArrayList<Integer>>();
        if (num == null || num.length == 0) {
            return (List)solutions;
        }
        
        ArrayList<Integer> solution = new ArrayList<Integer>();
        solution.add(num[0]);
        solutions.add(solution);
        HashSet<String> table = new HashSet<String>();
        for (int i = 1; i < num.length; i++) {
            int size = solutions.size();
            for (int j = 0; j < size; j++) {
                ArrayList<Integer> list = solutions.poll();
                int length = list.size();
                for (int k = 0; k <= length; k++) {
                    ArrayList<Integer> cloned = (ArrayList<Integer>)list.clone();
                    cloned.add(k, num[i]);
                    if (checkUnique(cloned, table)) {
                        solutions.add(cloned);
                    }
                }
            }
        }
        
        return (List)solutions;
    }
    
    private boolean checkUnique(ArrayList<Integer> list, HashSet<String> table) {
        StringBuilder builder = new StringBuilder();
        for (int i : list) {
            builder.append(i);
        }
        String sig = builder.toString();
        if (table.contains(sig)) {
            return false;
        } else {
            table.add(sig);
            return true;
        }
    }
}
