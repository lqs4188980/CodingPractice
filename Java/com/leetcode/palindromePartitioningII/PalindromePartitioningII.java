package com.leetcode.palindromePartitioningII;

public class PalindromePartitioningII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minCut("dde"));
	}
	
    public static int minCut(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        
        int length = s.length();
        int[] min = new int[length];
        min[0] = 0;
        int[][] p = new int[length][length];
        for (int i = 0; i < length; i++) {
            p[i][i] = 1;
        }
        
        StringBuilder builder = new StringBuilder(s);
        
        for (int i = 2; i <= length; i++) {
            int minimum = Integer.MAX_VALUE;
            for (int j = i - 1; j>= 0; j--) {
                if (isPalindrome(builder, j, i - 1, p)) {
                    if (j - 1 >= 0 && 1 + min[j - 1] < minimum) {
                        minimum = 1 + min[j - 1];
                    } else if (j - 1 < 0) {
                    	minimum = 0;
                    }
                }
            }
            min[i - 1] = minimum;
            //System.out.println(minimum);
        }
        
        
        
        return min[length - 1];
    }
    
    private static boolean isPalindrome(StringBuilder s, int start, int end, int[][] table) {
    	System.out.println(start + ", " + end);
    	if (start > end) {
    		return false;
    	}
    	
        if (table[start][end] == 1) {
        	//System.out.println("Reach here");
            return true;
        } else if (table[start][end] == 0){
            if ((end - start < 2 && s.charAt(start) == s.charAt(end)) || (s.charAt(start) == s.charAt(end) && isPalindrome(s, start + 1, end - 1, table))) {
                table[start][end] = 1;
                return true;
            } else {
                table[start][end] = -1;
                return false;
            }
        } else {
            return false;
        }
    }

}
