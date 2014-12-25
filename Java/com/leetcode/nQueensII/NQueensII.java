package com.leetcode.nQueensII;

public class NQueensII {
	public int totalNQueens(int n) {
        int solutions = 0;
        int[] state = new int[n];
        for (int i = 0; i < n; i++) {
            state[i] = -1;
        }
        solutions = getSolutions(n, solutions, 0, state);
        return solutions;
    }
    private boolean isValid(int rowIndex, int columnIndex, int[] state) {
        for (int i = 0; i < rowIndex; i++) {
            if (state[i] == columnIndex || Math.abs(rowIndex - i) == Math.abs(columnIndex - state[i])) {
                return false;
            }
        }
        return true;
    }
    private int getSolutions(int n, int solutions, int rowIndex, int[] state) {
        if (rowIndex == n) {
            solutions++;
            return solutions;
        }
        int count = solutions;
        for (int i = 0; i < n; i++) {
            if (isValid(rowIndex, i, state)) {
                int[] clonedState = state.clone();
                clonedState[rowIndex] = i;
                count = getSolutions(n, count, rowIndex + 1, clonedState);
            }
        }
        
        return count;
    }
}
