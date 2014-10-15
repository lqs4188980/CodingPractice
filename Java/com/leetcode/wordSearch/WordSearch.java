package com.leetcode.wordSearch;

import javax.security.auth.x500.X500Principal;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
		String word = "AAB";
		System.out.println(exist(board, word));
	}
	
    public static boolean exist(char[][] board, String word) {
        if (word == null || board == null) {
            return false;
        }
        
        int rows = board.length;
        int columns = board[0].length;
        int length = word.length();
        
        if (length > rows * columns) {
            return false;
        }
        
        
        
        boolean[][] checker = new boolean[rows][columns];
        char first = word.charAt(0);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // Wait for search
                if (board[i][j] == first) {
                    checker[i][j] = true;
                    System.out.println("Start from " + i + ", " + j);
                    if (search(word, 1, checker, board, i, j)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private static boolean search(String word, int index, boolean[][] checker, char[][] board, int x, int y) {
        if (index == word.length()) {
            return true;
        }
        
        char c = word.charAt(index);
        System.out.println("Char is " + c);
        int rows = board.length;
        int columns = board[0].length;
        
        if (y - 1 >= 0 && !checker[x][y - 1] && board[x][y - 1] == c) {
        	System.out.println("LEFT");
            boolean[][] updateChecker = checker.clone();
            updateChecker[x][y - 1] = true;
            if (search(word, index + 1, updateChecker, board, x, y - 1)) {
                return true;
            }
        }
        
        if (y + 1 < columns && !checker[x][y + 1] && board[x][y + 1] == c) {
        	System.out.println("RIGHT");
            boolean[][] updateChecker = checker.clone();
            updateChecker[x][y + 1] = true;
            if (search(word, index + 1, updateChecker, board, x, y + 1)) {
                return true;
            }
        }
        
        if (x - 1 >= 0 && !checker[x - 1][y] && board[x - 1][y] == c) {
        	System.out.println("UP");
            boolean[][] updateChecker = checker.clone();
            updateChecker[x - 1][y] = true;
            if (search(word, index + 1, updateChecker, board, x - 1, y)) {
                return true;
            }
        }
        if (x + 1 < rows && !checker[x + 1][y] && board[x + 1][y] == c) {
        	System.out.println("DOWN");
            boolean[][] updateChecker = checker.clone();
            updateChecker[x + 1][y] = true;
            if (search(word, index + 1, updateChecker, board, x + 1, y)) {
                return true;
            }
        }
        
        return false;
    }

}
