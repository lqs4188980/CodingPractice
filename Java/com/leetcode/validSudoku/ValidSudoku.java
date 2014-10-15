package com.leetcode.validSudoku;

import java.util.HashSet;

public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'.', '.', '.', '.', '5', '.', '.', '1', '.' },{'.', '4', '.', '3', '.', '.', '.', '.', '.' },{'.', '.', '.', '.', '.', '3', '.', '.', '1'},{'8', '.', '.', '.', '.', '.', '.', '2', '.'},{'.', '.', '2', '.', '7', '.', '.', '.', '.'},{'.', '1', '5', '.', '.', '.', '.', '.', '.'},{'.', '.', '.', '.', '.', '2', '.', '.', '.'},{'.', '2', '.', '9', '.', '.', '.', '.', '.'},{'.', '.', '4', '.', '.', '.', '.', '.', '.'}};
		System.out.println(isValidSudoku(board));
	}
	
    static HashSet<Integer> table = new HashSet<Integer>();
    public static boolean isValidSudoku(char[][] board) {
        if (board == null || (board.length == 0 && board[0].length == 0)) {
            return false;
        }
        
        
        for (int i = 1; i <= 9; i++) {
            table.add(i);
        }
        
        for (int l = 0; l < board.length; l++) {
            if (!checker(board, l, l + 1, 0, board[0].length)) {
                return false;
            }
        }
        
        for (int c = 0; c < board[0].length; c++) {
            if (!checker(board, 0, board.length, c, c + 1)) {
                return false;
            }
        }
        
        for (int l = 0; l < board.length; l += 3) {
            for (int c = 0; c < board[0].length; c += 3) {
            	System.out.println("************* " + l + ", " + c + " ****************");
                if (!checker(board, l, l + 3, c, c + 3)) {
                    return false;
                }
            }
        }
        
        return true;
        
    }
    
    private static boolean checker(char[][] board, int lineStart, int lineLength, int columnStart, int columnLength) {
        HashSet<Integer> sheet = (HashSet<Integer>)table.clone();
        
        for (int i = lineStart; i < lineLength; i++) {
            for (int j = columnStart; j < columnLength; j++) {
            	System.out.println("(" + i + ", " + j + ") = " + board[i][j]);
                if (board[i][j] == '.') {
                    continue;
                } else if (!sheet.contains(board[i][j] - 48)) {
                    return false;
                } else {
                    sheet.remove(board[i][j] - 48);
                }
            }
        }
        
        return true;
    }

}
