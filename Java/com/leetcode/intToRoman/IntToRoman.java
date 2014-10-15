package com.leetcode.intToRoman;

public class IntToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String intToRoman(int num){
		StringBuilder romanString = new StringBuilder();
		// Thousands
		int numOfM = num / 1000;
		appendSymbol(numOfM, romanString, 'M');
		num = num % 1000;

		// Hundreds
		if(num < 400){
			int numOfC = num / 100;
			num = num % 100;
			appendSymbol(numOfC, romanString, 'C');
		}
		if(num >= 400 && num < 900){
			if(num < 500){
				romanString.append("CD");
				num = num % 400;
			}
			else{
				romanString.append('D');
				num = num % 500;
				int numOfC = num / 100;
				num = num % 100;
				appendSymbol(numOfC, romanString, 'C');
			}
		}
		if(num >= 900){
			romanString.append("CM");
			num = num % 900;
		}

		// Tens
		if(num < 40){
			int numOfX = num / 10;
			num = num % 10;
			appendSymbol(numOfX, romanString, 'X');
		}
		if(num >= 40 && num < 90){
			if(num < 50){
				romanString.append("XL");
				num = num % 40;
			}
			else{
				romanString.append('L');
				num = num % 50;
				int numOfX = num / 10;
				num = num % 10;
				appendSymbol(numOfX, romanString, 'X');
			}
		}
		if(num >= 90){
			romanString.append("XC");
			num = num % 90;
		}

		// Ones
		if(num < 4){
			appendSymbol(num, romanString, 'I');
		}
		if(num >= 4 && num < 9){
			if(num < 5){
				romanString.append("IV");
			}
			else{
				romanString.append('V');
				num = num % 5;
				appendSymbol(num, romanString, 'I');
			}
		}
		if(num == 9){
			romanString.append("IX");
		}
		
		return romanString.toString();

	}
	private void appendSymbol(int numOfTimes, StringBuilder str, char symbol){
		for(int i = 0; i < numOfTimes; i++){
			str.append(symbol);
		}
	}

}
