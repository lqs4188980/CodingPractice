package com.leetcode.distinctSubsequences;

public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        if(S == null || T == null || S.length() < T.length() || S.length() == 0 || T.length() == 0){
            return 0;
        }
        
        StringBuilder sBuilder = new StringBuilder(S);
        StringBuilder tBuilder = new StringBuilder(T);
        int[][] table = new int[sBuilder.length() + 1][tBuilder.length() + 1];
        for(int i = 0; i <= tBuilder.length(); i++){
            table[0][i] = 0;
        }
        for(int i = 0; i <= sBuilder.length(); i++){
            table[i][0] = 1;
        }
        
        
        for(int i = 1; i <= sBuilder.length(); i++){
            for(int j = 1; j <= tBuilder.length(); j++){
                if(sBuilder.charAt(i - 1) == tBuilder.charAt(j - 1)){
                    table[i][j] = table[i - 1][j] + table[i - 1][j - 1];
                }
                else{
                    table[i][j] = table[i - 1][j];
                }
            }
        }
        
        return table[sBuilder.length()][tBuilder.length()];
        
        
    }
}
