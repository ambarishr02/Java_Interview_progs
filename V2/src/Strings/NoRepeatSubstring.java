package Strings;

import java.util.*;

//Given a string, find the length of the longest substring, which has no repeating characters.

class NoRepeatSubstring {
    public static int findLength(String str) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            // if the map already contains the 'rightChar', shrink the window from the beginning so that
            // we have only one occurrence of 'rightChar'
            if (charIndexMap.containsKey(rightChar)) {
                // this is tricky; in the current window, we will not have any 'rightChar' after its previous index
                // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }
            charIndexMap.put(rightChar, windowEnd); // insert the 'rightChar' into the map
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
        }

        return maxLength;
    }
    
    
     public static int findLengthv2(String str) {
    	 int  n=str.length();
    	 int res=0;
    	 
    
    	 for(int i=0;i<n;i++) {
    		 
    		boolean[] visited=new boolean[256];
    		
    		for(int j=i;j<n;j++) {
    			
    			if(visited[str.charAt(j)]==true)
    				break;
    			else {
    				res=Math.max(res, j-i+1);
    				visited[str.charAt(j)]=true;
    			}
    		}
    		 
    		visited[str.charAt(i)]=true;
    	 }
    	 return res;
     }
    

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abcbe"));
        System.out.println(""+NoRepeatSubstring.findLengthv2("abcbe"));
       // System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
       // System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
    }
}

