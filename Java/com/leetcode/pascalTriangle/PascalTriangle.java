package com.leetcode.pascalTriangle;

import java.util.ArrayList;
import java.util.Iterator;

public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<ArrayList<Integer>> generate(int numRows){
		if(numRows == 0){
			ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
			return triangle;
		}

		if(numRows == 1){
			ArrayList<Integer> top = new ArrayList<Integer>();
			top.add(1);
			ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
			triangle.add(top);
			return triangle;
		}

		ArrayList<ArrayList<Integer>> triangle = generate(numRows - 1);
		ArrayList<Integer> currentLevel = new ArrayList<Integer>();
		currentLevel.add(1);
		ArrayList<Integer> upperLevel = triangle.get(numRows - 2);
		
		if(upperLevel.size() == 1){
			currentLevel.add(1);
			triangle.add(currentLevel);
			return triangle;
		}

		Iterator<Integer> itrt = upperLevel.iterator();
		int current = itrt.next();
		int next = 0;
		do{
			next = itrt.next();
			currentLevel.add(current + next);
			current = next;
		}while(itrt.hasNext());
		currentLevel.add(1);
		triangle.add(currentLevel);
		return triangle;

	}
}
