package com.leetcode.palindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        ArrayList<ArrayList<String>> partitions = new ArrayList<ArrayList<String>>();
        if (s == null) {
            return (List)partitions;
        }
        
        if (s == "") {
            ArrayList<String> partition = new ArrayList<String>();
            partition.add(s);
            partitions.add(partition);
            return (List)partitions;
        }
        getPartitions(new StringBuilder(s), 0, partitions, new ArrayList<String>());
        
        return (List)partitions;
    }
    
    private void getPartitions(StringBuilder s, int start, ArrayList<ArrayList<String>> partitions, ArrayList<String> partition) {
        if (start == s.length()) {
            partitions.add(partition);
            return;
        }
        
        for (int i = start + 1; i <= s.length(); i++) {
            if (isPalindrome(s.substring(start, i))) {
                ArrayList<String> clonePt = (ArrayList<String>)partition.clone();
                clonePt.add(s.substring(start, i));
                getPartitions(s, i, partitions, clonePt);
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return true;
        }
        
        int head = 0,
            tail = s.length() - 1;
        
        while (head <= tail) {
            if (s.charAt(head) != s.charAt(tail)) {
                return false;
            } else {
                head++;
                tail--;
            }
        }
        
        return true;
    }
}
