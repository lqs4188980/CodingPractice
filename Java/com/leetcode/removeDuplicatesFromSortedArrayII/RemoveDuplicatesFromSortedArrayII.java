package com.leetcode.removeDuplicatesFromSortedArrayII;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length < 3) {
            return A.length;
        }
        
        int cache = A[0],
            count = 1,
            counter = 1;
            
        for (int i = 1; i < A.length; i++) {
            if (A[i] == cache && count < 2) {
                A[counter] = A[i];
                counter++;
                count++;
            } else if (A[i] != cache){
                cache = A[i];
                count = 1;
                A[counter] = A[i];
                counter++;
            }
        }
        
        return counter;
    }
}
