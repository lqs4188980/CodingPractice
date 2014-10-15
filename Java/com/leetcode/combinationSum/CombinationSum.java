package com.leetcode.combinationSum;

import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {7, 4, 5};
		System.out.println(combinationSum(candidates, 9).size());
	}
	
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<LinkedList<Integer>> solutions = new LinkedList<LinkedList<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return (List)solutions;
        }
        
        candidates = mergeSort(candidates, 0, candidates.length);
        deepSearch(candidates, target, new LinkedList<Integer>(), solutions, 0, 0);
        return (List)solutions;
    }
    
    private static void deepSearch(int[] candidates, int target, LinkedList<Integer> solution, LinkedList<LinkedList<Integer>> solutions, int sum, int index) {
        if (sum == target) {
            solutions.add(solution);
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] <= target) {
                LinkedList<Integer> cloned = (LinkedList<Integer>)solutions.clone();
                cloned.add(candidates[i]);
                deepSearch(candidates, target, cloned, solutions, sum + candidates[i], i);
            } else {
                return;
            }
        }
    }
    
    private static int[] mergeSort(int[] input, int start, int length) {
        if (length == 1) {
            int[] rv = new int[1];
            rv[0] = input[start];
            return rv;
        }
        
        int halfSize = length / 2;
        return merge(mergeSort(input, start, halfSize), mergeSort(input, start + halfSize, length - halfSize));
    }
    
    private static int[] merge(int[] a, int[] b) {
        int i = 0,
            j = 0,
            k = 0;
        int[] rv = new int[a.length + b.length];
        while (i < a.length || j < b.length) {
            if (i < a.length && j < b.length) {
                if (a[i] < b[j]) {
                    rv[k] = a[i];
                    i++;
                } else {
                    rv[k] = b[j];
                    j++;
                }
            } else if (i == a.length && j < b.length){
                rv[k] = b[j];
                j++;
            } else if (i < a.length && j == b.length) {
                rv[k] = a[i];
                i++;
            }
            k++;
        }
        
        return rv;
    }

}
