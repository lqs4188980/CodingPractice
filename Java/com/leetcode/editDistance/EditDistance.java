package com.leetcode.editDistance;

public class EditDistance {

	
    public int minDistance(String word1, String word2) {
        if (word2 == null || word1 == null || word1.equals(word2)) {
            return 0;
        }
        
        if (word1 == "") {
            return word2.length();
        }
        
        if (word2 == "") {
            return word1.length();
        }
        
        int[][] table = new int[word1.length() + 1][word2.length() + 1];
        
        for (int i = 0; i < table.length; ++i) {
            table[i][0] = i;
        }
        
        for (int i = 0; i < table[0].length; ++i) {
            table[0][i] = i;
        }
        
        for (int i = 1; i < table.length; ++i) {
            for (int j = 1; j < table[0].length; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1];
                } else {
                    table[i][j] = threeMin(table[i - 1][j] + 1, table[i][j - 1] + 1, table[i - 1][j - 1] + 1);
                }
            }
        }
        
        return table[word1.length()][word2.length()];
    }
    
    private int threeMin(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

}
