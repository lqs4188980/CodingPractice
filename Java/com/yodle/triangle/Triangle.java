package com.yodle.triangle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Triangle {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triangle instance = new Triangle();
		System.out.println("Please enter the file path: ");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("The maximum sum from top to bottom is " + instance.getMaxSum(instance.convertTriangle(sc.next())));
		
	}
	
	/*
	 * Calculate maximum sum from top to bottom of a triangle
	 * 
	 * Input: LinkedList. Each node in linked list is a level of triangle, from head to tail corresponding to bottom to top levels.
	 * Output: int value. the maximum sum 
	 */
	public int getMaxSum(LinkedList<Integer[]> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
		
		int[] cache = new int[triangle.size()];
		Integer[] bottom = triangle.pop();
		for (int i = 0; i < cache.length; i++) {
			cache[i] = bottom[i];
		}
		
		Iterator<Integer[]> iterator = triangle.iterator();
		while (iterator.hasNext()) {
			Integer[] level = iterator.next();
			
			for (int i = 0; i < level.length; i++) {
				int leftValue = cache[i] + level[i];
				int rightValue = cache[i + 1] + level[i];
				cache[i] = leftValue > rightValue ? leftValue : rightValue;
			}
		}
		
		return cache[0];
		
	}
	
	/*
	 * Read File and convert each line to Integer array, then push the array into stack.
	 * 
	 * Input: String type, file path.
	 * Output: LinkedList<Integer[]>, stack-liked triangle
	 */
	private LinkedList<Integer[]> convertTriangle(String filePath) {
		LinkedList<Integer[]> triangle = new LinkedList<Integer[]>();
		File file = new File(filePath);
		// Check if file exists and not a directory
		if (file.exists() && !file.isDirectory()) {
			try {
				InputStream fileInputStream = new FileInputStream(file);
				BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
				String line = null;
				while ((line = reader.readLine()) != null) {
					String[] temp = line.split(" ");
					Integer[] level = new Integer[temp.length];
					for (int i = 0; i < temp.length; i++) {
						level[i] = Integer.parseInt(temp[i]);
					}
					triangle.push(level);
				}
				reader.close();
				fileInputStream.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			System.out.println("Please check your file path.");
		}
		
		return triangle;
	}

}
