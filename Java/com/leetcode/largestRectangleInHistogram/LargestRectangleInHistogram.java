package com.leetcode.largestRectangleInHistogram;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
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
