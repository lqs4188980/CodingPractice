package com.leetcode.subset2;

import java.util.ArrayList;
import java.util.List;

public class Subset2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {5,5,5,5,5};
		for (List<Integer> set : subsetsWithDup(num)) {
			System.out.println(set);
			for (Integer item : set) {
				System.out.print(item);
			}
			System.out.println('\n');
		}
	}
	
    public static List<List<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> addSet = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> totalSet = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> empty = new ArrayList<Integer>();
        totalSet.add(empty);
        
        if (num == null || num.length == 0) {
            return (List)totalSet;
        }
        
        insertionSort(num);
        
        // If the current element is same as previous element.
        boolean isSame = false;
        int index = 0;
        while (index < num.length) {
            if (!isSame) {
                addSet = new ArrayList<ArrayList<Integer>>();
                for (ArrayList<Integer> subset : totalSet) {
                    ArrayList<Integer> clonedSet = new ArrayList<Integer>();
                    clonedSet.addAll(subset);
                    clonedSet.add(num[index]);
                    addSet.add(clonedSet);
                }
                totalSet.addAll(addSet);
            } else {
            	ArrayList<ArrayList<Integer>> supportSet = new ArrayList<ArrayList<Integer>>();
                for (ArrayList<Integer> subset : addSet) {
                    ArrayList<Integer> clonedSet = new ArrayList<Integer>();
                    clonedSet.addAll(subset);
                    clonedSet.add(num[index]);
                    supportSet.add(clonedSet);
                }
                totalSet.addAll(supportSet);
                addSet = supportSet;
            }
            
            if (index + 1 < num.length) {
                isSame = (num[index] == num[index + 1]);
            } 
            index++;
        }
        
        return (List)totalSet;
    }
    
    private static void insertionSort(int[] num) {
        if (num.length == 1) {
            return;
        }
        
        int key = -1;
        for (int i = 1; i < num.length; i++) {
            key = num[i];
            int j = i - 1;
            for (; j >= 0 && key < num[j]; j--) {
                num[j + 1] = num[j];
            }
            num[j + 1] = key;
        }
    }

}
