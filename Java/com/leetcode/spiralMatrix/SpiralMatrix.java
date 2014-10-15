package com.leetcode.spiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,11},{2,12},{3,13},{4,14},{5,15},{6,16},{7,17},{8,18},{9,19},{10,20}};
		spiralOrder(matrix);
	}
	
    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> elementList = new ArrayList<Integer>();
        
        if (matrix == null || (matrix.length == 0 || matrix[0].length == 0)) {
            return (List)elementList;
        }
        
        int top = 0,
            right = matrix[0].length - 1,
            down = matrix.length - 1,
            left = 0,
            count = matrix.length * matrix[0].length,
            counter = 0;
        
        boolean isFinished = false;
        System.out.println("count: " + count);
        while (true) {
        	System.out.println("Start a loop");
            for (int i = left; i <= right; i++) {
                if (counter == count) {
                    isFinished = true;
                    break;
                } else {
                    elementList.add(matrix[top][i]);
                    counter++;
                    System.out.println("counter: " + counter);
                }
            }
            top++;
            
            if (isFinished || counter == count) {
                break;
            }
            
            for (int i = top; i <= down; i++) {
                if (counter == count) {
                    isFinished = true;
                    break;
                } else {
                    elementList.add(matrix[i][right]);
                    counter++;
                    System.out.println("counter: " + counter);
                }
            }
            right--;
            
            if (isFinished || counter == count) {
                break;
            }
            
            for (int i = right; i >= left; i--) {
                if (counter == count) {
                    isFinished = true;
                    break;
                } else {
                	System.out.println("down: " + down + ", i: " + i);
                	
                    elementList.add(matrix[down][i]);
                    counter++;
                    System.out.println("counter: " + counter);
                }
            }
            down--;
            
            if (isFinished || counter == count) {
                break;
            }
            
            for (int i = down; i >= top; i--) {
                if (counter == count) {
                    isFinished = true;
                    break;
                } else {
                    elementList.add(matrix[i][left]);
                    counter++;
                    System.out.println("counter: " + counter);
                }
            }
            left++;
            
            if (isFinished || counter == count) {
                break;
            }
        }
        
        return (List)elementList;
        
    }

}
