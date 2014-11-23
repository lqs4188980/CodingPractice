package com.leetcode.grayCode;

import java.util.LinkedList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        LinkedList<Integer> rv = new LinkedList<Integer>();
        rv.push(0);
        if (n > 0) {
            
            int i = 0x1;
            while (n > 0) {
                LinkedList<Integer> helper = new LinkedList<Integer>();
                helper.addAll(rv);
                LinkedList<Integer> stack = new LinkedList<Integer>();
                while (rv.size() != 0) {
                    stack.push(rv.pop().intValue() | i);
                }
                helper.addAll(stack);
                rv = helper;
                n--;
                i = i << 1;
            }
            
        }
        
        return rv;
        
    }
}
