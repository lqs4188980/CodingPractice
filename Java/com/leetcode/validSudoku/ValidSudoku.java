package com.leetcode.validSudoku;

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }
        
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                if (!isValidSquare(board, i, j)) {
                    return false;
                }
            }
        }
        
        for (int i = 0; i < board.length; ++i) {
            if (!isValidLine(board, i)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isValidSquare(char[][] board, int rowIndex, int columnIndex) {
        int rowBound = rowIndex + 3;
        int columnBound = columnIndex + 3;
        int[] table = new int[10];
        int digit = 0;
        for (int i = rowIndex; i < rowBound; ++i) {
            for (int j = columnIndex; j < columnBound; ++j) {
                if (board[i][j] != '.') {
                    digit = board[i][j] - '0';
                    if (table[digit] == 0) {
                        table[digit] = 1;
                    } else {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    private boolean isValidLine(char[][] board, int index) {
        int bound = board.length;
        int[] table = new int[10];
        int digit = 0;
        for (int i = 0; i < bound; ++i) {
            if (board[index][i] != '.') {
                digit = board[index][i] - '0';
                if (table[digit] == 0) {
                    table[digit] = 1;
                } else {
                    return false;
                }
            }
        }
        
        for (int i = 1; i < 10; ++i) {
            table[i] = 0;
        }
        
        for (int i = 0; i < bound; ++i) {
            if (board[i][index] != '.') {
                digit = board[i][index] - '0';
                if (table[digit] == 0) {
                    table[digit] = 1;
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }

}
