package com.leetcode.uniquePaths;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        
        int[][] t = new int[m][n];
        t[0][0] = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (j == 0 && i != 0) {
                    t[i][j] = t[i - 1][j];
                } else if (i == 0 && j != 0) {
                    t[i][j] = t[i][j - 1];
                } else {
                    t[i][j] = t[i - 1][j] + t[i][j - 1];
                }
                
            }
        }
        
        return t[m - 1][n - 1];
    }
}
