package com.leetcode.combinationSum2;

import java.util.ArrayList;
import java.util.Hashtable;

public class CombinationSum2 {

	static int levelCounter = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,1};
		ArrayList<ArrayList<Integer>> allSubsets = combinationSum2(num, 1);
		System.out.println("Output results");
		for(ArrayList<Integer> subset : allSubsets){
			for(Integer item : subset){
				System.out.print(item);
			}
			System.out.println('\n');
		}
		
	}
	
    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // I decide to get all the subsets of these numbers, then test one by one.
        if(num == null || (num.length == 1 && num[0] != target)){
            return new ArrayList<ArrayList<Integer>>();
        }
        
        if(num.length == 1 && num[0] == target){
            ArrayList<Integer> singleCombine = new ArrayList<Integer>();
            singleCombine.add(target);
            ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
            allSubsets.add(singleCombine);
            return allSubsets;
        }
    
        // First, I need to sort them in ascending order
        for(int i = 1; i < num.length; i++){
            int j = i - 1;
            int key = num[i];
            while(j >= 0 && key < num[j]){
                num[j + 1] = num[j];
                j--;
            }
            num[j + 1] = key;
        }
        
        //TreeMap<Integer, Integer> numMap = new TreeMap<Integer, Integer>();
        // Second, I need to filter out some impossible numbers
        int i = 0;
        for(; i < num.length; i++){
            if(num[i] > target){
                break;
            }
            /*
            if(numMap.containsKey(num[i])){
                int count = numMap.get(num[i]);
                count += 1;
                numMap.put(num[i], count);
            }
            else{
                numMap.put(num[i], 1);
            }
            */
        }
        
        if(i > 0){
            i--;
        }
        
        
        
        
        int half = target / 2;
        ArrayList<ArrayList<Integer>> allCombinations = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        Hashtable<Integer, Boolean> useTable = new Hashtable<Integer, Boolean>();
        
        if(num[i] == target){
            ArrayList<Integer> singleItem = new ArrayList<Integer>();
            singleItem.add(num[i]);
            allCombinations.add(singleItem);
            i--;
        }
        
        
        getCombinations(num, 0, i, half, target, current, allCombinations, 0, useTable);
        /*
        // Third, I need to get all the subsets of the remaining numbers
        ArrayList<ArrayList<Integer>> allSubsets = getSubsets(num, num.length - 1, i, target);
        ArrayList<ArrayList<Integer>> droppedSubsets = new ArrayList<ArrayList<Integer>>();
        // Fourth, I need to check all the subsets and delete all the unsatisfied subsets.
        for(ArrayList<Integer> subset : allSubsets){
            int sum = 0;
            for(Integer item : subset){
                sum += item;
            }
            if(sum != target){
                droppedSubsets.add(subset);
            }
        }
        allSubsets.removeAll(droppedSubsets);
        return allSubsets;
        */
        return allCombinations;
        
    }
    
    private static void getCombinations(int[] num, int start, int end, int half, int target, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> all, int sum, Hashtable<Integer, Boolean> kickTable){
    	/*
    	System.out.println("******************* Level Start ************************");
    	Hashtable<Integer, Boolean> useTable = new Hashtable<Integer, Boolean>();
    	for(int i = start; i <= end; i++){
    		System.out.println("******************* Iter Start ************************");
    		int aNewSum = sum;
    		System.out.println("Sum before add new one: " + aNewSum);
    		ArrayList<Integer> comb = new ArrayList<Integer>();
            comb.addAll(current);
    		for(int j = i; j <= end; j++){
                if(num[j] >= half){
                    if(aNewSum + num[j] == target){
                        ArrayList<Integer> aComb = new ArrayList<Integer>();
                        aComb.addAll(comb);
                        aComb.add(num[j]);
                        all.add(aComb);
                        System.out.println("Add a new comb into all");
                        for(Integer item : aComb){
                        	System.out.print(item);
                        }
                        System.out.print("\n");
                        return;
                    }
                }
            }
    		
    		if(useTable.containsKey(num[i])){
            	System.out.println(num[i] + ": continued");
                continue;
            }
    		System.out.println("Now deal with num " + num[i] + " at index " + i);
    		comb.add(num[i]);
    		aNewSum += num[i];
    		if(aNewSum > target){
                return;
            }
            
            if(aNewSum == target){
            	System.out.println("Add a new comb outside the loop");
            	all.add(comb);
            	return;
            }
            
            getCombinations(num, i + 1, end, half, target, comb, all, aNewSum);
            
            useTable.put(num[i], true);
    	}
    	*/
    	
    	System.out.println("******************* Level Start ************************");
    	Hashtable<Integer, Boolean> useTable = new Hashtable<Integer, Boolean>();
        for(int i = start; i <= end && num[i] <= half; i++){
        	Hashtable<Integer, Boolean> kickout = new Hashtable<Integer, Boolean>();
        	kickout.putAll(kickTable);
        	System.out.println("The kickout is ");
        	for(Integer item : kickout.keySet()){
        		System.out.print(item);
        	}
        	System.out.print("\n");
        	System.out.println("******************* Iter Start ************************");
        	System.out.println("Now deal with num " + num[i] + " at index " + i);
            int aNewSum = sum;
            System.out.println("Sum before add new one: " + aNewSum);
            if(useTable.containsKey(num[i]) || kickTable.containsKey(num[i])){
            	System.out.println(num[i] + ": continued");
                continue;
            }
            ArrayList<Integer> comb = new ArrayList<Integer>();
            comb.addAll(current);
            System.out.println("Comb before add new one");
            for(Integer item : comb){
            	System.out.print(item);
            }
            System.out.print("\n");
            comb.add(num[i]);
            System.out.println("The current comb now is ");
            for(Integer item : comb){
            	System.out.print(item);
            }
            System.out.print("\n");
            aNewSum += num[i];
            System.out.println("Sum after add new one: " + aNewSum);
            
            if(aNewSum > target){
                return;
            }
            
            if(aNewSum == target){
            	System.out.println("Add a new comb outside the loop");
            	all.add(comb);
            	kickout.put(num[i], true);
            	return;
            }
            
            for(int j = i + 1; j <= end; j++){
                if(num[j] >= half && !kickTable.containsKey(num[j])){
                    if(aNewSum + num[j] == target){
                        ArrayList<Integer> aComb = new ArrayList<Integer>();
                        aComb.addAll(comb);
                        aComb.add(num[j]);
                        kickout.put(num[j], true);
                        all.add(aComb);
                        System.out.println("Add a new comb into all");
                        for(Integer item : aComb){
                        	System.out.print(item);
                        }
                        System.out.print("\n");
                        break;
                    }
                }
            }
            System.out.println("Need to add a new item into comb");
            getCombinations(num, i + 1, end, half, target, comb, all, aNewSum, kickout);
            
            useTable.put(num[i], true);
            
        }
        System.out.println("End of this level\n");
       
    }
}
