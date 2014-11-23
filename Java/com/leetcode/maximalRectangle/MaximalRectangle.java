package com.leetcode.maximalRectangle;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int max = 0;
        int[] histHeight = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                histHeight[j] = matrix[i][j] == '0' ? 0 : (histHeight[j] + 1);
            }
            max = Math.max(largestRectangleArea(histHeight), max);
        }
        
        return max;
    }
    
    private int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        if (height.length == 1) {
            return height[0];
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        
        for (int i = 0; i < height.length; i++) {
            if (stack.empty() || height[i] >= height[stack.peek()]) {
                stack.push(i);
            } else {
                int top = stack.pop();
                max = Math.max(max, height[top] * (stack.empty() ? i : i - stack.peek() - 1));
                --i;
            }
        }
        
        while (!stack.empty()) {
            int top = stack.pop();
            max = Math.max(max, height[top] * (stack.empty() ? height.length : height.length - stack.peek() - 1));
        }
        
        return max;
        
    }
}
