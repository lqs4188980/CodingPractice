package com.leetcode.permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] num) {
        LinkedList<ArrayList<Integer>> solutions = new LinkedList<ArrayList<Integer>>();
        if (num == null || num.length == 0) {
            return (List)solutions;
        }
        
        ArrayList<Integer> solution = new ArrayList<Integer>();
        solution.add(num[0]);
        solutions.add(solution);
        for (int i = 1; i < num.length; i++) {
            int size = solutions.size();
            for (int j = 0; j < size; j++) {
                ArrayList<Integer> list = solutions.poll();
                int length = list.size();
                for (int k = 0; k <= length; k++) {
                    ArrayList<Integer> cloned = (ArrayList<Integer>)list.clone();
                    cloned.add(k, num[i]);
                    solutions.add(cloned);
                }
            }
        }
        
        return (List)solutions;
    }
}
