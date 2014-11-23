package com.leetcode.mergeSortedArray;

public class MergeSorted {

    public void merge(int A[], int m, int B[], int n) {
        // Start merge from tail
        int index = m + n - 1;
        int a = m - 1;
        int b = n - 1;
        
        while (a >= 0 && b >= 0) {
            if (A[a] > B[b]) {
                A[index] = A[a];
                --a;
            } else {
                A[index] = B[b];
                --b;
            }
            
            --index;
        }
        
        if (b >= 0) {
            while (b >= 0) {
                A[index] = B[b];
                --b;
                --index;
            }
        }
    }
	/*
    public void merge(int A[], int m, int B[], int n) {
        if (m == 0 || n == 0) {
            return;
        }
  
        for (int i = 0; i < m; i++) {
            if (A[i] > B[0]) {
                swap(A, i, B, 0);
                for (int j = 0; j < n - 1; j++) {
                    if (B[j] > B[j + 1]) {
                        swap(B, j, B, j + 1);
                    }
                }
            }
        }
        
        
        for (int i = m, j = 0; j < n; j++) {
            A[i] = B[j];
        }
    }
    
    private void swap(int A[], int a, int B[], int b) {
        int temp = A[a];
        A[a] = B[b];
        B[b] = temp;
    }
*/
}
