package com.leetcode.twoSum;

import java.util.Hashtable;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] twoSum(int[] numbers, int target) { 
        int[] index = new int[2];
        index[0] = -1;
        index[1] = -1;
        Hashtable<Integer, Integer> indexTable = new Hashtable<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++){
        	if (!indexTable.containsKey(target - numbers[i])) {
				indexTable.put((target - numbers[i]), i);
			}
        	
        	if(indexTable.containsKey(numbers[i])){
        		index[0] = indexTable.get(numbers[i]) + 1;
            	index[1] = i + 1;
            	if(index[0] == index[1])
            		continue;
            	return index;
        	}
        	
        }
        return index;
    }
	

}
