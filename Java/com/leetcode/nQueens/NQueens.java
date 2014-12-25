package com.leetcode.nQueens;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	public List<String[]> solveNQueens(int n) {
        ArrayList<String[]> solutions = new ArrayList<String[]>();
        String[] solution = new String[n];
        int[] state = new int[n];
        for (int i = 0; i < n; i++) {
            state[i] = -1;
        }
        getSolutions(n, solutions, solution, 0, state);
        return solutions;
    }
    
    private void depictSolution(String[] solution, int n, int rowIndex, int columnIndex) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == columnIndex) {
                builder.append('Q');
            } else {
                builder.append('.');
            }
        }
        solution[rowIndex] = builder.toString();
    }
    private boolean isValid(int rowIndex, int columnIndex, int[] state) {
        for (int i = 0; i < rowIndex; i++) {
            if (state[i] == columnIndex || Math.abs(rowIndex - i) == Math.abs(columnIndex - state[i])) {
                return false;
            }
        }
        return true;
    }
    private void getSolutions(int n, ArrayList<String[]> solutions, String[] solution, int rowIndex, int[] state) {
        if (rowIndex == n) {
            solutions.add(solution);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(rowIndex, i, state)) {
                String[] clonedSolution = solution.clone();
                int[] clonedState = state.clone();
                depictSolution(clonedSolution, n, rowIndex, i);
                clonedState[rowIndex] = i;
                getSolutions(n, solutions, clonedSolution, rowIndex + 1, clonedState);
            }
        }
    }
}
