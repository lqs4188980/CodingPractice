package com.leetcode.removeDuplicates;

import java.util.TreeMap;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,2,4};
		int length = removeDuplicates(A);
		System.out.println("The length is " + length);
		for(int i = 0; i < length; i++){
			System.out.println(A[i]);
		}
	}
	
	public static int removeDuplicates(int[] A){
		if(A.length == 0){
			return 0;
		}
		int length = 0;
		TreeMap<Integer, Boolean> sortedMap = new TreeMap<Integer, Boolean>();
		int i = 0;
		while(i < A.length){
			if(!sortedMap.containsKey(new Integer(A[i]))){
				sortedMap.put(new Integer(A[i]), true);
				length++;
				i++;
			}
			else {
				i++;
				continue;
			}
		}
		i = 0;
		for(int key : sortedMap.keySet()){
			A[i] = key;
			i++;
		}
		/*
		Hashtable<Integer, Boolean> nonDupTable = new Hashtable<Integer, Boolean>();
		int length = 0;
		int i = 0;
		while(i < A.length){
			if(!nonDupTable.containsKey(new Integer(A[i]))){
				nonDupTable.put(new Integer(A[i]), true);
				length++;
				i++;
			}
			else {
				i++;
				continue;
			}
		}
		Iterator<Integer> itemItrt = nonDupTable.keySet().iterator();
		A[0] = itemItrt.next();
		i = 0;
		int j = 0;
		while(itemItrt.hasNext()){
			int item = itemItrt.next();
			for(i = j; i >= 0 && A[i] > item; i--){
				A[i + 1] = A[i];
			}
			A[i + 1] = item;
			j++;
		}
		*/
		return length;
	}

}
