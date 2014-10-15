package com.leetcode.implementStrStr;

public class ImplementStrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strStr("aaa", "a"));
	}
	
    public static String strStr(String haystack, String needle) {
        if (haystack == null || needle == null || (haystack.length() != 0 && needle.length() == 0) || (needle.length() > haystack.length())) {
            return null;
        }
        
        if (haystack.length() == 0 && needle.length() == 0) {
            return haystack;
        }
        
        if (haystack.length() == 1 && needle.length() == 1) {
            if (haystack.charAt(0) == needle.charAt(0)) {
                return haystack;
            } else {
                return null;
            }
        }
        
        int hIndex = 0,
            nIndex = 0,
            hLength = haystack.length(),
            nLength = needle.length();
            
        int[] table = buildTable(needle);
        for (int i : table) {
        	System.out.print(i + " ");
        }
        
        System.out.print('\n');
        
        while (hIndex + nIndex < hLength) {
        	System.out.println(hIndex);
        	System.out.println(nIndex);
            if (haystack.charAt(hIndex + nIndex) == needle.charAt(nIndex)) {
                if (nIndex == nLength - 1) {
                    return haystack.substring(hIndex, hIndex + nIndex + 1);
                } else {
                    nIndex++;
                }
            } else {
                hIndex = hIndex + nIndex - table[nIndex];
                if (table[nIndex] > 0) {
                    nIndex = table[nIndex];
                } else {
                    nIndex = 0;
                }
            }
        }
        
        if (nIndex != nLength) {
            return null;
        } else {
            return haystack.substring(hIndex - nLength, hIndex);
        }
        
        
    }
    
    private static int[] buildTable(String needle) {
        int sIndex = 0,
            tIndex = 2,
            length = needle.length();
        int[] table = new int[length];
        
        table[0] = -1;
        if (length > 1) {
        	table[1] = 0;
        }
        while (tIndex < length) {
            
            // Prefix in a sub-pattern, so the fall back position start at the next position of the current sub-pattern
            if (needle.charAt(sIndex) == needle.charAt(tIndex - 1)) {
                sIndex++;
                table[tIndex] = sIndex;
                tIndex++;
            } else if (sIndex > 0) {
                // If not, fall back to previous sub-pattern starting index
                sIndex = table[sIndex];
            } else {
                // Still not in a sub-pattern, search next.
                table[tIndex] = 0;
                tIndex++;
            }
        }
        
        return table;
    }

}
