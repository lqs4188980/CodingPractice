package com.leetcode.uniquePathsII;

public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid[0][0] == 1) {
            return 0;
        }
        
        int[][] state = new int[obstacleGrid.length][obstacleGrid[0].length];
        
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                
                if (obstacleGrid[i][j] == 1) {
                    state[i][j] = 0;
                    continue;
                }
                
                if (i - 1 >= 0 && j - 1 < 0) {
                    state[i][j] = state[i - 1][j];
                } else if (i - 1 < 0 && j - 1 >= 0) {
                    state[i][j] = state[i][j - 1];
                } else if (i - 1 < 0 && j - 1 < 0) {
                    state[i][j] = 1;
                } else {
                    state[i][j] = state[i - 1][j] + state[i][j - 1];
                }
                
            }
        }
        
        return state[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
