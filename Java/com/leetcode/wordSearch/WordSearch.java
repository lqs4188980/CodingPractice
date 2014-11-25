package com.leetcode.wordSearch;

import javax.security.auth.x500.X500Principal;

public class WordSearch {


	
    public boolean exist(char[][] board, String word) {
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
                
                if (search(word, 0, checker, board, i, j)) {
                    return true;
                }
                
            }
        }
        
        return false;
    }
    
    private boolean search(String word, int index, boolean[][] checker, char[][] board, int x, int y) {
        
        char c = word.charAt(index);
        if (board[x][y] != c || checker[x][y]) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        
        // Checker is true means "accessed"
        checker[x][y] = true;
        
        int rows = board.length;
        int columns = board[0].length;
        
        if (y - 1 >= 0 && search(word, index + 1, checker, board, x, y - 1)) {
            return true;
        }
        
        if (y + 1 < columns && search(word, index + 1, checker, board, x, y + 1)) {
            return true;
        }
        
        if (x - 1 >= 0 && search(word, index + 1, checker, board, x - 1, y)) {
            return true;
        }
        if (x + 1 < rows && search(word, index + 1, checker, board, x + 1, y)) {
            return true;
        }
        
        // This grid cannot be in the current path, but maybe in other paths, so set it to "unaccessed"
        checker[x][y] = false;
        return false;
    }
}
