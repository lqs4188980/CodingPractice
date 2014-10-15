package com.leetcode.divideTwoIntegers;

public class DivideTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(1, -1));
	}
	
    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        
        if (divisor == 2) {
            return dividend >> 1;
        }
        
        int negative = 0;
        long dvn = dividend;
        long dvs = divisor;
        
        if (dvn < 0) {
            dvn = ~dvn + 1;
            //System.out.println(dvn);
            negative ^= 1;
        }
        
        if (dvs < 0) {
            dvs = ~dvs + 1;
            //System.out.println(dvs);
            negative ^= 1;
        }
        
        int value = getDivision(dvn, dvs);
        if (negative == 1) {
            return (~value + 1);
        }
        return value;
    }
    
    private static int getDivision(long dividend, long divisor) {
        if (divisor == 1) {
            return (int)dividend;
        }
        
        int count = 0;
        long sub = divisor;
        int result = 0;
        while (dividend >= sub) {
            sub <<= 1;
            count++;
        }
        
        while (dividend >= divisor) {
        	//System.out.println(dividend);
            if (dividend >= sub) {
                dividend -= sub;
                result += 1 << count;
            }
            
            sub >>= 1;
            count--;
        }
        
        
        return result;
    }
}
