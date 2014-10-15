package com.leetcode.editDistance;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minDistance("", ""));

	}
	
	public static int minDistance(String word1, String word2){
		StringBuilder s1 = new StringBuilder(word1);
		StringBuilder s2 = new StringBuilder(word2);
		
		int[][] distanceTable = new int[s1.length() + 1][s2.length() + 1];
		for(int i = 0; i < s1.length() + 1; i++){
			distanceTable[i][0] = i;
		}
		for(int j = 0; j < s2.length() + 1; j++){
			distanceTable[0][j] = j;
		}
		for(int i = 1; i < s1.length() + 1; i++){
			for(int j = 1; j < s2.length() + 1; j++){
				if(s1.charAt(i - 1) == s2.charAt(j - 1)){
					distanceTable[i][j] = distanceTable[i - 1][j - 1];
				}
				else {
					distanceTable[i][j] = minOfThree(distanceTable[i - 1][j] + 1, distanceTable[i][j - 1] + 1, distanceTable[i - 1][j - 1] + 1);
				}
			}
		}
		for(int i = 0;i < s1.length(); i++){
			for(int j = 0; j < s2.length(); j++){
				System.out.print(distanceTable[i][j]);
			}
			System.out.print("\n");
		}
		return distanceTable[s1.length()][s2.length()];
		
	}
	
	private static int minOfThree(int a, int b, int c){
		return minOfTwo(a, minOfTwo(b, c));
	}
	
	private static int minOfTwo(int a, int b){
		return a < b ? a : b;
	}

}
