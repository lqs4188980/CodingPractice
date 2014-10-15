package com.leetcode.plusOne;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] plusOne(int[] digits){
		// We need a carry
		// We need to add one to the lowest digit first
		if(digits[digits.length - 1] + 1 == 10){
			digits[digits.length - 1] = 0;
			for(int i = digits.length - 2; i >= 0; i--){
				if(digits[i] + 1 == 10){
					digits[i] = 0;
					continue;
				}
				else {
					digits[i] = digits[i] + 1;
					return digits;
				}
			}
			int[] oneMoreDigits = new int[digits.length + 1];
			oneMoreDigits[0] = 1;
			for(int i = 1; i < oneMoreDigits.length; i++){
				oneMoreDigits[i] = 0;
			}
			return oneMoreDigits;
		}
		else {
			digits[digits.length - 1] += 1;
			return digits;
		}
		
		
		
	}

}
