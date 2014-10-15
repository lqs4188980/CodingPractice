package com.leetcode.permutationUnique;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PermutationUnique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {-1,-1,3,-1};
		Iterator<List<Integer>> it1 = permuteUnique(num).iterator();
		while (it1.hasNext()) {
			List<Integer> l = it1.next();
			for (Integer i : l) {
				System.out.print(i + " ");
			}
			System.out.print('\n');
		}
	}
	
    public static List<List<Integer>> permuteUnique(int[] num) {
        LinkedList<ArrayList<Integer>> solutions = new LinkedList<ArrayList<Integer>>();
        if (num == null || num.length == 0) {
            return (List)solutions;
        }
        
        ArrayList<Integer> solution = new ArrayList<Integer>();
        solution.add(num[0]);
        solutions.add(solution);
        for (int i = 0; i < num.length; i++) {
            int size = solutions.size();
            for (int j = 0; j < size; j++) {
                ArrayList<Integer> list = solutions.poll();
                int length = list.size();
                for (int k = 0; k <= length; k++) {
                    if ((k < length && list.get(k) != num[i]) || k == length) {
                        ArrayList<Integer> cloned = (ArrayList<Integer>)list.clone();
                        cloned.add(k, num[i]);
                        solutions.add(cloned);
                    } 
                }
            }
        }
        
        return (List)solutions;
    }

}
