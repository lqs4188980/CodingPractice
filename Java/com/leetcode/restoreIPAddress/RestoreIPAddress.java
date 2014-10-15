package com.leetcode.restoreIPAddress;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (String s : restoreIpAddresses("010010")) {
			System.out.println(s);
		}
	}
	
	public static List<String> restoreIpAddresses(String s) {
        // IP address:
        // Each field length: 0 -> 3. Min length: length / 4
        // Each field range: 0 -> 255
        /*if (s.length() == 4) {
            StringBuilder b = new StringBuilder(s);
            b.insert(1, '.');
            b.insert(3, '.');
            b.insert(6, '.');
            LinkedList<String> list = new LinkedList<String>();
            list.add(b.toString());
            return list;
        }*/
        
        ArrayList<String> addrList = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12) {
            return addrList;
        }
        search(new StringBuilder(s), 0, 3, addrList, "");
        return addrList;
    }
    
    private static void search(StringBuilder s, int startIndex, int remainPart, ArrayList<String> addrList, String combo) {
        if (remainPart == 0) {
            if (s.length() - startIndex > 3
            	|| s.length() == startIndex
                || Integer.parseInt(s.substring(startIndex)) > 255 
                || (s.charAt(startIndex) == '0' && (Integer.parseInt(s.substring(startIndex)) > 0 || s.substring(startIndex).length() > 1))) {
                return;
            } else {
                addrList.add(combo + s.substring(startIndex));
                return;
            }
        }
        
        int offset = 1;
        while (offset <= 3 && (startIndex + offset < s.length())) {
            String field = s.substring(startIndex, startIndex + offset);
            int value = Integer.parseInt(field);
            if (value > 255 || (s.charAt(startIndex) == '0' && (value != 0 || field.length() > 1))) {
                return;
            } else {
                search(s, startIndex + offset, remainPart - 1, addrList, combo + field + '.');
                offset++;
                continue;
            }
        }
        
    }

}
