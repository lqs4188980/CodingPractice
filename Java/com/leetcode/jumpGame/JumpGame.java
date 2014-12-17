package com.leetcode.jumpGame;

public class JumpGame {
	public boolean canJump(int[] A) {
		
		// A greedy method. From the current point, find out its farthest point we can reach.
        if (A == null) {
            return false;
        }
        if (A.length == 1) {
            return true;
        }
        
        int farthest = 0;
        int current = 0;
        while (current <= farthest && current < A.length) {
            if (farthest < current + A[current]) {
                farthest = current + A[current];
            }
            if (farthest >= A.length - 1) {
                return true;
            }
            ++current;
        }
        
        return false;
    }
}
