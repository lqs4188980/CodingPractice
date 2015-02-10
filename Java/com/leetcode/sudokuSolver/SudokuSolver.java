package com.leetcode.sudokuSolver;

import java.util.Arrays;

public class SudokuSolver {
	public static void main(String[] args) {
		SudokuSolver instance = new SudokuSolver();
		String[] setting = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
		
		char[][] board = new char[9][9];
		for (int i = 0; i < setting.length; ++i) {
			board[i] = setting[i].toCharArray();
		}
		
		instance.solveSudoku(board);
		
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board.length; ++j) {
				System.out.print(board[i][j]);
			}
			System.out.print('\n');
		}
		
	}
	
	public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        
        char[][] result = getResult(board);
        for (int i = 0; i < board.length; ++i) {
        	board[i] = Arrays.copyOf(result[i], board.length);
        }
    }
    
    private char[][] getResult(char[][] board) {
        int x = -1, y = -1;
        int[] table = new int[10];
        int rowIndex = 0, columnIndex = 0, rowBound = 0, columnBound = 0;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board.length; ++j) {
                if (board[i][j] == '.') {
                    x = i;
                    y = j;
                    for (int k = 0; k < board.length; ++k) {
                        if (board[i][k] != '.') {
                            table[board[i][k] - '0'] = 1;
                        }
                        
                        if (board[k][j] != '.') {
                            table[board[k][j] - '0'] = 1;
                        }
                    }
                    
                    rowIndex = i / 3 * 3;
                    columnIndex = j / 3 * 3;
                    rowBound = rowIndex + 3;
                    columnBound = columnIndex + 3;
                    for (int row = rowIndex; row < rowBound; ++row) {
                        for (int column = columnIndex; column < columnBound; ++column) {
                            if (board[row][column] != '.') {
                                table[board[row][column] - '0'] = 1;
                            }
                        }
                    }
                    
                    for (int tableIndex = 1; tableIndex < 10; ++tableIndex) {
                        if (table[tableIndex] == 0) {
                            char[][] clone = new char[board.length][board.length];
                            for (int rIndex = 0; rIndex < board.length; ++rIndex) {
                                clone[rIndex] = Arrays.copyOf(board[rIndex], board[rIndex].length);
                            }
                            clone[x][y] = (char)('0' + tableIndex);
                            
                            char[][] result = getResult(clone);
                            if (result != null) {
                                return result;
                            }
                        }
                    }
                    
                    return null;
                }
            }
        }
        
        return board;
  
    }
}
