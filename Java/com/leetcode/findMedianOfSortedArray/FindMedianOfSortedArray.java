package com.leetcode.findMedianOfSortedArray;

public class FindMedianOfSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static double findMedianSortedArrays(int A[], int B[]) {
		
		if(A.length == 0 && B.length != 0){
			if(B.length % 2 != 0){
				return (double)B[B.length / 2];
			}
			else {
				return (B[B.length / 2 - 1] + B[B.length / 2]) / 2.0;
			}
		}
		
		if(A.length != 0 && B.length == 0){
			if(A.length % 2 != 0){
				return (double)A[A.length / 2];
			}
			else {
				return (A[A.length / 2 - 1] + A[A.length / 2]) / 2.0;
			}
		}
		
		if(A.length == 0 && B.length == 0){
			return Double.MAX_VALUE;
		}
		
		
		return findMedian(A, 0, A.length - 1, B, 0, B.length - 1);
		
    }
	
	private static int max(int a, int b){
		return a > b ? a : b;
	}
	
	private static int min(int a, int b){
		return a < b ? a : b;
	}
	
	private static int findMedianOfThreeInteger(int a, int b, int c) {
		if(a >= b && b >= c && c <= a){
			return b;
		}
		if(a >= c && c >= b && b <= a){
			return c;
		}
		if(b >= a && a >= c && c <= b){
			return a;
		}
		if(b >= c && c >= a && a <= b){
			return c;
		}
		if(c >= a && a >= b && b <=c){
			return a;
		}
		if(c >= b && b >= a && a <= c){
			return b;
		}
		return -1;
	}
	
	private static double findMedianOfFourIntegers(int a, int b, int c, int d){
		return (a + b + c + d - max(a, max(b, max(c, d))) - min(a, min(b, min(c, d)))) / 2.0;
	}
	
	private static double findMedian(int A[], int startA, int endA, int B[], int startB, int endB){
		int lengthA = endA - startA + 1;
		int lengthB = endB - startB + 1;
		// Termination Conditions
		if(lengthA == lengthB){
			if(lengthA == 1){
				return (A[startA] + B[startB]) / 2.0;
			}
			if(lengthA == 2){
				return findMedianOfFourIntegers(A[startA], A[endA], B[startB], B[endB]);
			}
		}
		if(lengthA < lengthB){
			if(lengthA == 1){
				int medianIndexForB = lengthB / 2 + startB;
				if(lengthB % 2 != 0){
					return (B[medianIndexForB] + findMedianOfThreeInteger(B[medianIndexForB - 1], A[startA], B[medianIndexForB + 1])) / 2.0;
				}
				else {
					System.out.println("A[" + startA + "]=" + A[startA]);
					System.out.println("B[" + medianIndexForB + "]=" + B[medianIndexForB]);
					System.out.println("B[" + (medianIndexForB - 1) + "]=" + B[medianIndexForB - 1]);
					return (double)findMedianOfThreeInteger(B[medianIndexForB], A[startA], B[medianIndexForB - 1]);
				}
			}
			if(lengthA == 2){
				int medianIndexForB = lengthB / 2 + startB;
				if (lengthB % 2 != 0) {
					return (double)findMedianOfThreeInteger(B[medianIndexForB], max(A[startA], B[medianIndexForB - 1]), min(A[endA], B[medianIndexForB + 1]));
				}
				else {
					return findMedianOfFourIntegers(max(A[startA], B[medianIndexForB - 2]), B[medianIndexForB - 1], B[medianIndexForB], min(A[endA], B[medianIndexForB + 1]));
				}
			}
		}
		
		
		if(lengthA > lengthB){
			int medianIndexForA = lengthA / 2 + startA;
			if(lengthB == 1){
				if(lengthA % 2 != 0){
					return (findMedianOfThreeInteger(A[medianIndexForA - 1], B[startB], A[medianIndexForA + 1]) + A[medianIndexForA]) / 2.0;
				}
				else {
					return (double)findMedianOfThreeInteger(A[medianIndexForA], B[startB], A[medianIndexForA - 1]);
				}
			}
			if(lengthB == 2){
				if(lengthA % 2 != 0){
					return (double)findMedianOfThreeInteger(A[medianIndexForA], max(B[startB], A[medianIndexForA - 1]), min(B[endB], A[medianIndexForA + 1]));
				}
				else {
					return findMedianOfFourIntegers(max(B[startB], A[medianIndexForA - 2]), A[medianIndexForA - 1], A[medianIndexForA], min(B[endB], A[medianIndexForA + 1]));
				}
			}
		}
		
		
		// Normal
		double medianA = Integer.MAX_VALUE;
		
		double medianB = Integer.MAX_VALUE;
		
		// If A is odd length, there is only one median
		if(lengthA % 2 != 0){
			medianA = A[startA + lengthA / 2];
			
		}
		else {
			int rightMedian = startA + lengthA / 2;
			medianA = (A[rightMedian - 1] + A[rightMedian]) / 2.0;
			
		}
		// If B is odd length, there is only one median
		if(lengthB % 2 != 0){
			medianB = B[startB + lengthB / 2];
			
		}
		else {
			int rightMedian = startB + lengthB / 2;
			medianB = (B[rightMedian - 1] + B[rightMedian]) / 2.0;
			
		}
		
		// Decide how much elements will be disposed
		int desposedElements = 0;
		if(medianA <= medianB){
			if(lengthA % 2 != 0){
				desposedElements = min(lengthA / 2, lengthB - lengthB / 2 - 1);
			}
			else {
				desposedElements = min(lengthA / 2 - 1, lengthB - lengthB / 2 - 1);
			}
		}
		else {
			if(lengthB % 2 != 0){
				desposedElements = min(lengthB / 2, lengthA - lengthA / 2 - 1);
			}
			else {
				desposedElements = min(lengthB / 2 - 1, lengthA - lengthA / 2 - 1);
			}
		}
		System.out.println("The disposed elements is " + desposedElements);
		//int medianOffsideOfA = (lengthA - 1) / 2;
		//int medianOffsideOfB = (lengthB - 1) / 2;
		if(lengthA <= lengthB){
			if(medianA <= medianB){
				System.out.println("Going on search A[" + (desposedElements + startA) + ", " + endA + "] and B[" + startB + ", " + (endB - desposedElements) + "]");
				
				return findMedian(A, desposedElements + startA, endA, B, startB, endB - desposedElements);
			}
			else {
				System.out.println("Going on search A[" + startA + ", " + (endA - desposedElements) + "] and B[" + (startB + desposedElements) + ", " + endB + "]");
				return findMedian(A, startA, endA - desposedElements, B, startB + desposedElements, endB);
			}
		}
		else {
			if(medianA <= medianB){
				System.out.println("Going on search A[" + (startA + desposedElements) + ", " + endA + "] and B[" + startB + ", " + (endB - desposedElements) + "]");
				return findMedian(A, startA + desposedElements, endA, B, startB, endB - desposedElements);
			}
			else {
				System.out.println("Going on search A[" + startA + ", " + (endA - desposedElements) + "] and B[" + (startB + desposedElements) + ", " + endB + "]");
				return findMedian(A, startA, endA - desposedElements, B, startB + desposedElements, endB);
			}
		}
		
	}

}
