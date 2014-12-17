package com.leetcode.textJustification;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"Listen","to","many,","speak","to","a","few."};
		for (String s : fullJustify(words, 6)) {
			System.out.println(s);
		}
	}

	
	public static List<String> fullJustify(String[] words, int L) {
ArrayList<String> text = new ArrayList<String>();
        
        if (words == null) {
            return (List)text;
        }
        
        int chars = 0,
            wordCounter = 0,
            i = 0;
        StringBuilder builder = new StringBuilder();
        
        do {
            if (wordCounter == 0) {
                chars += words[i].length();
            } else {
                chars += (words[i].length() + 1);
            }
            
            wordCounter++;
            
            
            if (chars == L) {
                builder.append(words[i - wordCounter + 1]);
                for (int j = i - wordCounter + 2; j <= i; j++) {
                    builder.append(' ');
                    builder.append(words[j]);
                }
                text.add(builder.toString());
                builder = new StringBuilder();
                chars = 0;
                wordCounter = 0;
            } 
            if (chars > L) {
                chars -= (1 + words[i].length());
                i--;
                wordCounter--;
                
                
                int avgSpace = L - chars;
                int extSpace = 0;
                if (wordCounter > 1) {
                    avgSpace = (L - chars + (wordCounter - 1)) / (wordCounter - 1);
                    extSpace = (L - chars + (wordCounter - 1)) % (wordCounter - 1);
                }
                
                builder.append(words[i - wordCounter + 1]);
                if (wordCounter <= 1) {
                    for (int j = 0; j < avgSpace; j++) {
                        builder.append(' ');
                    }
                }
                
                for (int j = i - wordCounter + 2; j <= i; j++) {
                    for (int k = 0; k < avgSpace; k++) {
                        builder.append(' ');
                    }
                    if (extSpace > 0) {
                        builder.append(' ');
                        extSpace--;
                    }
                    builder.append(words[j]);
                }
                text.add(builder.toString());
                builder = new StringBuilder();
                chars = 0;
                wordCounter = 0;
            }
            
            i++;
        }while (i < words.length);
        
        if (wordCounter != 0) {
            if (chars == 0) {
                for (int j = 0; j < L; j++) {
                    builder.append(' ');
                }
                text.add(builder.toString());
                return (List)text;
            }
            
            for (int j = i - wordCounter; j < words.length; j++) {
                if (j == i - wordCounter) {
                    builder.append(words[j]);
                    continue;
                }
                builder.append(' ');
                builder.append(words[j]);
            }
            
            int extSpace = L - builder.length();
            for (int j = 0; j < extSpace; j++) {
                builder.append(' ');
            }
            text.add(builder.toString());
            
        }
        
        return (List)text;
	}
}
