package com.leetcode.triangle;

import java.util.ArrayList;

public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0){
            return Integer.MAX_VALUE;
        }
        
        // Referenced from http://www.programcreek.com/2013/01/leetcode-triangle-java/
        int size = triangle.size();
        int[] table = new int[size];
        
        // Initialize the table with bottom line
        for (int i = 0; i < size; i++){
            table[i] = triangle.get(size - 1).get(i);
        }
        
        // Build up path sum from bottom
        for (int i = size - 2; i >= 0; i--){
            int aboveLevelSize = triangle.get(i + 1).size() - 1;
        
            for (int j = 0; j < aboveLevelSize; j++){
                table[j] = triangle.get(i).get(j) + (table[j] < table[j + 1] ? table[j] : table[j + 1]);
            }
        }
        
        return table[0];
        
    }
}
