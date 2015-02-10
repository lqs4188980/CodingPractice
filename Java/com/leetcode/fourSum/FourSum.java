package com.leetcode.fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (num == null || num.length < 4) {
            return (List)result;
        }
        
        Arrays.sort(num);
        HashSet<String> sigs = new HashSet<String>();
        
        int remain1 = 0,
            remain2 = 0, 
            k = 0,
            l = 0,
            value = 0;
        
        for (int i = 0; i < num.length; ++i) {
            remain1 = target - num[i];
            for (int j = i + 1; j < num.length; ++j) {
                remain2 = remain1 - num[j];
                k = j + 1;
                l = num.length - 1;
                while (k < l) {
                    value = num[k] + num[l];
                    if (value == remain2) {
                        ArrayList<Integer> qp = new ArrayList<Integer>();
                        qp.add(num[i]);
                        qp.add(num[j]);
                        qp.add(num[k]);
                        qp.add(num[l]);
                        if (checkDup(sigs, qp)) {
                            result.add(qp);
                        }
                        
                        ++k;
                        --l;
                    } else if (value < remain2) {
                        ++k;
                    } else {
                        --l;
                    }
                }
            }
        }
        
        return (List)result;
    }
    
    private boolean checkDup(HashSet<String> sigs, ArrayList<Integer> qp) {
        StringBuilder b = new StringBuilder();
        for (int i : qp) {
            b.append(i);
        }
        
        String sig = b.toString();
        
        if (sigs.contains(sig)) {
            return false;
        } else {
            sigs.add(sig);
            return true;
        }
    }
}
