package com.leetcode.minimumPathSum;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        
        int[][] state = new int[grid.length][grid[0].length];
        
        //state[0][0] = grid[0][0];
        
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int vertical = grid[i][j],
                    horizontal = grid[i][j];
                if (i - 1 >= 0 && j - 1 < 0) {
                    vertical = grid[i][j] + state[i - 1][j];
                    horizontal = Integer.MAX_VALUE;
                }
                if (j - 1 >= 0 && i - 1 < 0) {
                    vertical = Integer.MAX_VALUE;
                    horizontal = grid[i][j] + state[i][j - 1];
                }
                
                if (i - 1 >= 0 && j - 1 >= 0) {
                    vertical = grid[i][j] + state[i - 1][j];
                    horizontal = grid[i][j] + state[i][j - 1];
                }
            
                state[i][j] = min(vertical, horizontal);
            }
        }
        return state[grid.length - 1][grid[0].length - 1];
    }
    
    private int min(int a, int b) {
        return a < b ? a : b;
    }
}
