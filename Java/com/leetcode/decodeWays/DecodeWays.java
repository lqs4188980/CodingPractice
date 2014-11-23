package com.leetcode.decodeWays;

public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        
        StringBuilder b = new StringBuilder(s);
        
        int length = b.length();
        
        int[] table = new int[length + 1];
        
        table[0] = 1;
        table[1] = 1;
        for (int i = 2; i <= length; i++) {
            int value = Integer.parseInt(b.substring(i - 2, i));
            // Eg: 110, '0' cannot represent a single character, so the decode should be 1, 10, table[i] = table[i - 2]
            if (b.charAt(i - 1) == '0' && value > 0 && value <= 26) {
                table[i] = table[i - 2];
            } else if (b.charAt(i - 1) != '0') {
                // Eg: 111, tail '1' represents 'A', so it has at least table[i - 1] decode ways. Also, '11' is another way, so it has another table[i - 2] ways
                if (value >= 10 && value <= 26) {
                    table[i] = table[i - 1] + table[i - 2];
                } else {
                    // Eg: 137, we cannot decode '37', so it only has table[i - 1] ways.
                    table[i] = table[i - 1];
                }
            } else {
                // Some code cannot find decode ways, eg.100
                return 0;
            }
        }
        
        return table[length];
    }
}
