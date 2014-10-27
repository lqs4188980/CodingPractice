package com.leetcode.evaluateReversePolishNotation;

public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        
        int[] stack = new int[tokens.length];
        int length = tokens.length;
        int stackPt = -1;
        for (int i = 0; i < length; i++) {
            String item = tokens[i];
            if (item.equals("+")) {
                stack[stackPt - 1] = (stack[stackPt - 1] + stack[stackPt]);
                stackPt--;
            } else if (item.equals("-")) {
                stack[stackPt - 1] = (stack[stackPt - 1] - stack[stackPt]);
                stackPt--;
            } else if (item.equals("*")) {
                stack[stackPt - 1] = (stack[stackPt - 1] * stack[stackPt]);
                stackPt--;
            } else if (item.equals("/")) {
                stack[stackPt - 1] = (stack[stackPt - 1] / stack[stackPt]);
                stackPt--;
            } else {
                stackPt++;
                stack[stackPt] = Integer.parseInt(item);
            }
            
        }
        
        return stack[stackPt];
    }

}
