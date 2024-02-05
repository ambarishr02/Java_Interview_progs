package algo.Pattern.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithDistictChar {
    
    static int findLongestSubstringWithDistictChar(String str){
        if(str.length()==0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int windowStart=0;
        int maxLength=Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) {
            Character rightChar=str.charAt(i);
            if(map.containsKey(rightChar)){
               //windowStart++;
               windowStart=Math.max(windowStart, map.get(rightChar)+1);
            }
            map.put(rightChar, i);
            maxLength=Math.max(maxLength, i-windowStart+1);
        }

        return maxLength;
    }

    //aabccbb
    

    public static void main(String[] args) {
        String str="abccde"; //out put =3 str=abc;
        System.out.println(findLongestSubstringWithDistictChar(str));
    }
}
