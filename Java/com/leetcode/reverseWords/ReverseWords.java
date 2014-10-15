package com.leetcode.reverseWords;

public class ReverseWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverseWords("a");
	}
	
	
    public static String reverseWords(String s) {
        if(s == null)
            return null;
        if(s.length() == 0){
            return "";
        }
        StringBuilder sBuilder = new StringBuilder(s);
        StringBuilder buff = new StringBuilder("");
        
        boolean isSpace = false;
        int start = -1;
        int end = -1;
        int length = sBuilder.length();
        for(int i = length - 1; i >= 0; i--){
            char current = sBuilder.charAt(i);
            // sequence of spaces
            if(current != ' ' && isSpace){
                end = i;
                isSpace = false;
                continue;
            }
            // Last char is not space
            if(current != ' ' && (!isSpace) && i == (length - 1)){
                end = i;
                continue;
            }
            if(current == ' ' && (!isSpace)){
                // Last char is space
                if(i == (length - 1)){
                    isSpace = true;
                    continue;
                }
                else{
                    start = i + 1;
                    isSpace = true;
                    copyToBuff(sBuilder, buff, start, end);
                    start = -1;
                    end = -1;
                    continue;
                }
            }
        }
        // First char is not space
        if(start == -1 && end != -1){
            start = 0;
            copyToBuff(sBuilder, buff, start, end);
        }
        
        if(buff.length() == 0){
            return buff.toString();
        }
        
        System.out.println(buff.length());
        
        return buff.substring(0, buff.length() - 1);
    }
    
    private static void copyToBuff(StringBuilder origin, StringBuilder buff, int start, int end){
        for(int i = start; i <= end; i++){
        	System.out.println(origin.charAt(i));
            buff.append(origin.charAt(i));
        }
        buff.append(' ');
        
    }

}
