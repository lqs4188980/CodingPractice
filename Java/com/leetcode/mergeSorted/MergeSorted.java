package com.leetcode.mergeSorted;

public class MergeSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
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

}
