package com.leetcode.pascalTriangleII;

import java.util.ArrayList;

public class PascalTriangleII {
    public ArrayList<Integer> getRow(int rowIndex) {
        if (rowIndex < 0){
            return new ArrayList<Integer>();
        }
        
        ArrayList<Integer> rv = new ArrayList<Integer>();
        
        if (rowIndex == 0){
            rv.add(1);
            return rv;
        }
        if (rowIndex == 1){
            rv.add(1);
            rv.add(1);
            return rv;
        }
        
        rv.add(1);
        rv.add(1);
        
        Integer[] table = new Integer[rowIndex + 1];
        
        
        for (int i = 2; i <= rowIndex; i++){
            rv.toArray(table);
            rv.clear();
            rv.add(1);
            for (int j = 0; j < i; j++){
                if (j + 1 < i){
                    rv.add(j + 1, (table[j] + table[j + 1]));
                }
            }
            rv.add(1);
        }
        
        
        
        return rv;
        
        
    }
}
