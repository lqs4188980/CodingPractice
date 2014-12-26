package com.leetcode.rotateImage;

public class RotateImage {
	public void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        
        int 
            start = 0,
            end = matrix.length - 1,
            temp = -1;
        while (start < end) {
            int j = end;
            for (int i = start; i < end; i++, j--) {
                temp = matrix[start][i];
                matrix[start][i] = matrix[j][start];
                matrix[j][start] = matrix[end][j];
                matrix[end][j] = matrix[i][end];
                matrix[i][end] = temp;
                
            }
            
            start++;
            end--;
        }
        
        
    }
}
