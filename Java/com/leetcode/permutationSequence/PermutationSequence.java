package com.leetcode.permutationSequence;

public class PermutationSequence {
	public String getPermutation(int n, int k) {
        if (k <= 0) {
            return "";
        }
        
        int facto = 1;
        for (int i = n; i > 0; i--) {
            facto *= i;
        }
        
        if (k > facto) {
            return "";
        }
        
        int[] checker = new int[n + 1];
        for (int i = 1; i < checker.length; i++) {
            checker[i] = 0;
        }
        
        int groupNum = 0;
        StringBuilder builder = new StringBuilder();
        while (n > 1) {
            groupNum = (int)Math.ceil((double)k / (facto / n));
            for (int i = 1, j = groupNum - 1; i < checker.length; i++) {
                if (checker[i] == 0 && j == 0) {
                    builder.append(i);
                    checker[i] = 1;
                    break;
                } else if (checker[i] == 0 && j > 0){
                    j--;
                }
            }
            
            if (k % (facto / n) == 0) {
                k = facto / n;
            } else {
                k %= (facto / n);
            }
            
            facto /= n;
            n--;
            
        }
        
        for (int i = 1; i < checker.length; i++) {
            if (checker[i] == 0) {
                builder.append(i);
                break;
            }
        }
        
        return builder.toString();
    }
}
