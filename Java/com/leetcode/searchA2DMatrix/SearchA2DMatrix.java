package com.leetcode.searchA2DMatrix;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Binary Search
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        }
        
        int rows = matrix.length,
            columns = matrix[0].length,
            start = 0,
            end = rows - 1,
            mid = -1;
        
        while (start <= end) {
            mid = (end + start) / 2;
            if (target < matrix[mid][0]) {
                end = mid - 1;
            } else if (target > matrix[mid][columns - 1]){
                start = mid + 1;
            } else if (target > matrix[mid][0] && target < matrix[mid][columns - 1]) {
                break;
            } else if (target == matrix[mid][0] || target == matrix[mid][columns - 1]) {
                return true;
            }
        }
        
        
         
        // Using another binary search
        start = 0;
        end = columns - 1;
        int rowIndex = mid;
        mid = -1;
        
        while (start <= end) {
            mid = (end + start) / 2;
            if (target < matrix[rowIndex][mid]) {
                end = mid - 1;
            } else if (target == matrix[rowIndex][mid]) {
                return true;
            } else {
                start = mid + 1;
            }
        }
        
        return false;
        

        
    }
}
