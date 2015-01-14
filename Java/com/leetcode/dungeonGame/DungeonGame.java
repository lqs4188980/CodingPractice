package com.leetcode.dungeonGame;

public class DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        /*  Abstraction: 
                backtracking. Optimized by Dynamic Programming.
            Basic idea:
                minInit[i][j] represents the minimum initial hp when start from (i, j) that can reach to target
                minInit[i][j] = max(1, min(minInit[i + 1][j], minInit[i][j + 1]) - dungeon[i][j])
        */
        
        int[] minInit = new int[dungeon[0].length + 1];
        for (int i = 0; i < minInit.length; ++i) {
            minInit[i] = Integer.MAX_VALUE;
        }
        minInit[dungeon[0].length] = Integer.MAX_VALUE;
        minInit[dungeon[0].length - 1] = 1;
        
        for (int i = dungeon.length - 1; i >= 0; --i) {
            for (int j = dungeon[0].length - 1; j >= 0; --j) {
                minInit[j] = Math.max(1, Math.min(minInit[j], minInit[j + 1]) - dungeon[i][j]);
            }
        }
        
        return minInit[0];
    }
}
