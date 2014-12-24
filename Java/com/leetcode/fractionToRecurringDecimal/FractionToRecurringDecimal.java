package com.leetcode.fractionToRecurringDecimal;

import java.util.HashMap;

public class FractionToRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        
        StringBuilder builder = new StringBuilder();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            builder.append('-');
        }
        
        long n = numerator;
        long d = denominator;
        if (numerator < 0) {
            n *= -1;
        }
        if (denominator < 0) {
            d *= -1;
        }
        builder.append(n / d);
        if (n % d != 0) {
            builder.append('.');
            HashMap<Long, Integer> cp = new HashMap<Long, Integer>();
            long m = n % d;
            while (m != 0) {
                
                if (cp.containsKey(m)) {
                    // Repeat end
                    builder.insert(cp.get(m), "(");
                    builder.append(")");
                    break;
                } 
                
                cp.put(m, builder.length());
                m *= 10;
                builder.append(m / d);
                m %= d;
            }
            
            
        } 
        
        return builder.toString();
    }
}
