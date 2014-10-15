package com.leetcode.countAndSay;

import java.util.LinkedList;

public class CountAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(2));
	}
	
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        
        LinkedList<Character> queue = new LinkedList<Character>();
        
        queue.add('1');
        
        int i = 2,
            count = 0;
        char c = '-';
        while (i <= n) {
            int j = 0;
            int size = queue.size();
            while (j < size) {
                char buf = queue.poll();
                if (c == '-' && j == size - 1) {
                    addToQueue(buf, 1, queue);
                } else if (c != '-' && j == size - 1) {
                    if (c == buf) {
                        count++;
                        addToQueue(c, count, queue);
                    } else {
                        addToQueue(c, count, queue);
                        addToQueue(buf, 1, queue);
                    }
                    count = 0;
                } else if (c == '-' && j != size - 1){
                    c = buf;
                    count = 1;
                } else {
                    if (c == buf) {
                        count++;
                    } else {
                        addToQueue(c, count, queue);
                        c = buf;
                        count = 1;
                    }
                }
                
                j++;
            }
            c = '-';
            i++;
        }
        
        StringBuilder builder = new StringBuilder();
        int size = queue.size();
        for (char ch : queue) {
        	System.out.println(ch);
        }
        i = 0;
        while (i < size) {
            builder.append(queue.pollLast());
            i++;
        }
        
        return builder.toString();
    }
    
    private static void addToQueue(char c, int count, LinkedList<Character> queue) {
        queue.add(c);
        while (count > 0) {
            queue.add((char)(count % 10 + 48));
            count /= 10;
        }
    }

}
