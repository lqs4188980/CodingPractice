package com.leetcode.setMatrixZeros;

public class SetMatrixZeros {

	
    public void setZeroes(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        
        int rows = matrix.length,
            columns = matrix[0].length;
        
        boolean cleanFirstRow = false,
                cleanFirstColumn = false;
        for (int i = 0; i < columns; i++) {
            if (matrix[0][i] == 0) {
                cleanFirstRow = true;
                break;
            }
        }
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                cleanFirstColumn = true;
                break;
            }
        }
        
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < rows; i++) {
            if (matrix[i][0] == 0) {
                for (int column = 0; column < columns; column++) {
                    matrix[i][column] = 0;
                }
            }
        }
        for (int i = 1; i < columns; i++) {
            if (matrix[0][i] == 0) {
                for (int row = 0; row < rows; row++) {
                    matrix[row][i] = 0;
                }
            }
        }
        
        if (cleanFirstRow) {
            for (int i = 0; i < columns; i++) {
                matrix[0][i] = 0;
            }
        }
        
        if (cleanFirstColumn) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
