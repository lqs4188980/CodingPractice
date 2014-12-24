package com.leetcode.compareVersionNumbers;

public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
        // 1.2.3.3 vs 1.2.4.3
        if (version1 == null || 
            version2 == null || 
            version1.length() == 0 || 
            version2.length() == 0 || 
            version1.equals(version2)) {
            return 0;
        }
        
        int p1start = 0;
        int p1end = 0;
        int p2start = 0;
        int p2end = 0;
        int v1 = -1;
        int v2 = -1;
        while (p1end <= version1.length() && p2end <= version2.length()) {
            while (p1end < version1.length() && version1.charAt(p1end) != '.') {
                ++p1end;
            }
            v1 = Integer.parseInt(version1.substring(p1start, p1end));
            
            while (p2end < version2.length() && version2.charAt(p2end) != '.') {
                ++p2end;
            }
            v2 = Integer.parseInt(version2.substring(p2start, p2end));
            
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2){
                return -1;
            }
            
            p1start = ++p1end;
            p2start = ++p2end;
        }
        
        while (p1end <= version1.length()) {
            while (p1end < version1.length() && version1.charAt(p1end) != '.') {
                ++p1end;
            }
            if (Integer.parseInt(version1.substring(p1start, p1end)) > 0) {
                return 1;
            }
            
            p1start = ++p1end;
        }
        
        while (p2end <= version2.length()) {
            while (p2end < version2.length() && version2.charAt(p2end) != '.') {
                ++p2end;
            }
            if (Integer.parseInt(version2.substring(p2start, p2end)) > 0) {
                return -1;
            }
            
            p2start = ++p2end;
        }
        
        return 0;
    }
}
