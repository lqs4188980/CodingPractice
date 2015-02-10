package com.leetcode.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (num == null || num.length == 0) {
            return (List)result;
        }
        
        HashSet<String> signatures = new HashSet<String>();
        Arrays.sort(num);
        int j = 0, k = 0, target = 0;
        for (int i = 0; i < num.length; ++i) {
            j = i + 1;
            k = num.length - 1;
            target = 0 - num[i];
            while (j < k) {
                int temp = num[j] + num[k];
                if (temp == target) {
                    ArrayList<Integer> triple = new ArrayList<Integer>();
                    triple.add(num[i]);
                    triple.add(num[j]);
                    triple.add(num[k]);
                    if (checkDup(signatures, triple)) {
                        result.add(triple);
                    }
                    
                    ++j;
                    --k;
                } else if (temp > target){
                    --k;
                } else {
                    ++j;
                }
            }
        }
        
        return (List)result;
        
    }
    
    
    
    private boolean checkDup(HashSet<String> signatures, ArrayList<Integer> triplets) {
        
        StringBuilder b = new StringBuilder();
        for (int i : triplets) {
            b.append(i);
        }
        
        String sig = b.toString();
        
        if (signatures.contains(sig)) {
            return false;
        } else {
            signatures.add(sig);
            return true;
        }
    }
}
