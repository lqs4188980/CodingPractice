package com.leetcode.divideTwoIntegers;

public class DivideTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DivideTwoIntegers instance = new DivideTwoIntegers();
		System.out.println(instance.divide(Integer.MIN_VALUE, -1));
	}
	
	public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        
        if (divisor == 2) {
            return dividend >> 1;
        }
        
        long dvn = dividend;
        long dvs = divisor;
        int negative = 0;
        
        if (dvn < 0) {
            negative ^= 1;
            dvn = ~dvn + 1;
        }
        
        if (dvs < 0) {
            negative ^= 1;
            dvs = ~dvs + 1;
        }
        
        long value = getDivide(dvn, dvs);
        
        if (negative == 1) {
            value = ~value + 1;
        }
        
        if (value >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        
        if (value <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        
        return (int)value;
    }
    
    private long getDivide(long dvn, long dvs) {
        if (dvn < dvs) {
            return 0;
        }
        
        int count = 0;
        long multi = dvs;
        while (dvn >= multi) {
            multi <<= 1;
            ++count;
        }
        
        long result = 0;
        while (dvn >= dvs) {
            if (dvn >= multi) {
                dvn -= multi;
                result += ((long)1 << count);
            }
            
            multi >>= 1;
            --count;
        }
        
        return result;
    }
}
