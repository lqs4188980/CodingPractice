package com.leetcode.subsets;

import java.util.ArrayList;

public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] S = {0};
		for(ArrayList<Integer> subset : subsets(S)){
			for(Integer item : subset){
				System.out.println(item);
			}
			System.out.println('\n');
		}
	}
	
	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
     	if(S == null){
     		ArrayList<Integer> empty = new ArrayList<Integer>();
     		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
     		allSubsets.add(empty);
     		return allSubsets;
     	}
     	
     	// Need a sorting
     	for(int i = 0; i < S.length; i++){
     		int j = i;
     		if((j + 1) == S.length){
     		    break;
     		}
     		int key = S[j + 1];
     		while(j >= 0 && key < S[j]){
     			S[j + 1] = S[j];
     			j--;
     		}
     		S[j + 1] = key;
     		
     	}
     	return getSubsets(S, S.length - 1);

    }

    private static ArrayList<ArrayList<Integer>> getSubsets(int[] S, int index){
    	if(index < 0){
    		ArrayList<Integer> empty = new ArrayList<Integer>();
    		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
    		allSubsets.add(empty);
    		return allSubsets;
    	}

    	ArrayList<ArrayList<Integer>> remainSubsets = getSubsets(S, index - 1);
    	ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
    	for(ArrayList<Integer> oneOfSubset : remainSubsets){
    		ArrayList<Integer> singleSubset = new ArrayList<Integer>();
    		singleSubset.addAll(oneOfSubset);
    		singleSubset.add(S[index]);
    		moreSubsets.add(singleSubset);
    	}
    	
    	remainSubsets.addAll(moreSubsets);

    	return remainSubsets;
    }

}
