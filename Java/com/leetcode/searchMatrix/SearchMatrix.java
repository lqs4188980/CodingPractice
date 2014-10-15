package com.leetcode.searchMatrix;

public class SearchMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1}, {3}};
		int target = 0;
		System.out.println(searchMatrix(matrix, target));
	}
	
	
    public static boolean searchMatrix(int[][] matrix, int target) {
        // Binary Search
        if (matrix == null) {
            return false;
        }
        
        int rows = matrix.length,
            columns = matrix[0].length,
            start = 0,
            end = rows - 1,
            mid = (end + start) / 2,
            columnIndex = 0;
        
        while (start <= end) {
        	System.out.println(start + ", " + end + ", " + mid);
            if (target < matrix[mid][0]) {
                end = mid - 1;
                mid = (end + start) / 2;
                continue;
            } else if (target == matrix[mid][0]) {
                return true;
            } else if (target > matrix[mid][columns - 1]) {
                start = mid + 1;
                mid = (end + start) / 2;
                continue;
            } else if (target == matrix[mid][columns - 1]){
                return true;
            } else {
                break;
            }
        }
        
        
        while (columnIndex < columns && matrix[mid][columnIndex] < target) {
            columnIndex++;
        }
        
        if (columnIndex == columns || matrix[mid][columnIndex] > target) {
            return false;
        }
        
        return true;
        
        
    }

}
