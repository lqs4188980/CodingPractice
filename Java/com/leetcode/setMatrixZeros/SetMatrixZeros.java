package com.leetcode.setMatrixZeros;

public class SetMatrixZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
		setZeroes(matrix);
	}
	
    public static void setZeroes(int[][] matrix) {
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
        display(matrix);
    }
    
    private static void display(int[][] matrix) {
    	for (int i = 0; i < matrix.length; i++) {
    		System.out.println();
    		for (int j = 0; j < matrix[0].length; j++) {
    			System.out.print(matrix[i][j] + " ");
    		}
    	}
    	System.out.println();
    }

}
