package com.leetcode.simplifyPath;

import java.util.LinkedList;

public class SimplifyPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimplifyPath instance = new SimplifyPath();
		System.out.println(instance.simplifyPath("/.../"));
		
		

	}
	
	public String simplifyPath(String path) {
        // Try stack to record history
        StringBuilder simplePath = new StringBuilder();
        if (path == null || path == "") {
            simplePath.append("/");
            return simplePath.toString();
        }
        
        StringBuilder cache = new StringBuilder(path);
        LinkedList<String> pathStack = new LinkedList<String>();
        int start = 0;
        int length = cache.length();
        for (int i = 0; i < length; ++i) {
            if (cache.charAt(i) == '/') {
                String part = "/";
                if (start != i) {
                    part = cache.substring(start, i);
                }
                start = i;
         
                if (part.equals("/..") && pathStack.size() != 0) {
                	
                    pathStack.pollLast();
                    continue;
                } else if (part.equals("/..") && pathStack.size() == 0) {
                	continue;
                }
                
                if (!part.equals("/") && !part.equals("/.")) {
                    pathStack.add(part);
                }
                
            }
        }
        
        if (start < length) {
            String finalPart = cache.substring(start, length);
            if (finalPart.equals("/..") && pathStack.size() != 0) {
            	
                pathStack.pollLast();
            } else if (!finalPart.equals("/") && !finalPart.equals("/.") && !finalPart.equals("/..")) {
            	
                pathStack.add(finalPart);
            }
        }
        
        if (pathStack.size() == 0) {
            pathStack.add("/");
        }
        
        while (pathStack.size() > 0) {
            simplePath.append(pathStack.pop());
        }
        
        return simplePath.toString();
    }
/*	
    public static String simplifyPath(String path) {
        StringBuilder pathBuilder = new StringBuilder(path);
        int pathLength = pathBuilder.length();
        
        boolean isSlash = false;
        
        
        int[] slashPosition = new int[pathLength];
        int j = 0;
        
        // Append last slash
        pathBuilder.append('/');
        
        // Scan over all the chars
        for(int i = 0; i < pathBuilder.length(); i++){
        	char currentChar = pathBuilder.charAt(i);
        	if(currentChar == '/'){
        		if(isSlash){
        			pathBuilder.deleteCharAt(i);
        			i--;
        			continue;
        		}
        		else {
					slashPosition[j] = i;
					j++;
					isSlash = true;
					continue;
				}
        		
        	}
        	
        	// Dot follows a slash
        	if(currentChar == '.' && isSlash){
        		if(pathBuilder.charAt(i + 1) == '.' && pathBuilder.charAt(i + 2) == '/'){
        			if(j < 2){
        				pathBuilder.delete(slashPosition[j - 1] + 1, i + 3);
        				i = slashPosition[j - 1];
        				continue;
        			}
        			else {
						pathBuilder.delete(slashPosition[j - 2] + 1, i + 3);
						j = j - 1;
						i = slashPosition[j - 1];
						continue;
					}
        		}
        		if(pathBuilder.charAt(i + 1) == '/'){
        			pathBuilder.delete(i, i + 2);
        			i = slashPosition[j - 1];
        			continue;
        		}
        	}
        	if(isSlash){
        		isSlash = false;
        	}
        	
        }
        if(j > 1){
        	pathBuilder.deleteCharAt(slashPosition[j - 1]);
        }
        return pathBuilder.toString();
        
    }
*/
}
