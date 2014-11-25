package com.leetcode.minimumWindowSubstring;

public class MinimumWindowSubstring {

	
    public String minWindow(String S, String T) {
        if (S == null || T == null || S.length() < T.length()) {
            return "";
        }
        
        int length = T.length();
        int[] expected = new int[256];
        int[] appeared = new int[256];
        for (int i = 0; i < length; ++i) {
            ++expected[(int)T.charAt(i)];
        }
        
        int l = 0, r = 0, count = 0, lastPosition = -1, edge = S.length(), minLength = Integer.MAX_VALUE;
        
        while (r < edge) {
            char c = S.charAt(r);
            
            if (expected[(int)c] != 0) {
                ++appeared[(int)c];
                if (appeared[(int)c] <= expected[(int)c]) {
                    ++count;
                }
                
                if (count == length) {
                    char token = S.charAt(l);
                    while (expected[(int)token] == 0 || appeared[(int)token] > expected[(int)token]) {
                        if (appeared[(int)token] > expected[(int)token]) {
                            --appeared[(int)token];
                        }
                        ++l;
                        token = S.charAt(l);
                    }
                    if (minLength > r - l + 1) {
                        minLength = r - l + 1;
                        lastPosition = l;
                    }
                    
                }
            }
            
            
            
            ++r;
        }
        
        if (lastPosition == -1) {
            return "";
        }
        return S.substring(lastPosition, lastPosition + minLength);

    }

}
