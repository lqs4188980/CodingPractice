package com.leetcode.spiralMatrixII;

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }
        
        int[][] matrix = new int[n][n];
        
        int counter = 0,
            count = n * n;
        
        int top = 0,
            down = n - 1,
            left = 0,
            right = n - 1,
            num = 0;
        boolean isFinished = false;
        while (true) {
            for (int i = left; i < n; i++) {
                if (num != count && matrix[top][i] == 0) {
                    num++;
                    matrix[top][i] = num;
                } else if (num == count){
                    isFinished = true;
                    break;
                }
            }
            
            if (isFinished || num == count) {
                break;
            }
            top++;
            
            for (int i = top; i < n; i++) {
                if (num != count && matrix[i][right] == 0) {
                    num++;
                    matrix[i][right] = num;
                    
                } else if (num == count) {
                    isFinished = true;
                    break;
                }
            }
            
            if (isFinished || num == count) {
                break;
            }
            right--;
            
            for (int i = right; i >= 0; i--) {
                if (num != count && matrix[down][i] == 0) {
                    num++;
                    matrix[down][i] = num;
                    
                } else if (num == count) {
                    isFinished = true;
                    break;
                }
            }
            
            if (isFinished || num == count) {
                break;
            }
            down--;
            
            for (int i = down; i >= 0; i--) {
                if (num != count && matrix[down][i] == 0) {
                    num++;
                    matrix[i][left] = num;
                    
                } else if (num == count) {
                    isFinished = true;
                    break;
                }
            }
            
            if (isFinished || num == count) {
                break;
            }
            
            left++;
            
        }
        
        return matrix;
    }
}
