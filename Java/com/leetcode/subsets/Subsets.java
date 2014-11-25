package com.leetcode.subsets;

import java.util.ArrayList;

public class Subsets {

/*
 * Iterative Version
 *     public List<List<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
        if(S == null){
     		ArrayList<Integer> empty = new ArrayList<Integer>();
     		allSubsets.add(empty);
     		return (List)allSubsets;
     	}
        
        Arrays.sort(S);
        allSubsets.add(new ArrayList<Integer>());
        
        ArrayList<ArrayList<Integer>> cacheSets = new ArrayList<ArrayList<Integer>>();
     	for (int i = 0; i < S.length; ++i) {
     	    for (ArrayList<Integer> subset : allSubsets) {
    	        ArrayList<Integer> cloneSub = new ArrayList<Integer>();
    	        cloneSub.addAll(subset);
    	        cloneSub.add(S[i]);
    	        cacheSets.add(cloneSub);
    	    }
    	    allSubsets.addAll(cacheSets);
    	    cacheSets.clear();
     	}
     	return (List)allSubsets;
    }
 */
	
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
