package Mise;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class SubstringWIthNonRepeatingChar {
	
	 public static int Substring(String s){
		 Set<Character> charMap=new LinkedHashSet<>();
		 int longest=0;
	        for(int i=0;i<s.length();i++){
	        	charMap.add(s.charAt(i));
	        	int j=i+1;
	            while(j<s.length()) {
	            	if(charMap.contains(s.charAt(j))) {
	            		longest=j;
	            		System.out.println(charMap.toString());
	            		charMap.removeAll(charMap);
	            		break;
	            	}else {
	            		j++;
	            	}
	            }
	           
	        }
	        return longest;
	 }
	 
	 
	
	 static int longestUniqueSubsttr(String s)
	 {

	 	// Creating a set to store the last positions of occurrence
	 	HashMap<Character, Integer> seen = new HashMap<>();
	 	int maximum_length = 0;

	 	// starting the initial point of window to index 0
	 	int start = 0;

	 	for(int end = 0; end < s.length(); end++)
	 	{
	 	// Checking if we have already seen the element or not
	 	if(seen.containsKey(s.charAt(end)))
	 	{
	 		// If we have seen the number, move the start pointer
	 		// to position after the last occurrence
	 		start = Math.max(start, seen.get(s.charAt(end)) + 1);
	 	}

	 	// Updating the last seen value of the character
	 	seen.put(s.charAt(end), end);
	 	maximum_length = Math.max(maximum_length, end-start + 1);
	 	}
	 	return maximum_length;
	 }

	 

	 // This code is contributed by rutvik_56.

	 
	
	public static void main(String[] args) {
		String s = "geeksforgeeks";
	 	System.out.println("The input String is " + s);
	 	int length = longestUniqueSubsttr(s);
	//	System.out.println(Substring("HelloNms"));
	}

}
