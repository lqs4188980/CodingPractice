package com.leetcode.combinations;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> comb = new ArrayList<ArrayList<Integer>>();
        if (n < k) {
            return (List)comb;
        }
        
        getCombination(1, n, k, new ArrayList<Integer>(), comb);
        return (List)comb;
    }
    
    private void getCombination(int start, int n, int k, ArrayList<Integer> comb, ArrayList<ArrayList<Integer>> combSet) {
        if (comb.size() == k) {
            combSet.add(comb);
            return;
        }
        
        
        for (int i = start; i <= n; i++) {
            ArrayList<Integer> updateComb = new ArrayList<Integer>();
            updateComb.addAll(comb);
            updateComb.add(i);
            getCombination(i + 1, n, k, updateComb, combSet);
        }
    }
}
