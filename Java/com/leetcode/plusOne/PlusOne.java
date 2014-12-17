package com.leetcode.plusOne;

public class PlusOne {

	public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        
        int carry = 1, value = -1;
        for (int i = digits.length - 1; i >= 0 && carry > 0; --i) {
            value = digits[i] + carry;
            digits[i] = value % 10;
            carry = value / 10;
        }
        
        if (carry > 0) {
            int[] reallocate = new int[digits.length + 1];
            for (int i = digits.length - 1; i >= 0; --i) {
                reallocate[i + 1] = digits[i];
            }
            
            reallocate[0] = carry;
            return reallocate;
        } else {
            return digits;
        }
    }
/*	
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
*/
}
