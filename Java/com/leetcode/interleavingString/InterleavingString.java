package com.leetcode.interleavingString;

public class InterleavingString {

	
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null 
            || s2 == null 
            || s3 == null 
            || s1.length() + s2.length() != s3.length()
            || s1.length() == 0 && !s2.equals(s3)
            || s2.length() == 0 && !s1.equals(s3)) {
            return false;
        }
        
        if ((s1.length() == 0 && s2.equals(s3)) || (s2.length() == 0 && s1.equals(s3))) {
            return true;
        }
        
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        char[] a3 = s3.toCharArray();
        
        boolean[][] table = new boolean[a1.length + 1][a2.length + 1];
        
        
        for (int i = 0; i <= a1.length; i++) {
            for (int j = 0; j <= a2.length; j++) {
                if (i == 0 && j == 0) {
                    table[i][j] = true;
                } else if (i == 0) {
                    if (a2[j - 1] == a3[j - 1]){
                        table[i][j] = table[i][j - 1];
                    } else {
                        table[i][j] = false;
                    }
                    continue;
                } else if (j == 0) {
                    if (a1[i - 1] == a3[i - 1]) {
                        table[i][j] = table[i - 1][j];
                    } else {
                        table[i][j] = false;
                    }
                    continue;
                } else if (a1[i - 1] != a3[i + j - 1] && a2[j - 1] != a3[i + j - 1]) {
                    table[i][j] = false;
                    continue;
                } else if (a1[i - 1] != a3[i + j - 1] && a2[j - 1] == a3[i + j - 1]) {
                    table[i][j] = table[i][j - 1];
                    continue;
                } else if (a1[i - 1] == a3[i + j - 1] && a2[j - 1] != a3[i + j - 1]) {
                    table[i][j] = table[i - 1][j];
                    continue;
                } else {
                    table[i][j] = table[i - 1][j] || table[i][j - 1];
                    continue;
                }
            }
        }
        
        return table[a1.length][a2.length];
    }

}
