package com.leetcode.simplifyPath;

public class SimplifyPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(simplifyPath("/home/../../.."));
		
		

	}
	
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

}
