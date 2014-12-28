package com.leetcode.multiplyStrings;

import java.util.Arrays;

public class MultiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiplyStrings instance = new MultiplyStrings();
		System.out.println(instance.multiply("140", "721"));
	}
	
	// A more concise solution
	public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0 || num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        // Processing Data
        StringBuilder n1 = new StringBuilder(num1);
        StringBuilder n2 = new StringBuilder(num2);
        n1.reverse();
        n2.reverse();
        
        int carry = 0;
        
        // result array
        char[] result = new char[n1.length() + n2.length() + 1];
        Arrays.fill(result, '0');
        
        int value = -1;
        for (int i = 0; i < n1.length(); ++i) {
            for (int j = 0; j < n2.length(); ++j) {
                value = (n1.charAt(i) - 48) * (n2.charAt(j) - 48) + carry + (result[i + j] - '0');
                result[i + j] = (char)(value % 10 + 48);
                carry = value / 10;
            }
            
            int index = i + n2.length();
            while (carry != 0) {
                value = carry + (result[index] - '0');
                result[index++] = (char)(value % 10 + 48);
                carry = value / 10;
            }
        }
        
        int start = Integer.MAX_VALUE;
        for (start = result.length - 1; start >= 0 && result[start] == '0'; --start) {
            
        }
        
        StringBuilder s = new StringBuilder();
        for (int i = start; i >= 0; --i) {
            s.append(result[i]);
        }
        
        return s.toString();
    }
	/* a correct solution
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0 || num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        // Processing Data
        int[] n1 = new int[num1.length()];
        int[] n2 = new int[num2.length()];
        for (int i = 0; i < n1.length; i++) {
            n1[i] = num1.charAt(i) - 48;
        }
        for (int i = 0; i < n2.length; i++) {
            n2[i] = num2.charAt(i) - 48;
        }
        DLinkedList list = new DLinkedList(0);
        int carry = 0;
        System.out.println("************************* Initialization **************************");
        // Initialization
        DLinkedList pt = list;
        for (int i = n1.length - 1; i >= 0; i--) {
        	System.out.println("++++++++++++++++++++++ Start ++++++++++++++++++++++++");
            int multiply = n1[i] * n2[0] + carry;
            System.out.println(n1[i] + " * " + n2[0]);
            DLinkedList node = new DLinkedList(multiply % 10);
            System.out.println(node.value);
            if (pt.next != null) {
                pt.next.prior = node;
                node.next = pt.next;
            } 
            pt.next = node;
            node.prior = pt;
            
            carry = multiply / 10;
            System.out.println("Carry = " + carry);
            System.out.println("++++++++++++++++++++++ End ++++++++++++++++++++++++");
        }
        if (carry != 0) {
            DLinkedList node = new DLinkedList(carry);
            pt.next.prior = node;
            node.next = pt.next;
            node.prior = pt;
            pt.next = node;
            carry = 0;
        }
        DLinkedList ptr = list;
        while (ptr.next != null) {
        	ptr = ptr.next;
        	System.out.print(ptr.value);
        }
        System.out.print('\n');
        // Calculation
        DLinkedList tail = list;
        while (tail.next != null) {
            tail = tail.next;
        }
        int lastOfn1 = n1.length - 1;
        for (int i = 1; i < n2.length; i++) {
            carry = 0;
            int value = n2[i] * n1[lastOfn1];
            DLinkedList node = new DLinkedList(value % 10);
            node.prior = tail;
            tail.next = node;
            tail = tail.next;
            carry = value / 10;
            DLinkedList tPt = tail.prior;
            
            for (int j = lastOfn1 - 1; j >= 0; j--) {
                value = tPt.value + n2[i] * n1[j] + carry;
                tPt.value = value % 10;
                carry = value / 10;
                tPt = tPt.prior;
            }
            
            while (carry > 0) {
                value = tPt.value + carry;
                tPt.value = value % 10;
                carry = value / 10;
                tPt = tPt.prior;
            }
            DLinkedList p = list;
            while (p.next != null) {
            	p = p.next;
            	System.out.print(p.value);
            }
            System.out.print('\n');
        }
        
        StringBuilder builder = new StringBuilder();
        if (list.value == -1) {
        	list = list.next;
        }
        while (list != null) {
            builder.append(list.value);
            list = list.next;
        }
        return builder.toString();
    }
	*/
}

/*
class DLinkedList {
    DLinkedList prior = null;
    DLinkedList next = null;
    int value;
    
    DLinkedList(int v) {
        value = v;
    }
}

*/