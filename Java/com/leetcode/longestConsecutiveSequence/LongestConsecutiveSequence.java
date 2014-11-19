package com.leetcode.longestConsecutiveSequence;

import java.util.HashMap;
import java.util.LinkedList;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        if (num == null){
            return 0;
        }
        if (num.length == 1){
            return 1;
        }
        int length = num.length;
        HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        boolean[] visited = new boolean[length];
        for(int i = 0; i < length; i++){
            numMap.put(num[i], i);
            visited[i] = false;
        }
        int max = 0;
        for(int i = 0; i < length; i++){
            int current = num[i];
            visited[i] = true;
            int count = 0;
            LinkedList<Integer> queue = new LinkedList<Integer>();
            queue.add(current);
            while(queue.size() != 0){
                current = queue.poll();
                count++;
                visited[numMap.get(current)] = true;
                int prev = current - 1;
                int next = current + 1;
                if (numMap.containsKey(prev) && !visited[numMap.get(prev)]){
                    queue.add(prev);
                }
                if (numMap.containsKey(next) && !visited[numMap.get(next)]){
                    queue.add(next);
                }
            }
            if (max < count){
                max = count;
            }
        }
        
        return max;
    }
}
