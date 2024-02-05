package algo.Pattern.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithMaxKDistictEle {
    
    static int findSubStringLengthWithMaxKDistictEle(String str, int k){
        if(str.length()==0 || k==0) return 0;
        Map<Character,Integer> map=new HashMap<>();
        int maxLength=Integer.MIN_VALUE;
        int windowStart=0;
        for (int i = 0; i <str.length(); i++) {
            Character rightChar=str.charAt(i);
            map.put(rightChar, map.getOrDefault(rightChar, 0)+1);

            if(map.size()>k){
                Character leftChar=str.charAt(windowStart);
                map.put(leftChar ,map.get(leftChar)-1);
                if(map.get(leftChar)==0) map.remove(leftChar);
                windowStart++;
            }

            maxLength= Math.max(maxLength,i-windowStart+1);
         }
         return maxLength;
    }
    public static void main(String[] args) {
       System.out.println(findSubStringLengthWithMaxKDistictEle("cbbebi", 3));
    }
}
