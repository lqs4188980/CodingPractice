package com.leetcode.sortColors;

public class SortColors {
    public void sortColors(int[] A) {
        if (A == null || A.length <= 1) {
            return;
        }
        
        int red = 0, i = 0, blue = A.length - 1, temp = 0;
        
        while (i < blue + 1) {
            if (A[i] == 0) {
                temp = A[red];
                A[red] = A[i];
                A[i] = temp;
                ++red;
                ++i;
                continue;
            }
            
            if (A[i] == 2) {
                temp = A[blue];
                A[blue] = A[i];
                A[i] = temp;
                --blue;
                continue;
            }
            
            ++i;
        }
    }
}
