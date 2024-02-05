package algo.Pattern.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string with lowercase letters only, if you are allowed to replace
no more than k letters with any letter, find the length of the longest
substring having the same letters after replacement.
Input: String="aabccbb", k=2
Output: 5
Explanation: Replace the two 'c' with 'b' to have the longest repeatin
g substring "bbbbb".
*/

public class LongestSubstringhavingSameLetterWithKReplacements {

    static int findLongestSubStringWithSameLatter(String str, int k){
        if(str.length()==0) return 0;
        Map<Character, Integer> map=new HashMap<>();
        int windowStart=0;
        int maxLength=0;
        int maxRepeatLetters=0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            Character rightChar=str.charAt(windowEnd);
            map.put(rightChar,map.getOrDefault(rightChar,0)+1);
            maxRepeatLetters=Math.max(maxRepeatLetters, map.get(rightChar));

            int x=windowEnd - windowStart + 1 - maxRepeatLetters;// end-start+1 =windowsize ,  windowsize-Number of repeat character
            /**
             * In the selected window the number of non-repeating char is more means we need change the start
             *  suppose if i=5 and maxRep
             */
            if (x > k) {
                char leftChar = str.charAt(windowStart);
                map.put(leftChar, map.get(leftChar) - 1);
                windowStart++;
                }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
      
    public static void main(String[] args) {
        String str="aabccbb";
        int k=2;
       System.out.println(findLongestSubStringWithSameLatter(str,k));
    }
}
