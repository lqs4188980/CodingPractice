package com.leetcode.gasStation;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0) {
            return -1;
        }
        
        int[] balance = new int[gas.length];
        
        for (int i = 0; i < gas.length; ++i) {
            balance[i] = gas[i] - cost[i];
        }
        
        int remain = 0,
            sum = 0,
            start = 0;
        for (int i = 0; i < balance.length; ++i) {
            remain += balance[i];
            sum += balance[i];
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        
        if (remain < 0) {
            return -1;
        } else {
            return start;
        }
        
    }
}
