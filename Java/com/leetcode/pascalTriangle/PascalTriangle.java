package com.leetcode.pascalTriangle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<List<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        if(numRows == 0){
			return (List)triangle;
		}
		ArrayList<Integer> level1 = new ArrayList<Integer>();
		level1.add(1);
		triangle.add(level1);
        if(numRows == 1){
			return (List)triangle;
		}
		
		ArrayList<Integer> prevLevel = new ArrayList<Integer>();
		prevLevel.add(1);
		prevLevel.add(1);
		triangle.add(prevLevel);
		int size = 0;

        for (int i = 2; i < numRows; ++i) {
            ArrayList<Integer> nextLevel = new ArrayList<Integer>();
            nextLevel.add(1);
            size = i;
            for (int j = 0; j < size - 1; ++j) {
                nextLevel.add(prevLevel.get(j) + prevLevel.get(j + 1));
            }
            nextLevel.add(1);
            triangle.add(nextLevel);
            prevLevel = nextLevel;
        }
        return (List)triangle;
    }
}
