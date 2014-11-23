package com.leetcode.uniqueBinarySearchTrees;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        // Dynamic Programming Edition: http://fisherlei.blogspot.com/2013/03/leetcode-unique-binary-search-trees.html
        
        if (n < 0) {
            return 0;
        }
        
        if (n == 0 || n == 1) {
            return 1;
        }
        
        int[] count = new int[n + 1];
        
        count[0] = 1;
        count[1] = 1;
        
        for (int i = 2; i <= n; ++i) {
            count[i] = 0;
            for (int j = 0; j < i; ++j) {
                count[i] += count[j] * count[i - j - 1];
            }
        }
        
        return count[n];
    }
}
