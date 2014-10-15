package com.leetcode.reverseInteger;

import java.util.LinkedList;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(reverse(123));
	}
	
	public static int reverse(int x) {
		if ((x < 10 && x >= 0) || (x > -10 && x <= 0)) {
            return x;
        }
        int num = x;
        if (x < 0) {
            num = -x;
        }
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int count = 0;
        int reverse = 0;
        while (num > 0) {
            queue.add(num % 10);
            num /= 10;
            count++;
        }
        
        count--;
        System.out.println(count);
        while (count > 0) {
        	int bit = queue.pop();
        	System.out.print(bit);
            reverse += Math.pow(bit, count);
        }
        reverse += queue.pop();
        
        if (x > 0) {
            return reverse;
        } else {
            return -reverse;
        }
    }

}
